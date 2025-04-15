package ge.avalanche.zvavi.designsystem.tokens.zvaviLayout

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import ge.avalanche.zvavi.designsystem.tokens.base.BaseDesktopLayout
import ge.avalanche.zvavi.designsystem.tokens.base.BaseMobileLayout
import ge.avalanche.zvavi.designsystem.tokens.base.BaseTabletLayout
import ge.avalanche.zvavi.designsystem.tokens.base.BaseTabletLandscapeLayout
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.tokens.layout.Layout

internal const val SIZE_SM = "sm"
internal const val SIZE_MD = "md"
internal const val SIZE_LG = "lg"
internal const val SIZE_XL = "xl"
internal const val SIZE_XXL = "xxl"


@Immutable
object ZvaviLayout {
    @Immutable
    object ZvaviAndroid : BaseMobileLayout() {
        override val minWidth = Layout.Android.minWidth // 360.dp
        override val maxWidth = Layout.Android.maxWidthSm // 599.dp
        override val width = Layout.Android.widthSm // 360.dp
        override val height = Layout.Android.heightSm // 640.dp
        override val colNumber = Layout.Android.colNumberSm // 12
        override val colWidth = Layout.Android.colWidthSm // 0.dp
        override val gutter = Layout.Android.gutterSm // 16.dp (spacing350)
    }

    @Immutable
    object ZvaviApple : BaseMobileLayout() {
        override val minWidth = Layout.IOS.minWidth // 375.dp
        override val maxWidth = Layout.IOS.maxWidthSm // 767.dp
        override val width = Layout.IOS.widthSm // 375.dp
        override val height = Layout.IOS.heightSm // 812.dp
        override val colNumber = Layout.IOS.colNumberSm // 12
        override val colWidth = Layout.IOS.colWidthSm // 0.dp
        override val gutter = Layout.IOS.gutterSm // 16.dp (spacing350)
    }

    @Immutable
    object ZvaviMobile : BaseMobileLayout() {
        override val minWidth = Layout.Android.minWidth // 360.dp
        override val maxWidth = Layout.Android.maxWidthSm // 599.dp
        override val width = Layout.Android.widthSm // 360.dp
        override val height = Layout.Android.heightSm // 640.dp
        override val colNumber = Layout.Android.colNumberSm // 12
        override val colWidth = Layout.Android.colWidthSm // 0.dp
        override val gutter = Layout.Android.gutterSm // 16.dp (spacing350)
    }

    @Immutable
    object ZvaviTabletPortrait : BaseTabletLayout() {
        override val breakpoint = "tablet-portrait"
        override val minWidth = getPlatformLayout(
            Layout.Android.breakpointLg, // 840.dp
            Layout.IOS.breakpointLg, // 1024.dp
            Layout.Web.breakpointLg // 992.dp
        )
        override val maxWidth = getPlatformLayout(
            Layout.Android.maxWidthXl, // 1199.dp
            Layout.IOS.maxWidthXl, // 1365.dp
            Layout.Web.maxWidthXl // 1199.dp
        )
        override val width = getPlatformLayout(
            Layout.Android.widthMd, // 600.dp
            Layout.IOS.widthMd, // 768.dp
            Layout.Web.widthMd // 768.dp
        )
        override val height = getPlatformLayout(
            Layout.Android.heightMd, // 840.dp
            Layout.IOS.heightMd, // 1024.dp
            Layout.Web.heightMd // 800.dp
        )
        override val colNumber = getPlatformLayoutInt(
            Layout.Android.colNumberMd, // 12
            Layout.IOS.colNumberMd, // 12
            Layout.Web.colNumberMd // 12
        )
        override val colWidth = getPlatformLayout(
            Layout.Android.colWidthMd, // 0.dp
            Layout.IOS.colWidthMd, // 0.dp
            Layout.Web.colWidthMd // 0.dp
        )
        override val gutter = getPlatformLayout(
            Layout.Android.gutterMd, // 16.dp (spacing350)
            Layout.IOS.gutterMd, // 16.dp (spacing350)
            Layout.Web.gutterMd // 16.dp (spacing350)
        )
    }

    @Immutable
    object ZvaviTabletLandscape : BaseTabletLandscapeLayout() {
        override val breakpoint = "tablet-landscape"
        override val minWidth = getPlatformLayout(
            Layout.Android.maxWidthLg, // 1200.dp
            Layout.IOS.breakpointXl, // 1366.dp
            Layout.Web.breakpointXl // 1200.dp
        )
        override val maxWidth = getPlatformLayout(
            Layout.Android.maxWidthXl, // 1199.dp
            Layout.IOS.maxWidthXl, // 1365.dp
            Layout.Web.maxWidthXl // 1199.dp
        )
        override val width = getPlatformLayout(
            Layout.Android.widthXl, // 1200.dp
            Layout.IOS.widthXl, // 1366.dp
            Layout.Web.widthXl // 1200.dp
        )
        override val height = getPlatformLayout(
            Layout.Android.heightXl, // 840.dp
            Layout.IOS.heightXl, // 1024.dp
            Layout.Web.heightXl // 800.dp
        )
        override val colNumber = getPlatformLayoutInt(
            Layout.Android.colNumberXl, // 12
            Layout.IOS.colNumberXl, // 12
            Layout.Web.colNumberXl // 12
        )
        override val colWidth = getPlatformLayout(
            Layout.Android.colWidthXl, // 0.dp
            Layout.IOS.colWidthXl, // 0.dp
            Layout.Web.colWidthXl // 0.dp
        )
        override val gutter = getPlatformLayout(
            Layout.Android.gutterXl, // 18.dp (spacing450)
            Layout.IOS.gutterXl, // 18.dp (spacing450)
            Layout.Web.gutterXl // 18.dp (spacing450)
        )
    }

    @Immutable
    object ZvaviDesktop : BaseDesktopLayout() {
        override val breakpoint = "desktop"
        override val minWidth = Layout.Web.breakpointXxl // 1600.dp
        override val maxWidth = Layout.Web.maxWidthXxl // 1920.dp
        override val width = Layout.Web.widthXxl // 1600.dp
        override val height = Layout.Web.heightXxl // 800.dp
        override val colNumber = Layout.Web.colNumberXxl // 12
        override val colWidth = Layout.Web.colWidthXxl // 0.dp
        override val gutter = Layout.Web.gutterXxl // 20.dp (spacing500)
    }
    
    @Immutable
    object ZvaviXxl : BaseDesktopLayout() {
        override val breakpoint = "xxl"
        override val minWidth = Layout.Web.breakpointXxl // 1600.dp
        override val maxWidth = Layout.Web.maxWidthXxl // 1920.dp
        override val width = Layout.Web.widthXxl // 1600.dp
        override val height = Layout.Web.heightXxl // 800.dp
        override val colNumber = Layout.Web.colNumberXxl // 12
        override val colWidth = Layout.Web.colWidthXxl // 0.dp
        override val gutter = Layout.Web.gutterXxl // 20.dp (spacing500)
    }
}

private fun getPlatformLayout(
    android: Dp,
    apple: Dp,
    web: Dp
): Dp = when (getPlatform()) {
    "ANDROID" -> android
    "iOS" -> apple
    else -> web
}

private fun getPlatformLayoutInt(
    android: Int,
    apple: Int,
    web: Int
): Int = when (getPlatform()) {
    "ANDROID" -> android
    "iOS" -> apple
    else -> web
}