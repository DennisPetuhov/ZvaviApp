package ge.avalanche.zvavi.bulletin.data.datasource

import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.entities.BulletinEntity
import kotlinx.coroutines.flow.Flow

interface BulletinLocalDataSource {
    suspend fun getBulletins(): Flow<List<BulletinEntity>>
    suspend fun saveBulletin(bulletins: BulletinEntity)
    suspend fun clearBulletins()
    suspend fun getBulletinById(id: Int): BulletinEntity?
}

class BulletinLocalDataSourceImpl(
    val bulletinDao: BulletinDao
) : BulletinLocalDataSource {
    override suspend fun getBulletins(): Flow<List<BulletinEntity>> = bulletinDao.getBulletins()
    override suspend fun saveBulletin(bulletins: BulletinEntity) =
        bulletinDao.insertBulletins(bulletins)

    override suspend fun clearBulletins() = bulletinDao.clearBulletins()
    override suspend fun getBulletinById(id: Int): BulletinEntity? = bulletinDao.getBulletinById(id)
}