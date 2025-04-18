package ge.avalanche.zvavi.bulletin.data.repository

import ge.avalanche.zvavi.bulletin.api.BulletinRepository
import ge.avalanche.zvavi.bulletin.api.models.BulletinItem
import ge.avalanche.zvavi.common.core.foundation.base.DispatchersProvider
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinEntity
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinLocalDataSource
import ge.avalanche.zvavi.bulletin.data.datasource.BulletinRemoteDataSource
import kotlinx.coroutines.withContext

class BulletinRepositoryImpl(
    private val remoteDataSource: BulletinRemoteDataSource,
    private val localDataSource: BulletinLocalDataSource,
    private val dispatchers: DispatchersProvider
) : BulletinRepository {
    override suspend fun getBulletin(): List<BulletinItem> = withContext(dispatchers.io) {
        // Try to get from local database first
        val localBulletin = localDataSource.getBulletin()
        
        if (localBulletin != null) {
            // If we have local data, return it immediately
            val localResult = listOf(localBulletin.toBulletinItem())
            
            // Then try to fetch fresh data from network in the background
            try {
                val remoteBulletins = remoteDataSource.getBulletin()
                if (remoteBulletins.isNotEmpty()) {
                    // Save the latest bulletin to local storage
                    localDataSource.saveBulletin(BulletinEntity.fromBulletinItem(remoteBulletins.first()))
                    return@withContext remoteBulletins
                }
            } catch (e: Exception) {
                // If network request fails, we already have local data
            }
            
            localResult
        } else {
            // If no local data, fetch from network
            val remoteBulletins = remoteDataSource.getBulletin()
            if (remoteBulletins.isNotEmpty()) {
                // Save to local storage
                localDataSource.saveBulletin(BulletinEntity.fromBulletinItem(remoteBulletins.first()))
                remoteBulletins
            } else {
                emptyList()
            }
        }
    }
} 