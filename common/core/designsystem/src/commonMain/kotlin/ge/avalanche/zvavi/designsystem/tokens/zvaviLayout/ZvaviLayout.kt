package ge.avalanche.zvavi.designsystem.tokens.zvaviLayout

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import ge.avalanche.zvavi.designsystem.tokens.base.BaseDesktopLayout
import ge.avalanche.zvavi.designsystem.tokens.base.BaseMobileLayout
import ge.avalanche.zvavi.designsystem.tokens.base.BaseTabletLayout
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.tokens.layout.Layout

internal const val SIZE_SM = "sm"
internal const val SIZE_MD = "md"
internal const val SIZE_LG = "lg"
internal const val SIZE_XL = "xl"


@Immutable
object ZvaviLayout {
    @Immutable
    object ZvaviAndroid : BaseMobileLayout() {
        override val minWidth = Layout.Android.minWidth
        override val maxWidth = Layout.Android.maxWidthSm
        override val width = Layout.Android.widthSm
        override val height = Layout.Android.heightSm
        override val colNumber = Layout.Android.colNumberSm
        override val colWidth = Layout.Android.colWidthSm
        override val gutter = Layout.Android.gutterSm
    }

    @Immutable
    object ZvaviApple : BaseMobileLayout() {
        override val minWidth = Layout.IOS.minWidth
        override val maxWidth = Layout.IOS.maxWidthSm
        override val width = Layout.IOS.widthSm
        override val height = Layout.IOS.heightSm
        override val colNumber = Layout.IOS.colNumberSm
        override val colWidth = Layout.IOS.colWidthSm
        override val gutter = Layout.IOS.gutterSm
    }

    @Immutable
    object ZvaviMobile : BaseMobileLayout() {
        override val minWidth = Layout.Android.minWidth
        override val maxWidth = Layout.Android.maxWidthSm
        override val width = Layout.Android.widthSm
        override val height = Layout.Android.heightSm
        override val colNumber = Layout.Android.colNumberSm
        override val colWidth = Layout.Android.colWidthSm
        override val gutter = Layout.Android.gutterSm
    }

    @Immutable
    object ZvaviTabletPortrait : BaseTabletLayout() {
        override val breakpoint = "tablet-portrait"
        override val minWidth = getPlatformLayout(
            Layout.Android.breakpointMd,
            Layout.IOS.breakpointMd,
            Layout.Web.breakpointMd
        )
        override val maxWidth = getPlatformLayout(
            Layout.Android.maxWidthMd,
            Layout.IOS.maxWidthMd,
            Layout.Web.maxWidthMd
        )
        override val width = getPlatformLayout(
            Layout.Android.widthMd,
            Layout.IOS.widthMd,
            Layout.Web.widthMd
        )
        override val height = getPlatformLayout(
            Layout.Android.heightMd,
            Layout.IOS.heightMd,
            Layout.Web.heightMd
        )
        override val colNumber = getPlatformLayoutInt(
            Layout.Android.colNumberMd,
            Layout.IOS.colNumberMd,
            Layout.Web.colNumberMd
        )
        override val colWidth = getPlatformLayout(
            Layout.Android.colWidthMd,
            Layout.IOS.colWidthMd,
            Layout.Web.colWidthMd
        )
        override val gutter = getPlatformLayout(
            Layout.Android.gutterMd,
            Layout.IOS.gutterMd,
            Layout.Web.gutterMd
        )
    }

    @Immutable
    object ZvaviTabletLandscape : BaseTabletLayout() {
        override val breakpoint = "tablet-landscape"
        override val minWidth = getPlatformLayout(
            Layout.Android.breakpointLg,
            Layout.IOS.breakpointLg,
            Layout.Web.breakpointLg
        )
        override val maxWidth = getPlatformLayout(
            Layout.Android.maxWidthLg,
            Layout.IOS.maxWidthLg,
            Layout.Web.maxWidthLg
        )
        override val width = getPlatformLayout(
            Layout.Android.widthLg,
            Layout.IOS.widthLg,
            Layout.Web.widthLg
        )
        override val height = getPlatformLayout(
            Layout.Android.heightLg,
            Layout.IOS.heightLg,
            Layout.Web.heightLg
        )
        override val colNumber = getPlatformLayoutInt(
            Layout.Android.colNumberLg,
            Layout.IOS.colNumberLg,
            Layout.Web.colNumberLg
        )
        override val colWidth = getPlatformLayout(
            Layout.Android.colWidthLg,
            Layout.IOS.colWidthLg,
            Layout.Web.colWidthLg
        )
        override val gutter = getPlatformLayout(
            Layout.Android.gutterLg,
            Layout.IOS.gutterLg,
            Layout.Web.gutterLg
        )
    }

    @Immutable
    object ZvaviDesktop : BaseDesktopLayout() {
        override val breakpoint = "desktop"
        override val minWidth = Layout.Web.breakpointXl
        override val maxWidth = Layout.Web.maxWidthXl
        override val width = Layout.Web.widthXl
        override val height = Layout.Web.heightXl
        override val colNumber = Layout.Web.colNumberXl
        override val colWidth = Layout.Web.colWidthXl
        override val gutter = Layout.Web.gutterXl
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