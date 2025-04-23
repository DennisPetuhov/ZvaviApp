package ge.avalancge.zvavi.database

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider

fun getRoomDatabase(
    builder: RoomDatabase.Builder<ZvaviDatabase>,
    dispatchers: DispatchersProvider,
): ZvaviDatabase {
    return builder
        .fallbackToDestructiveMigration(dropAllTables = true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(dispatchers.io)
        .build()
}