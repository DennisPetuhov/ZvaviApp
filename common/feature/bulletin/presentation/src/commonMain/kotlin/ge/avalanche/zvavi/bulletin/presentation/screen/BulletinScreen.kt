package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.ErrorContent
import ge.avalanche.zvavi.designsystem.animation.shimmer.ShimmerState
import ge.avalanche.zvavi.designsystem.animation.shimmer.ZvaviShimmerProvider
import org.koin.compose.koinInject

/**
 * Main screen for displaying avalanche bulletin information
 * @param modifier Modifier to be applied to the screen
 */
@Composable
internal fun BulletinScreen(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: BulletinViewModel = koinInject()
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(initial = null)
    var shimmerState by remember { mutableStateOf(ShimmerState.Active) }

    Scaffold(
        contentWindowInsets = WindowInsets.systemBars,
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when {
                viewState.loading -> {
                    shimmerState = ShimmerState.Active
                }
                viewState.error != null -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = viewState.error ?: "Unknown error",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { }
                        ) {
                            Text("Retry")
                        }
                    }
                    ErrorContent(
                        errorMessage = viewState.error ?: "Unknown error",
                        onRetry = { viewModel.obtainEvent(BulletinEvent.Retry) }
                    )
                }
                else -> {
                    shimmerState = ShimmerState.Inactive
                }
            }

            ZvaviShimmerProvider(shimmerState = shimmerState) {
                BulletinView(viewState = viewState) {
                    viewModel.obtainEvent(it)
                }
            }
        }
    }
    when (viewAction) {
        is BulletinAction.OpenProblemInfoScreen -> {
            onNavigate()
            viewModel.clearAction()
        }
        else -> {}
    }
}