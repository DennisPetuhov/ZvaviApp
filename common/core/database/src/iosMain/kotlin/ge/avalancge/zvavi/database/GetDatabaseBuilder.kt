package ge.avalancge.zvavi.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZvaviDatabase>
): ZvaviDatabase {
    val dbFilePath = NSHomeDirectory() + "/$dbFileName"
    return Room.databaseBuilder(
        name = dbFilePath,
        factory = { ZvaviDatabase::class.instantiateImpl() }
    )

}