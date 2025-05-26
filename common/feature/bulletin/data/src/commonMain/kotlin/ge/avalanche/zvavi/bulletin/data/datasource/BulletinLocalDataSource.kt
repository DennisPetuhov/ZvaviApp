package ge.avalanche.zvavi.bulletin.data.datasource

import co.touchlab.kermit.Logger
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
    private val logger = Logger.withTag("BulletinLocalDataSource")

    override suspend fun getBulletins(): Flow<List<BulletinEntity>> {
        logger.d { "Getting bulletins from database" }
        return bulletinDao.getBulletins()
    }

    override suspend fun saveBulletin(bulletins: BulletinEntity) {
        logger.d { "Saving bulletin to database: $bulletins" }
        try {
            bulletinDao.clearBulletins()
            bulletinDao.insertBulletins(bulletins)
            logger.d { "Successfully saved bulletin to database" }
        } catch (e: Exception) {
            logger.e(e) { "Failed to save bulletin to database: ${e.message}" }
            throw e
        }
    }

    override suspend fun clearBulletins() {
        logger.d { "Clearing bulletins from database" }
        bulletinDao.clearBulletins()
    }

    override suspend fun getBulletinById(id: Int): BulletinEntity? {
        logger.d { "Getting bulletin by id: $id" }
        return bulletinDao.getBulletinById(id)
    }
}