package ge.avalanche.zvavi.bulletin.data.repository

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import kotlinx.coroutines.withContext

class BulletinRepositoryImpl(
    private val remoteDataSource: BulletinRemoteDataSource,
    private val dispatchers: DispatchersProvider
) : BulletinRepository {
    override suspend fun getBulletin(): List<BulletinItem> = emptyList()
}