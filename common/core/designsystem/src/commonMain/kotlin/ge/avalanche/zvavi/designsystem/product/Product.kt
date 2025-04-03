package ge.avalanche.zvavi.designsystem.product

import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.layout.LocalLayoutConfig
import ge.avalanche.zvavi.designsystem.layout.ProvideLayoutConfig
import ge.avalanche.zvavi.designsystem.zvaviLayout.Layout


val currentPlatform = getPlatform()


object App {
    // Platform-specific layout values
    val widthSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthSm
        "iOS" -> Layout.Apple.widthSm
        else -> Layout.Web.widthSm
    }

    val widthMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthMd
        "iOS" -> Layout.Apple.widthMd
        else -> Layout.Web.widthMd
    }

    val widthLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthLg
        "iOS" -> Layout.Apple.widthLg
        else -> Layout.Web.widthLg
    }

    val widthXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthXl
        "iOS" -> Layout.Apple.widthXl
        else -> Layout.Web.widthXl
    }

    val heightSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightSm
        "iOS" -> Layout.Apple.heightSm
        else -> Layout.Web.heightSm
    }

    val heightMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightMd
        "iOS" -> Layout.Apple.heightMd
        else -> Layout.Web.heightMd
    }

    val heightLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightLg
        "iOS" -> Layout.Apple.heightLg
        else -> Layout.Web.heightLg
    }

    val heightXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightXl
        "iOS" -> Layout.Apple.heightXl
        else -> Layout.Web.heightXl
    }
}

object Extensions {
    val widthSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthSm
        "iOS" -> Layout.Apple.widthSm
        else -> Layout.Web.widthSm
    }

    val widthMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthMd
        "iOS" -> Layout.Apple.widthMd
        else -> Layout.Web.widthMd
    }

    val widthLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthLg
        "iOS" -> Layout.Apple.widthLg
        else -> Layout.Web.widthLg
    }

    val widthXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthXl
        "iOS" -> Layout.Apple.widthXl
        else -> Layout.Web.widthXl
    }

    val heightSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightSm
        "iOS" -> Layout.Apple.heightSm
        else -> Layout.Web.heightSm
    }

    val heightMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightMd
        "iOS" -> Layout.Apple.heightMd
        else -> Layout.Web.heightMd
    }

    val heightLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightLg
        "iOS" -> Layout.Apple.heightLg
        else -> Layout.Web.heightLg
    }

    val heightXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightXl
        "iOS" -> Layout.Apple.heightXl
        else -> Layout.Web.heightXl
    }
}

object MiniApp {
    val name = "miniapp"

    val widthSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthSm
        "iOS" -> Layout.Apple.widthSm
        else -> Layout.Web.widthSm
    }

    val widthMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthMd
        "iOS" -> Layout.Apple.widthMd
        else -> Layout.Web.widthMd
    }

    val widthLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthLg
        "iOS" -> Layout.Apple.widthLg
        else -> Layout.Web.widthLg
    }

    val widthXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.widthXl
        "iOS" -> Layout.Apple.widthXl
        else -> Layout.Web.widthXl
    }

    val heightSm = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightSm
        "iOS" -> Layout.Apple.heightSm
        else -> Layout.Web.heightSm
    }

    val heightMd = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightMd
        "iOS" -> Layout.Apple.heightMd
        else -> Layout.Web.heightMd
    }

    val heightLg = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightLg
        "iOS" -> Layout.Apple.heightLg
        else -> Layout.Web.heightLg
    }

    val heightXl = when (currentPlatform) {
        "ANDROID" -> Layout.Android.heightXl
        "iOS" -> Layout.Apple.heightXl
        else -> Layout.Web.heightXl
    }
}

object Web {
    val widthSm = Layout.Web.minWidth
    val widthMd = Layout.Web.breakpointMd
    val widthLg = Layout.Web.breakpointLg
    val widthXl = Layout.Web.breakpointXl
    val heightSm = 800.dp
    val heightMd = 800.dp
    val heightLg = 800.dp
    val heightXl = 800.dp
}