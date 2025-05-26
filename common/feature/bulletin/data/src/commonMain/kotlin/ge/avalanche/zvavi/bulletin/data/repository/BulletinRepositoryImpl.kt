package ge.avalanche.zvavi.bulletin.data.repository

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.bulletin.data.domain.mapper.toDomain
import ge.avalanche.zvavi.bulletin.data.domain.mapper.toEntity
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.foundation.base.BaseRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import ge.avalanche.zvavi.foundation.network.onError
import ge.avalanche.zvavi.foundation.network.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BulletinRepositoryImpl(
    private val localDataSource: BulletinLocalDataSource,
    private val remoteDataSource: BulletinRemoteDataSource,
    val dao: BulletinDao,
    dispatchers: DispatchersProvider
) : BaseRepository(dispatchers, Logger.withTag("BulletinRepository")), BulletinRepository {
    override suspend fun fetchBulletin() {
        try {
            logger.d { "Fetching bulletin from remote" }
            val remoteResponse = withContext(dispatchers.io) {
                remoteDataSource.getBulletin()
            }
            println( "Fetching bulletin from remote $remoteResponse ")
            remoteResponse
                .onSuccess { bulletinApi ->
                    bulletinApi?.let { bulletinApi ->
                        logger.d { "Received bulletin from remote: $bulletinApi" }
                        withContext(dispatchers.io) {
                            try {
                                dao.clearBulletins()
                                localDataSource.saveBulletin(bulletinApi.toEntity())
                                logger.d { "Successfully saved bulletin to local database" }
                            } catch (e: Exception) {
                                logger.e(e) { "Failed to save bulletin to local database" }
                            }
                        }
                    } ?: run {
                        logger.w { "No bulletin data received from remote" }
                    }
                }
                .onError { code, message, details, exception ->
                    logger.e(exception) { "Failed to fetch bulletin from remote: $message" }
                }
        } catch (e: Exception) {
            logger.e(e) { "Unexpected error in getBulletin" }
        }
    }

    override suspend fun observeBulletin(): Flow<Bulletin> {
        logger.d { "Starting observeBulletin flow" }
        return localDataSource.getBulletins()
            .map { entities ->
                logger.d { "Emitting bulletin from local: $entities" }
                if (entities.isEmpty()) {
                    logger.w { "No entities found in local database" }
                }
                entities.lastOrNull()?.toDomain()
                    ?: throw NoDataException("No bulletin data available in local database")
            }
            .flowOn(dispatchers.io)
            .catch { e ->
                logger.e(e) { "Error in getBulletin flow" }
                throw e
            }
    }
}

class NoDataException(message: String) : Exception(message)