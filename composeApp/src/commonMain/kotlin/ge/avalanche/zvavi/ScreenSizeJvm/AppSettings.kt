package ge.avalanche.zvavi.ScreenSizeJvm

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppSettings {
    private val _windowSize: MutableStateFlow<WindowState> =
        MutableStateFlow(WindowState.Custom(1024.dp, 768.dp))
    val windowState: StateFlow<WindowState> = _windowSize
    fun updateWindowState(newState: WindowState) {
        _windowSize.value = newState
    }
}
val LocalAppSettings = staticCompositionLocalOf<AppSettings> {
    error("No AppSettings provided")
}