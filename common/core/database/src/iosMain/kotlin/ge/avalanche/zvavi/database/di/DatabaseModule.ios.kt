package ge.avalanche.zvavi.database.di

import ge.avalanche.zvavi.database.ZvaviDatabase
import ge.avalanche.zvavi.database.getDatabase
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import org.koin.core.module.Module
import org.koin.dsl.module

//
//actual val databaseModule: Module = module {
//    single<ZvaviDatabase> { getDatabase(get<DispatchersProvider>()) }
//    single { get<ZvaviDatabase>().getBulletinDao() }
//}