package ge.avalanche.zvavi.designsystem.effect

import androidx.compose.runtime.staticCompositionLocalOf
import ge.avalanche.zvavi.designsystem.opacity.ZvaviOpacity
import ge.avalanche.zvavi.designsystem.theme.LightPalette
import androidx.compose.ui.graphics.Color as ZvaviColor

val LocalShadowColorProvider =
    staticCompositionLocalOf<ZvaviShadowColor> { error("No default implementation") }

class ZvaviShadowColor(
    val shadow100: ZvaviColor,
    val shadow500: ZvaviColor,
    val shadow900: ZvaviColor,
)

val LightShadow = ZvaviShadowColor(
    shadow100 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowLight100),
    shadow500 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowLight500),
    shadow900 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowLight900),
)
val DarkShadow = ZvaviShadowColor(
    shadow100 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowDark100),
    shadow500 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowDark500),
    shadow900 = LightPalette.goose999.copy(alpha = ZvaviOpacity.opacityEffectShadowDark900),
)