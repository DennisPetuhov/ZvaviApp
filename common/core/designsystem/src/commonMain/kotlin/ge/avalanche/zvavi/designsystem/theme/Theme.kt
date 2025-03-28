package ge.avalanche.zvavi.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.effect.DarkShadow
import ge.avalanche.zvavi.designsystem.effect.LightShadow
import ge.avalanche.zvavi.designsystem.effect.LocalShadowColorProvider

val LocalThemeIsDark = compositionLocalOf { mutableStateOf(true) }


@Composable
fun ZvaviAppTheme(
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val isDarkState = remember(systemIsDark) { mutableStateOf(systemIsDark) }
    val isDark by isDarkState
    val colors = if (!isDark) LightColors else DarkColors
    val shadow = if (!isDark) LightShadow else DarkShadow
    CompositionLocalProvider(
        LocalThemeIsDark provides isDarkState,
        LocalColorProvider provides colors,
        LocalShadowColorProvider provides shadow
    ) {
        Surface(modifier = Modifier.fillMaxSize()) { content() }
    }
}