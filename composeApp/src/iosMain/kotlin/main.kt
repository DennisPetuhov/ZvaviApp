import androidx.compose.ui.window.ComposeUIViewController
import ge.avalanche.zvavi.App
import ge.avalanche.zvavi.foundation.logger.LoggerConfig
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {  LoggerConfig.initLogger()
    return ComposeUIViewController { App() }}
