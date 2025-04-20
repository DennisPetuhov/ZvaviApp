package ge.avalanche.zvavi.bulletin.data.datasource

import ge.avalanche.zvavi.bulletin.api.models.Bulletin
import ge.avalanche.zvavi.foundation.response.ApiResponse

interface BulletinLocalDataSource {
    suspend fun getBulletin(): BulletinEntity?
    suspend fun saveBulletin(bulletin: BulletinEntity)
    suspend fun clearBulletin()
} 