package ge.avalanche.zvavi.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.avalanche.zvavi.database.entities.BULLETIN_TABLE
import ge.avalanche.zvavi.database.entities.BulletinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BulletinDao {
    @Query("SELECT * FROM $BULLETIN_TABLE")
    fun getBulletins(): Flow<List<BulletinEntity>>

    @Query("SELECT * FROM $BULLETIN_TABLE WHERE id = :id")
    suspend fun getBulletinById(id: Int): BulletinEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBulletins(bulletins: BulletinEntity)

    @Query("DELETE FROM $BULLETIN_TABLE")
    suspend fun clearBulletins()
}