package ge.avalanche.zvavi.database

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider

// Common database configuration that applies to all platforms
fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZvaviDatabase>,
    dispatchers: DispatchersProvider,
): ZvaviDatabase {
    return builder
//        .fallbackToDestructiveMigration()
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(dispatchers.io)
        .build()
}