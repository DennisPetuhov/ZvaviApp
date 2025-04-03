package ge.avalanche.zvavi.designsystem.zvaviLayout

import androidx.compose.runtime.Immutable
import ge.avalanche.zvavi.designsystem.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.getPlatform

// semantics main layout
@Immutable
object ZvaviLayout {
    @Immutable
    object ZvaviAndroid {
        val breakpoint = "mobile"

        val minWidth = Layout.Android.minWidth
        val maxWidth = Layout.Android.maxWidthSm
        val width = Layout.Android.widthSm
        val height = Layout.Android.heightSm

        val colNumber = Layout.Android.colNumberSm
        val colWidth = Layout.Android.colWidthSm
        val gutter = Layout.Android.gutterSm

        val marginHorizontal = ZvaviSpacing.spacing100
        val contentCompensation = ZvaviSpacing.spacing350

        val ignoreMarginHorizontal = -marginHorizontal
    }

    @Immutable
    object ZvaviApple {
        val breakpoint = "mobile"

        val minWidth = Layout.Apple.minWidth
        val maxWidth = Layout.Apple.maxWidthSm
        val width = Layout.Apple.widthSm
        val height = Layout.Apple.heightSm

        val colNumber = Layout.Apple.colNumberSm
        val colWidth = Layout.Apple.colWidthSm
        val gutter = Layout.Apple.gutterSm

        val marginHorizontal = ZvaviSpacing.spacing100
        val contentCompensation = ZvaviSpacing.spacing350

        val ignoreMarginHorizontal = -marginHorizontal
    }

    @Immutable
    object ZvaviMobile {
        val breakpoint = "mobile"

        val minWidth = Layout.Android.minWidth
        val maxWidth = Layout.Android.maxWidthSm
        val width = Layout.Android.widthSm
        val height = Layout.Android.heightSm

        val colNumber = Layout.Android.colNumberSm
        val colWidth = Layout.Android.colWidthSm
        val gutter = Layout.Android.gutterSm

        val marginHorizontal = ZvaviSpacing.spacing100
        val contentCompensation = ZvaviSpacing.spacing350

        val ignoreMarginHorizontal = -marginHorizontal
    }

    @Immutable
    object ZvaviTabletPortrait {
        val breakpoint = "tablet-portrait"

        val minWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.breakpointMd
            "iOS" -> Layout.Apple.breakpointMd
            else -> Layout.Web.breakpointMd
        }

        val maxWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.maxWidthMd
            "iOS" -> Layout.Apple.maxWidthMd
            else -> Layout.Web.maxWidthMd
        }

        val width = when (getPlatform()) {
            "ANDROID" -> Layout.Android.widthMd
            "iOS" -> Layout.Apple.widthMd
            else -> Layout.Web.widthMd
        }

        val height = when (getPlatform()) {
            "ANDROID" -> Layout.Android.heightMd
            "iOS" -> Layout.Apple.heightMd
            else -> Layout.Web.heightMd
        }

        val colNumber = when (getPlatform()) {
            "ANDROID" -> Layout.Android.colNumberMd
            "iOS" -> Layout.Apple.colNumberMd
            else -> Layout.Web.colNumberMd
        }

        val colWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.colWidthMd
            "iOS" -> Layout.Apple.colWidthMd
            else -> Layout.Web.colWidthMd
        }

        val gutter = when (getPlatform()) {
            "ANDROID" -> Layout.Android.gutterMd
            "iOS" -> Layout.Apple.gutterMd
            else -> Layout.Web.gutterMd
        }

        val marginHorizontal = ZvaviSpacing.spacing400
        val contentCompensation = ZvaviSpacing.spacing0
        val ignoreMarginHorizontal = -marginHorizontal
    }

    @Immutable
    object ZvaviTabletLandscape {
        val breakpoint = "tablet-landscape"

        val minWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.breakpointLg
            "iOS" -> Layout.Apple.breakpointLg
            else -> Layout.Web.breakpointLg
        }

        val maxWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.maxWidthLg
            "iOS" -> Layout.Apple.maxWidthLg
            else -> Layout.Web.maxWidthLg
        }

        val width = when (getPlatform()) {
            "ANDROID" -> Layout.Android.widthLg
            "iOS" -> Layout.Apple.widthLg
            else -> Layout.Web.widthLg
        }

        val height = when (getPlatform()) {
            "ANDROID" -> Layout.Android.heightLg
            "iOS" -> Layout.Apple.heightLg
            else -> Layout.Web.heightLg
        }

        val colNumber = when (getPlatform()) {
            "ANDROID" -> Layout.Android.colNumberLg
            "iOS" -> Layout.Apple.colNumberLg
            else -> Layout.Web.colNumberLg
        }

        val colWidth = when (getPlatform()) {
            "ANDROID" -> Layout.Android.colWidthLg
            "iOS" -> Layout.Apple.colWidthLg
            else -> Layout.Web.colWidthLg
        }

        val gutter = when (getPlatform()) {
            "ANDROID" -> Layout.Android.gutterLg
            "iOS" -> Layout.Apple.gutterLg
            else -> Layout.Web.gutterLg
        }

        val marginHorizontal = ZvaviSpacing.spacing700
        val contentCompensation = ZvaviSpacing.spacing0
        val ignoreMarginHorizontal = -marginHorizontal
    }

    @Immutable
    object ZvaviDesktop {
        val breakpoint = "desktop"

        val minWidth = Layout.Web.breakpointXl
        val maxWidth = Layout.Web.maxWidthXl
        val width = Layout.Web.widthXl
        val height = Layout.Web.heightXl
        val colNumber = Layout.Web.colNumberXl
        val colWidth = Layout.Web.colWidthXl
        val gutter = Layout.Web.gutterXl
        val marginHorizontal = ZvaviSpacing.spacing700
        val contentCompensation = ZvaviSpacing.spacing0
        val ignoreMarginHorizontal = -marginHorizontal
    }
}
