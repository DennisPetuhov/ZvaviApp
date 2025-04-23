package ge.avalanche.zvavi.bulletin.data.datasource

import ge.avalancge.zvavi.database.dao.BulletinDao
import kotlinx.coroutines.flow.Flow

interface BulletinLocalDataSource {
    fun getBulletins(): Flow<List<Bulletin>>
    suspend fun saveBulletins(bulletins: List<Bulletin>)
    suspend fun clearBulletins()
    suspend fun getBulletinById(id: Int): Bulletin?
}
class BulletinLocalDataSource(
    private val bulletinDao: BulletinDao
) : BulletinLocalDataSource {
    override fun getBulletins(): Flow<List<Bulletin>> =
        bulletinDao.getBulletins().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun saveBulletins(bulletins: List<Bulletin>) {
        bulletinDao.insertBulletins(bulletins.map { it.toEntity() })
    }

    override suspend fun clearBulletins() {
        bulletinDao.clearBulletins()
    }

    override suspend fun getBulletinById(id: Int): Bulletin? =
        bulletinDao.getBulletinById(id)?.toDomain()
}