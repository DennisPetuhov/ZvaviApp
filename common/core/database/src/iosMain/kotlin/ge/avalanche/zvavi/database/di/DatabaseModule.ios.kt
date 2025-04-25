package ge.avalanche.zvavi.database.di

import ge.avalanche.zvavi.database.ZvaviDatabase
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.getDatabase
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import org.koin.core.module.Module
import org.koin.dsl.module


 val databaseModuleIos: Module = module {
    single <ZvaviDatabase>{ getDatabase(get()) }
    single<BulletinDao> {
        get<ZvaviDatabase>().getBulletinDao()
    }
}