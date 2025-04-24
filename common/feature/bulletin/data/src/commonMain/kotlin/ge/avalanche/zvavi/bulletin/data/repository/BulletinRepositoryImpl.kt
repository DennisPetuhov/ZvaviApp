package ge.avalanche.zvavi.bulletin.data.repository

import co.touchlab.kermit.Logger
import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.network.models.Bulletin
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.foundation.base.BaseRepository
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class BulletinRepositoryImpl(
    private val localDataSource: BulletinLocalDataSource,
    private val remoteDataSource: BulletinRemoteDataSource,
    dispatchers: DispatchersProvider
) : BaseRepository(dispatchers, Logger.withTag("BulletinRepository")), BulletinRepository {
//    override suspend fun getBulletin(): Flow<Bulletin> {
//        return emptyFlow<Bulletin>()
//    }
}