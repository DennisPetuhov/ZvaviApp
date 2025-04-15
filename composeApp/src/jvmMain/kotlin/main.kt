import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import ge.avalanche.zvavi.App

fun main() = application {
    Window(
        title = "ZvaviApp",
        state = rememberWindowState(width = 450.dp, height = 800.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(450, 800)
        App()
    }
}
