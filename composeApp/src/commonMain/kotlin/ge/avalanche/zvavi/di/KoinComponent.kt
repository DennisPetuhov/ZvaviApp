package ge.avalanche.zvavi.di


import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.stopKoin
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.KoinAppDeclaration

object Inject {
    private var _koin: Koin? = null
    val koin: Koin
        get() = requireNotNull(_koin) { "Koin is not initialized" }

    fun createDependencies(
        platformConfiguration: PlatformConfiguration,
        appDeclaration: KoinAppDeclaration
    ) {
        _koin = KoinApplication.init()
            .apply {
                modules(platformConfiguration.platformModule())
                appDeclaration()
            }
            .koin
    }

    inline fun <reified T> instance(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null
    ): T = koin.get(qualifier, parameters)

    fun clear() {
        stopKoin()
    }
}