import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ge.avalanche.zvavi.App
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject
import java.awt.Dimension

fun main() = application {
    val platformConfig = PlatformConfiguration()
    
    Inject.createDependencies(platformConfig) {
        // Additional modules can be added here if needed
    }
    
    Window(
        title = "ZvaviApp",
        state = rememberWindowState(width = 450.dp, height = 800.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(450, 800)
        App(platformConfig)
    }
}
