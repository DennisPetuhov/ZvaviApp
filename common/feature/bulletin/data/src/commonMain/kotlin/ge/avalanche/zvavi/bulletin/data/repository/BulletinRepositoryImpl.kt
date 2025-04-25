package ge.avalanche.zvavi.bulletin.data.repository

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.bulletin.data.mapper.toDomain
import ge.avalanche.zvavi.bulletin.data.mapper.toEntity
import ge.avalanche.zvavi.foundation.base.BaseRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import ge.avalanche.zvavi.foundation.response.onError
import ge.avalanche.zvavi.foundation.response.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class BulletinRepositoryImpl(
    private val localDataSource: BulletinLocalDataSource,
    private val remoteDataSource: BulletinRemoteDataSource,
    dispatchers: DispatchersProvider
) : BaseRepository(dispatchers, Logger.withTag("BulletinRepository")), BulletinRepository {

    override suspend fun getBulletin(): Flow<Bulletin> = flow {
        try {
            // 1. Try to fetch from remote
            logger.d { "Fetching bulletin from remote" }
            val remoteResponse = withContext(dispatchers.io) {
                remoteDataSource.getBulletin()
            }
            // 2. Handle remote response
            remoteResponse
                .onSuccess { bulletinApis ->
                    // 3. Process remote data
                    bulletinApis.firstOrNull()?.let { bulletinApi ->
                        // 4. Save to local database and wait for completion
                        withContext(dispatchers.io) {
                            localDataSource.saveBulletin(bulletinApi.toEntity())
                        }
                    }
                }
                .onError { code, message, details, exception ->
                    logger.e(exception) { "Failed to fetch bulletin from remote: $message" }
                }
        } catch (e: Exception) {
            logger.e(e) { "Unexpected error in getBulletin" }
        }
        // 5. Always emit from local after remote operation (success or failure)
        localDataSource.getBulletins()
            .map { entities ->
                entities.firstOrNull()?.toDomain()
                    ?: throw NoDataException("No bulletin data available in local database")
            }
            .collect { bulletin ->
                emit(bulletin)
            }
    }
        .flowOn(dispatchers.io)
        .catch { e ->
            logger.e(e) { "Error in getBulletin flow" }
            throw e
        }
}

class NoDataException(message: String) : Exception(message)