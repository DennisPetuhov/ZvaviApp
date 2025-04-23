package ge.avalanche.zvavi.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ge.avalancge.zvavi.database.ZvaviDatabase
import ge.avalancge.zvavi.database.dbFileName

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<ZvaviDatabase> {
    val applicationContext = context.applicationContext
    val databaseFile = applicationContext.getDatabasePath(dbFileName)
    return Room.databaseBuilder<ZvaviDatabase>(
        context = applicationContext,
        name = databaseFile.absolutePath
    )
}