package ge.avalanche.zvavi.bulletin.data.datasource

interface BulletinLocalDataSource {
    suspend fun getBulletin(): BulletinEntity?
    suspend fun saveBulletin(bulletin: BulletinEntity)
    suspend fun clearBulletin()
} 