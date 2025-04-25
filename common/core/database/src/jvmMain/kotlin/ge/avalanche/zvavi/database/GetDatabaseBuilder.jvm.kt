package ge.avalanche.zvavi.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import java.io.File

fun getDatabaseBuilder(dispatchers: DispatchersProvider): RoomDatabase.Builder<ZvaviDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), dbFileName)
    return Room.databaseBuilder<ZvaviDatabase>(
        name = dbFile.absolutePath
    ).apply {
        fallbackToDestructiveMigration(true)
            setDriver(BundledSQLiteDriver())
        setQueryCoroutineContext(dispatchers.io)
    }
}
fun getDatabase(dispatchers: DispatchersProvider): ZvaviDatabase {
    return getDatabaseBuilder(dispatchers).build()
}