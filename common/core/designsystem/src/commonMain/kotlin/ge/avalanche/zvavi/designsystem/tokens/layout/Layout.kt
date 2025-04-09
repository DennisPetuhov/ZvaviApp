package ge.avalanche.zvavi.designsystem.tokens.layout

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing

// layout folder in json
@Immutable
internal object Layout {
    object Android {
        val breakpointSm = 0.dp
        val breakpointMd = 600.dp
        val breakpointLg = 840.dp
        val breakpointXl = 1200.dp

        val colNumberSm = 12
        const val colNumberMd = 12
        const val colNumberLg = 12
        const val colNumberXl = 12

        val colWidthSm = 0.dp
        val colWidthMd = 0.dp
        val colWidthLg = 0.dp
        val colWidthXl = 0.dp

        val gutterSm = ZvaviSpacing.spacing350
        val gutterMd = ZvaviSpacing.spacing350
        val gutterLg = ZvaviSpacing.spacing400
        val gutterXl = ZvaviSpacing.spacing450
        val minWidth = 360.dp
        val maxWidthSm = (breakpointMd - 1.dp)
        val maxWidthMd = (breakpointLg - 1.dp)
        val maxWidthLg = (breakpointXl - 1.dp)
        val maxWidthXl = 1920.dp

        val widthSm = minWidth
        val widthMd = breakpointMd
        val widthLg = breakpointLg
        val widthXl = breakpointXl

        val heightSm = 640.dp
        val heightMd = breakpointLg
        val heightLg = breakpointMd
        val heightXl = breakpointLg
    }

    internal object IOS {
        val breakpointSm = 440.dp
        val breakpointMd = 768.dp
        val breakpointLg = 1024.dp
        val breakpointXl = 1366.dp

        val colNumberSm = 12
        val colNumberMd = 12
        val colNumberLg = 12
        val colNumberXl = 12

        val colWidthSm = 0.dp
        val colWidthMd = 0.dp
        val colWidthLg = 0.dp
        val colWidthXl = 0.dp

        val gutterSm = ZvaviSpacing.spacing350
        val gutterMd = ZvaviSpacing.spacing350
        val gutterLg = ZvaviSpacing.spacing400
        val gutterXl = ZvaviSpacing.spacing450

        val minWidth = 375.dp
        val maxWidthSm = (breakpointMd - 1.dp)
        val maxWidthMd = (breakpointLg - 1.dp)
        val maxWidthLg = (breakpointXl - 1.dp)
        val maxWidthXl = 1920.dp

        val widthSm = minWidth
        val widthMd = breakpointMd
        val widthLg = breakpointLg
        val widthXl = breakpointXl

        val heightSm = 812.dp
        val heightMd = breakpointLg
        val heightLg = breakpointMd
        val heightXl = breakpointLg
    }

    @Immutable
    object Web {
        val breakpointSm = 576.dp
        val breakpointMd = 768.dp
        val breakpointLg = 992.dp
        val breakpointXl = 1200.dp

        // Column numbers
        val colNumberSm = 12
        val colNumberMd = 12
        val colNumberLg = 12
        val colNumberXl = 12

        // Column widths
        val colWidthSm = 0.dp
        val colWidthMd = 0.dp
        val colWidthLg = 0.dp
        val colWidthXl = 0.dp

        // Gutters
        val gutterSm = ZvaviSpacing.spacing350
        val gutterMd = ZvaviSpacing.spacing350
        val gutterLg = ZvaviSpacing.spacing400
        val gutterXl = ZvaviSpacing.spacing450

        // Min and max widths
        val minWidth = 360.dp
        val maxWidthSm = (breakpointMd - 1.dp)
        val maxWidthMd = (breakpointLg - 1.dp)
        val maxWidthLg = (breakpointXl - 1.dp)
        val maxWidthXl = 1920.dp

        // Widths
        val widthSm = minWidth
        val widthMd = breakpointMd
        val widthLg = breakpointLg
        val widthXl = breakpointXl

        // Heights
        val heightSm = 800.dp
        val heightMd = 800.dp
        val heightLg = 800.dp
        val heightXl = 800.dp
    }
}