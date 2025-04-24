package ge.avalanche.zvavi.database.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration


// expect val databaseModule: Module

// fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
//     startKoin {
//         appDeclaration()
//         modules(databaseModule)
//     }

// object Koin {
//     var di: KoinApplication? = null

//     fun setupKoin(appDeclaration: KoinAppDeclaration = {}) {
//         if (di == null) {
//             di = initKoin(appDeclaration)
//         }
//     }
// }