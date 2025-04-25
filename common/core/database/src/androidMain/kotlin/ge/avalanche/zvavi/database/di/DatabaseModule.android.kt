package ge.avalanche.zvavi.database.di

import android.content.Context
import ge.avalanche.zvavi.database.ZvaviDatabase
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.getDatabase
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.foundation.dispatchers.DispatchersProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

 val databaseModuleAndroid: Module =module {
    single <Context>{ applicationContext }
    single { this@PlatformConfiguration }
    single<ZvaviDatabase> { getDatabase(get(), get()) }
    single<BulletinDao> {
        get<ZvaviDatabase>().getBulletinDao()
    }
}
