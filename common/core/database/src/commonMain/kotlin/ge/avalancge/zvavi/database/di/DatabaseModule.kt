package ge.avalancge.zvavi.database.di

import ge.avalancge.zvavi.database.ZvaviDatabase
import ge.avalancge.zvavi.database.getRoomDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<ZvaviDatabase> { getRoomDatabase(builder = get(), dispatchers = get()) }
}