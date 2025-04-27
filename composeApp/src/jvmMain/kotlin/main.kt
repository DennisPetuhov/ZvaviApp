import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ge.avalanche.zvavi.App
import ge.avalanche.zvavi.ScreenSizeJvm.AppSettings
import ge.avalanche.zvavi.ScreenSizeJvm.LocalAppSettings
import ge.avalanche.zvavi.ScreenSizeJvm.WindowState
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject
import java.awt.Dimension

fun main() = application {
    val appSettings = remember { AppSettings() }
    val windowState = appSettings.windowState.collectAsState()
    val state = rememberWindowState(
        placement = WindowPlacement.Floating,
        size = DpSize(1024.dp, 768.dp),
        position = WindowPosition(Alignment.Center)
    )
    val platformConfig = PlatformConfiguration()

    Inject.createDependencies(platformConfig) {
        // Additional modules can be added here if needed
    }
    CompositionLocalProvider(LocalAppSettings provides appSettings) {
        Window(
            title = "ZvaviApp",
            state = state,
            onCloseRequest = ::exitApplication,
        ) {
            when (windowState) {
                WindowState.Maximized -> WindowPlacement.Maximized
                WindowState.Minimize -> WindowPlacement.Floating
                WindowState.FullScreen -> WindowPlacement.Fullscreen
                is WindowState.Custom -> {
                    state.placement = WindowPlacement.Floating
                    state.size = DpSize(windowState.width, windowState.height)
                }


            }
//            window.minimumSize = Dimension(450, 800)
            App(platformConfig)
        }
    }


}
