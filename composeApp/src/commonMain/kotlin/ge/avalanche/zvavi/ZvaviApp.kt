package ge.avalanche.zvavi

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import ge.avalanche.zvavi.bulletin.presentation.screen.BulletinView
import ge.avalanche.zvavi.designsystem.theme.AppTheme

@Composable
fun ZvaviApp() {
    AppTheme {
        Scaffold {paddingValues ->
            BulletinView(paddingValues=paddingValues)
        }
    }
}