package ge.avalanche.zvavi.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.entities.BulletinEntity

internal const val dbFileName = "appzvavi.db"

@Database(entities = [BulletinEntity::class], version = 1)
@ConstructedBy(ZvaviDatabaseConstructor::class)
abstract class ZvaviDatabase : RoomDatabase() {
    abstract fun getBulletinDao(): BulletinDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ZvaviDatabaseConstructor : RoomDatabaseConstructor<ZvaviDatabase> {
    override fun initialize(): ZvaviDatabase
}

