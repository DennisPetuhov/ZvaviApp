package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import ge.avalanche.zvavi.bulletin.data.di.bulletinDataModule
import ge.avalanche.zvavi.bulletin.presentation.di.bulletinPresentationModule
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.designsystem.theme.AppTheme
import ge.avalanche.zvavi.foundation.di.dispatchersProviderModule
import ge.avalanche.zvavi.foundation.logger.LoggerConfig
import ge.avalanche.zvavi.network.di.networkModule
import ge.avalanche.zvavi.splash.presentation.di.splashPresentationModule
import org.koin.compose.KoinApplication

@Composable
internal fun App(platformConfiguration: PlatformConfiguration) =
    KoinApplication(application = {
        LoggerConfig.initLogger()
        modules(
            platformConfiguration.platformModule(),
            dispatchersProviderModule,
            networkModule,
            bulletinDataModule,
            bulletinPresentationModule,
            splashPresentationModule
        )
    }) { AppTheme { ZvaviApp() } }
