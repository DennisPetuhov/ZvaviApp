package ge.avalanche.zvavi.database.platform

import ge.avalanche.zvavi.database.ZvaviDatabase
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual class PlatformConfiguration{
    actual fun platformModule(): Module= module {
        single <ZvaviDatabase>{ getDatabase(get()) }
        single<BulletinDao> {
            get<ZvaviDatabase>().getBulletinDao()
        }
    }
}
