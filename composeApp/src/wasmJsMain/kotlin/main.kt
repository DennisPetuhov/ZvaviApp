import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ge.avalanche.zvavi.App
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject

fun main() = application {
    val platformConfig = PlatformConfiguration()
    
    Inject.createDependencies(platformConfig) {
        // Additional modules can be added here if needed
    }
    
    Window(
        title = "ZvaviApp",
        onCloseRequest = ::exitApplication,
    ) {
        App(platformConfig)
    }
} 