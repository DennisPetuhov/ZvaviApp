package ge.avalanche.zvavi.database.platform

import ge.avalanche.zvavi.database.di.databaseModuleIos
import org.koin.core.module.Module

actual class PlatformConfiguration {
    actual fun platformModule(): Module = databaseModuleIos
}