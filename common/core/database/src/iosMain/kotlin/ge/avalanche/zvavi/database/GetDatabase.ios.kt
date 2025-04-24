package ge.avalanche.zvavi.database

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import platform.Foundation.NSHomeDirectory

fun getDatabase(dispatchers: DispatchersProvider): ZvaviDatabase {
    return getDatabaseBuilder(dispatchers).build()
}

// iOS-specific implementation of the database builder
fun getDatabaseBuilder(dispatchers: DispatchersProvider): RoomDatabase.Builder<ZvaviDatabase> {
    val dbFilePath = NSHomeDirectory() + "/${dbFileName}"
    return Room.databaseBuilder<ZvaviDatabase>(
        name = dbFilePath
    ).apply {
        // Add any iOS-specific configurations here
        setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(dispatchers.io)
    }
} 