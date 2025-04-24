import androidx.compose.ui.window.ComposeUIViewController
import ge.avalanche.zvavi.App
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject
import ge.avalanche.zvavi.foundation.logger.LoggerConfig
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {  
    LoggerConfig.initLogger()
    
    val platformConfig = PlatformConfiguration()
    
    Inject.createDependencies(platformConfig) {
        // Additional modules can be added here if needed
    }
    
    return ComposeUIViewController { App(platformConfig) }
}
