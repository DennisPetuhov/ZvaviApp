package ge.avalanche.zvavi.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider

fun getDatabase(context: Context, dispatchers: DispatchersProvider): ZvaviDatabase {
    return getDatabaseBuilder(context, dispatchers).build()
}

fun getDatabaseBuilder(
    context: Context,
    dispatchers: DispatchersProvider
): RoomDatabase.Builder<ZvaviDatabase> {
    val applicationContext = context.applicationContext
    val databaseFile = applicationContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<ZvaviDatabase>(
        context = applicationContext,
        name = databaseFile.absolutePath
    ).apply {
        setDriver(BundledSQLiteDriver())
        setQueryCoroutineContext(dispatchers.io)
        fallbackToDestructiveMigration(dropAllTables = true)
    }
} 