package ge.avalanche.zvavi.designsystem.tokens.product

import androidx.compose.ui.unit.Dp
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType.App
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType.Extensions
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType.MiniApp
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType.Web
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_LG
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_MD
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_SM
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.SIZE_XL

object ProductDimensions {
    fun getWidth(productType: ProductType, size: String): Dp = when (productType) {
        is App -> when (size) {
            SIZE_SM -> App.widthSm
            SIZE_MD -> App.widthMd
            SIZE_LG -> App.widthLg
            SIZE_XL -> App.widthXl
            else -> App.widthSm
        }

        is Extensions -> when (size) {
            SIZE_SM -> Extensions.widthSm
            SIZE_MD -> Extensions.widthMd
            SIZE_LG -> Extensions.widthLg
            SIZE_XL -> Extensions.widthXl
            else -> Extensions.widthSm
        }

        is MiniApp -> when (size) {
            SIZE_SM -> MiniApp.widthSm
            SIZE_MD -> MiniApp.widthMd
            SIZE_LG -> MiniApp.widthLg
            SIZE_XL -> MiniApp.widthXl
            else -> MiniApp.widthSm
        }

        is Web -> when (size) {
            SIZE_SM -> Web.widthSm
            SIZE_MD -> Web.widthMd
            SIZE_LG -> Web.widthLg
            SIZE_XL -> Web.widthXl
            else -> Web.widthSm
        }
    }

    fun getHeight(productType: ProductType, size: String): Dp = when (productType) {
        is App -> when (size) {
            SIZE_SM -> App.heightSm
            SIZE_MD -> App.heightMd
            SIZE_LG -> App.heightLg
            SIZE_XL -> App.heightXl
            else -> App.heightSm
        }

        is Extensions -> when (size) {
            SIZE_SM -> Extensions.heightSm
            SIZE_MD -> Extensions.heightMd
            SIZE_LG -> Extensions.heightLg
            SIZE_XL -> Extensions.heightXl
            else -> Extensions.heightSm
        }

        is MiniApp -> when (size) {
            SIZE_SM -> MiniApp.heightSm
            SIZE_MD -> MiniApp.heightMd
            SIZE_LG -> MiniApp.heightLg
            SIZE_XL -> MiniApp.heightXl
            else -> MiniApp.heightSm
        }

        is Web -> when (size) {
            SIZE_SM -> Web.heightSm
            SIZE_MD -> Web.heightMd
            SIZE_LG -> Web.heightLg
            SIZE_XL -> Web.heightXl
            else -> Web.heightSm
        }
    }
}