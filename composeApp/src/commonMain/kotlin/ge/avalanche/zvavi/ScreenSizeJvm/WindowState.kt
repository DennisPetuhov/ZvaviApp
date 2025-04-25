package ge.avalanche.zvavi.ScreenSizeJvm

import androidx.compose.ui.unit.Dp

sealed class WindowState {
   data object Maximized : WindowState()
   data object FullScreen : WindowState()
   data object Minimize : WindowState()
 data    class Custom(val width:Dp, val height:Dp) : WindowState()

}