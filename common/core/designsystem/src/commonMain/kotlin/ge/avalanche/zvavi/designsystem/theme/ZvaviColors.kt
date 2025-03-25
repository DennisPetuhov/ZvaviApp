package ge.avalanche.zvavi.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color as ZvaviColor

object ZvaviTheme {
    val colors: ZvaviColors
        @Composable
        get() = LocalColorProvider.current
}

val LocalColorProvider =
    staticCompositionLocalOf<ZvaviColors> { error("No default implementation") }

@Immutable
data class ZvaviColors(
    val brand100: ZvaviColor,
    val brand200: ZvaviColor,
    val brand300: ZvaviColor,
    val brand400: ZvaviColor,
    val brand500: ZvaviColor,
    val brand600: ZvaviColor,
    val brand700: ZvaviColor,
    val brand800: ZvaviColor,
    val brand900: ZvaviColor,
    val bellini100: ZvaviColor,
    val bellini200: ZvaviColor,
    val bellini300: ZvaviColor,
    val bellini400: ZvaviColor,
    val bellini500: ZvaviColor,
    val bellini600: ZvaviColor,
    val bellini700: ZvaviColor,
    val bellini800: ZvaviColor,
    val bellini900: ZvaviColor,
    val goose0: ZvaviColor,
    val goose100: ZvaviColor,
    val goose200: ZvaviColor,
    val goose300: ZvaviColor,
    val goose400: ZvaviColor,
    val goose500: ZvaviColor,
    val goose600: ZvaviColor,
    val goose700: ZvaviColor,
    val goose800: ZvaviColor,
    val goose900: ZvaviColor,
    val goose999: ZvaviColor,
    val negroni100: ZvaviColor,
    val negroni200: ZvaviColor,
    val negroni300: ZvaviColor,
    val negroni400: ZvaviColor,
    val negroni500: ZvaviColor,
    val negroni600: ZvaviColor,
    val negroni700: ZvaviColor,
    val negroni800: ZvaviColor,
    val negroni900: ZvaviColor,
    val prosecco100: ZvaviColor,
    val prosecco200: ZvaviColor,
    val prosecco300: ZvaviColor,
    val prosecco400: ZvaviColor,
    val prosecco500: ZvaviColor,
    val prosecco600: ZvaviColor,
    val prosecco700: ZvaviColor,
    val prosecco800: ZvaviColor,
    val prosecco900: ZvaviColor,
    val absinthe100: ZvaviColor,
    val absinthe200: ZvaviColor,
    val absinthe300: ZvaviColor,
    val absinthe400: ZvaviColor,
    val absinthe500: ZvaviColor,
    val absinthe600: ZvaviColor,
    val absinthe700: ZvaviColor,
    val absinthe800: ZvaviColor,
    val absinthe900: ZvaviColor,
    val curacao100: ZvaviColor,
    val curacao200: ZvaviColor,
    val curacao300: ZvaviColor,
    val curacao400: ZvaviColor,
    val curacao500: ZvaviColor,
    val curacao600: ZvaviColor,
    val curacao700: ZvaviColor,
    val curacao800: ZvaviColor,
    val curacao900: ZvaviColor
)


