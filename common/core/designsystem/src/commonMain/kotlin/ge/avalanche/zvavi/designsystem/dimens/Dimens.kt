package ge.avalanche.zvavi.designsystem.dimens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import androidx.compose.ui.graphics.Color as ZvaviColor

@Immutable
data object ZvaviRadius {
    val radius200 = 4.dp
    val radius300 = 8.dp
    val radius400 = 12.dp
    val radius500 = 16.dp
    val radius550 = 20.dp
    val radius600 = 24.dp
    val radius700 = 32.dp
    val radius999 = 999.dp
}

@Immutable
data object ZvaviSize {
    val size40 = 8.dp
    val size60 = 10.dp
    val size80 = 12.dp
    val size90 = 13.dp
    val size100 = 16.dp
    val size150 = 20.dp
    val size200 = 24.dp
    val size250 = 28.dp
    val size300 = 32.dp
    val size350 = 36.dp
    val size400 = 40.dp
    val size450 = 44.dp
    val size500 = 48.dp
    val size600 = 56.dp
    val size700 = 64.dp
    val size800 = 72.dp
    val size900 = 80.dp
}

@Immutable
data object ZvaviSpacing {
    // Spacing tokens from design system
    val spacing0 = 0.dp    // "0": { "value": "0" }
    val spacing25 = 1.dp   // "25": { "value": "1" }
    val spacing50 = 2.dp   // "50": { "value": "2" }
    val spacing100 = 4.dp  // "100": { "value": "4" }
    val spacing150 = 6.dp  // "150": { "value": "6" }
    val spacing200 = 8.dp  // "200": { "value": "8" }
    val spacing250 = 10.dp // "250": { "value": "10" }
    val spacing300 = 12.dp // "300": { "value": "12" }
    val spacing350 = 16.dp // "350": { "value": "16" }
    val spacing400 = 20.dp // "400": { "value": "20" }
    val spacing450 = 24.dp // "450": { "value": "24" }
    val spacing500 = 28.dp // "500": { "value": "28" }
    val spacing550 = 32.dp // "550": { "value": "32" }
    val spacing600 = 36.dp // "600": { "value": "36" }
    val spacing650 = 40.dp // "650": { "value": "40" }
    val spacing700 = 48.dp // "700": { "value": "48" }
    val spacing750 = 56.dp // "750": { "value": "56" }
    val spacing800 = 64.dp // "800": { "value": "64" }
    val spacing850 = 72.dp // "850": { "value": "72" }
    val spacing900 = 80.dp // "900": { "value": "80" }
}

@Immutable
data object Stroke {
    val stroke0 = 0.dp
    val stroke100 = 1.dp
    val stroke200 = 2.dp
    val stroke400 = 4.dp
}

@Immutable
object Shadows {
    val shadow100: Shadow
        @Composable get() = Shadow(
            color = ZvaviTheme.shadowColor as ZvaviColor,
            offset = Offset(0f, 4f),
            blurRadius = 8f
        )

    val shadow500: Shadow
        @Composable get() = Shadow(
            color = ZvaviTheme.shadowColor as ZvaviColor,
            offset = Offset(0f, 4f),
            blurRadius = 8f
        )

    val shadow900: Shadow
        @Composable get() = Shadow(
            color = ZvaviTheme.shadowColor as ZvaviColor,
            offset = Offset(0f, 4f),
            blurRadius = 8f
        )
}

object ZvaviAngle {
    val angle0 = 0f
    val angleMinus90 = -90f
}





