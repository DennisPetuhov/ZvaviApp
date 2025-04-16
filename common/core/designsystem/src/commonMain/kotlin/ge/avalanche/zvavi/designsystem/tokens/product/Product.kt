package ge.avalanche.zvavi.designsystem.tokens.product

import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.getPlatform
import ge.avalanche.zvavi.designsystem.tokens.layout.Layout

// Platform-specific layout values
sealed class ProductType {
    val currentPlatform = getPlatform()

    object App : ProductType() {
        val widthSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthSm
            "iOS" -> Layout.IOS.widthSm
            else -> Layout.Web.widthSm
        }

        val widthMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthMd
            "iOS" -> Layout.IOS.widthMd
            else -> Layout.Web.widthMd
        }

        val widthLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthLg
            "iOS" -> Layout.IOS.widthLg
            else -> Layout.Web.widthLg
        }

        val widthXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXl
            "iOS" -> Layout.IOS.widthXl
            else -> Layout.Web.widthXl
        }

        val widthXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXxl
            "iOS" -> Layout.IOS.widthXxl
            else -> Layout.Web.widthXxl
        }

        val heightSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightSm
            "iOS" -> Layout.IOS.heightSm
            else -> Layout.Web.heightSm
        }

        val heightMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightMd
            "iOS" -> Layout.IOS.heightMd
            else -> Layout.Web.heightMd
        }

        val heightLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightLg
            "iOS" -> Layout.IOS.heightLg
            else -> Layout.Web.heightLg
        }

        val heightXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXl
            "iOS" -> Layout.IOS.heightXl
            else -> Layout.Web.heightXl
        }

        val heightXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXxl
            "iOS" -> Layout.IOS.heightXxl
            else -> Layout.Web.heightXxl
        }
    }

    object Extensions : ProductType() {
        val widthSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthSm
            "iOS" -> Layout.IOS.widthSm
            else -> Layout.Web.widthSm
        }

        val widthMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthMd
            "iOS" -> Layout.IOS.widthMd
            else -> Layout.Web.widthMd
        }

        val widthLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthLg
            "iOS" -> Layout.IOS.widthLg
            else -> Layout.Web.widthLg
        }

        val widthXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXl
            "iOS" -> Layout.IOS.widthXl
            else -> Layout.Web.widthXl
        }

        val widthXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXxl
            "iOS" -> Layout.IOS.widthXxl
            else -> Layout.Web.widthXxl
        }

        val heightSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightSm
            "iOS" -> Layout.IOS.heightSm
            else -> Layout.Web.heightSm
        }

        val heightMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightMd
            "iOS" -> Layout.IOS.heightMd
            else -> Layout.Web.heightMd
        }

        val heightLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightLg
            "iOS" -> Layout.IOS.heightLg
            else -> Layout.Web.heightLg
        }

        val heightXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXl
            "iOS" -> Layout.IOS.heightXl
            else -> Layout.Web.heightXl
        }

        val heightXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXxl
            "iOS" -> Layout.IOS.heightXxl
            else -> Layout.Web.heightXxl
        }
    }

    object MiniApp : ProductType() {
        val name = "miniapp"

        val widthSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthSm
            "iOS" -> Layout.IOS.widthSm
            else -> Layout.Web.widthSm
        }

        val widthMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthMd
            "iOS" -> Layout.IOS.widthMd
            else -> Layout.Web.widthMd
        }

        val widthLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthLg
            "iOS" -> Layout.IOS.widthLg
            else -> Layout.Web.widthLg
        }

        val widthXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXl
            "iOS" -> Layout.IOS.widthXl
            else -> Layout.Web.widthXl
        }

        val widthXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.widthXxl
            "iOS" -> Layout.IOS.widthXxl
            else -> Layout.Web.widthXxl
        }

        val heightSm = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightSm
            "iOS" -> Layout.IOS.heightSm
            else -> Layout.Web.heightSm
        }

        val heightMd = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightMd
            "iOS" -> Layout.IOS.heightMd
            else -> Layout.Web.heightMd
        }

        val heightLg = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightLg
            "iOS" -> Layout.IOS.heightLg
            else -> Layout.Web.heightLg
        }

        val heightXl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXl
            "iOS" -> Layout.IOS.heightXl
            else -> Layout.Web.heightXl
        }

        val heightXxl = when (currentPlatform) {
            "ANDROID" -> Layout.Android.heightXxl
            "iOS" -> Layout.IOS.heightXxl
            else -> Layout.Web.heightXxl
        }
    }

    object Web : ProductType() {
        val widthSm = Layout.Web.minWidth
        val widthMd = Layout.Web.breakpointMd
        val widthLg = Layout.Web.breakpointLg
        val widthXl = Layout.Web.breakpointXl
        val widthXxl = Layout.Web.breakpointXxl
        val heightSm = 800.dp
        val heightMd = 800.dp
        val heightLg = 800.dp
        val heightXl = 800.dp
        val heightXxl = 800.dp
    }
}