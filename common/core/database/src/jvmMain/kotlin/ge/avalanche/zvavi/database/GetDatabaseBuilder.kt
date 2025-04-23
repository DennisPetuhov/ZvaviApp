package ge.avalanche.zvavi.database

import androidx.room.Room
import androidx.room.RoomDatabase
import ge.avalancge.zvavi.database.ZvaviDatabase
import ge.avalancge.zvavi.database.dbFileName
import java.io.File

fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZvaviDatabase>
): ZvaviDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<ZvaviDatabase>(name = dbFile.absolutePath)

}