package ge.avalanche.zvavi.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.tokens.effect.DarkShadow
import ge.avalanche.zvavi.designsystem.tokens.effect.LightShadow
import ge.avalanche.zvavi.designsystem.tokens.effect.LocalShadowColorProvider
import ge.avalanche.zvavi.designsystem.tokens.effect.ZvaviShadowColor
import ge.avalanche.zvavi.designsystem.tokens.layout.ProvideLayoutConfig
import ge.avalanche.zvavi.designsystem.tokens.layout.getCurrentScreenSize
import ge.avalanche.zvavi.designsystem.tokens.product.ProductDimensions
import ge.avalanche.zvavi.designsystem.tokens.product.ProductType
import ge.avalanche.zvavi.designsystem.colors.DarkColors
import ge.avalanche.zvavi.designsystem.colors.LightColors
import ge.avalanche.zvavi.designsystem.colors.LocalColorProvider
import ge.avalanche.zvavi.designsystem.colors.ZvaviColors
import ge.avalanche.zvavi.designsystem.typography.CreateZvaviTypography
import ge.avalanche.zvavi.designsystem.typography.LocalTypographyProvider
import ge.avalanche.zvavi.designsystem.typography.ZvaviTypography

val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }

@Composable
fun AppTheme(
    productType: ProductType = ProductType.App,
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember(systemIsDark) { mutableStateOf(systemIsDark) }
    val isDark by isDarkState
    val colors = if (!isDark) LightColors else DarkColors
    val shadow = if (!isDark) LightShadow else DarkShadow
    val typography: ZvaviTypography = CreateZvaviTypography()

    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalColorProvider provides colors,
        LocalShadowColorProvider provides shadow,
        LocalTypographyProvider provides typography
    ) {
        ProvideLayoutConfig(productType = productType) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(ProductDimensions.getWidth(productType, getCurrentScreenSize()))
            ) {
                println("***** ${getCurrentScreenSize()}")
                content()
            }
        }
    }
}

object ZvaviTheme {
    val colors: ZvaviColors
        @Composable
        get() = LocalColorProvider.current
    val shadowColor: ZvaviShadowColor
        @Composable get() = LocalShadowColorProvider.current
    val typography: ZvaviTypography
        @Composable get() = LocalTypographyProvider.current
}