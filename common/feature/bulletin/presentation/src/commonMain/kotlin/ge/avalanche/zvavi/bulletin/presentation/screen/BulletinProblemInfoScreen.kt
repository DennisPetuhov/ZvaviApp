package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun BulletinProblemInfoScreen() {
    Scaffold(modifier = Modifier.fillMaxSize().background(color = Color.Cyan)) {
        Box(
            modifier = Modifier.fillMaxSize().background(ZvaviTheme.colors.contentBrandPrimary),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "WOWOWOWOOW")
        }

    }
}