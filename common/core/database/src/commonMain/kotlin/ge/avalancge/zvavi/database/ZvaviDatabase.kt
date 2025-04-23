package ge.avalancge.zvavi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ge.avalancge.zvavi.database.dao.BulletinDao
import ge.avalancge.zvavi.database.entities.BulletinEntity

@Database(entities = [BulletinEntity::class], version = 1)
abstract class ZvaviDatabase : RoomDatabase(){
    abstract fun getBulletinDao(): BulletinDao

}

internal const val dbFileName = "appzvavi.db"