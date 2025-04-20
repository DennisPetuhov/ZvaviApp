package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinScreen
import ge.avalanche.zvavi.designsystem.theme.AppTheme

@Composable
fun ZvaviApp() = AppTheme { BulletinScreen() }