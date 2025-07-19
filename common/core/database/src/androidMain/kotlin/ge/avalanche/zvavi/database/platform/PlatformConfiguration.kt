package ge.avalanche.zvavi.database.platform

import android.content.Context
import ge.avalanche.zvavi.database.ZvaviDatabase
import ge.avalanche.zvavi.database.dao.BulletinDao
import ge.avalanche.zvavi.database.getDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual class PlatformConfiguration(
    private val applicationContext: Context
) {
    actual fun platformModule(): Module = module {
        single { this@PlatformConfiguration }
        single<Context> { applicationContext }
        single<ZvaviDatabase> { getDatabase(get(), get()) }
        single<BulletinDao> {
            get<ZvaviDatabase>().getBulletinDao()
        }
    }
}