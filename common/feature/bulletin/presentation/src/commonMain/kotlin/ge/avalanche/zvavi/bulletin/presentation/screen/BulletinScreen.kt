package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import org.koin.compose.koinInject

@Composable
fun BulletinScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: BulletinViewModel = koinInject()
    val viewState by viewModel.viewStates().collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
    ) { paddingValues ->
        if (viewState.loading) {
            CircularProgressIndicator()
        } else {
            BulletinView(viewModel = viewModel, paddingValues = paddingValues)
        }
    }
}