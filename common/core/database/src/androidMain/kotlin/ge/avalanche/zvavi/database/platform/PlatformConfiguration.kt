package ge.avalanche.zvavi.database.platform

import android.content.Context
import ge.avalanche.zvavi.database.di.databaseModuleAndroid
import org.koin.core.module.Module

actual class PlatformConfiguration(
    private val applicationContext: Context
) {
    actual fun platformModule(): Module = databaseModuleAndroid
}

