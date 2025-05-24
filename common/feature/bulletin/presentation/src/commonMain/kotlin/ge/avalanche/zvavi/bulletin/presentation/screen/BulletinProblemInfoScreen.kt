package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import org.koin.compose.koinInject

@Composable
internal fun BulletinProblemInfoScreen() {
    val viewModel: BulletinViewModel = koinInject()
    val viewState by viewModel.viewStates().collectAsState()
    BulletinProblemInfoView(viewState = viewState) { viewModel.obtainEvent(it) }
}

@Composable
private fun BulletinProblemInfoView(viewState: BulletinViewState, eventHandler: (BulletinEvent) -> Unit) {
    DisposableEffect(Unit) { onDispose { eventHandler(BulletinEvent.ReturnFromBulletinProblemInfoScreen) } }
    Scaffold(modifier = Modifier.fillMaxSize().background(color = Color.Cyan)) {
        Box(
            modifier = Modifier.fillMaxSize().background(ZvaviTheme.colors.contentBrandPrimary),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "WOWOWOWOOW")
        }
    }
}