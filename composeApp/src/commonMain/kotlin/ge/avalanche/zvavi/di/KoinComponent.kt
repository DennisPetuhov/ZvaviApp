package ge.avalanche.zvavi.di


import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.core.component.get
import org.koin.core.context.KoinContext
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.KoinAppDeclaration
import org.koin.mp.KoinPlatformTools
import ge.avalanche.zvavi.database.platform.PlatformConfiguration

//object Inject : KoinComponent {
//
//    fun init(modules: List<Module>) {
//        stopKoin()
//        startKoin {
//            modules(modules)
//        }
//    }
//
//    inline fun <reified T> instance(): T = get()
//
//}
object Inject {
    private var _koin: Koin? = null

    val koin: Koin
        get() = requireNotNull(_koin) { "Koin is not initialized" }

    fun createDependencies(platformConfiguration: PlatformConfiguration, appDeclaration: KoinAppDeclaration) {
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

    inline fun <reified T> instance1(
        noinline parameters: ParametersDefinition? = null
    ): T = KoinPlatformTools.defaultContext().get().get(parameters = parameters)

}



//
//
//// Usage example:
//val modules = listOf(
//    module {
//        single { Database() }
//        single { Repository(get()) }
//    }
//)
//
//Inject.init(modules)
//
//// Get dependencies anywhere:
//val db = Inject.instance<Database>()