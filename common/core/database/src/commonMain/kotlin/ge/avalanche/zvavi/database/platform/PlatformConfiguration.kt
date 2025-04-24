package ge.avalanche.zvavi.database.platform

import org.koin.core.module.Module

expect class PlatformConfiguration {
    fun platformModule(): Module
}
