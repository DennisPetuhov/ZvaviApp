package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinAction
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.ErrorContent
import ge.avalanche.zvavi.designsystem.animation.shimmer.ShimmerState
import ge.avalanche.zvavi.designsystem.animation.shimmer.ZvaviShimmerProvider
import org.koin.compose.koinInject

@Composable
internal fun BulletinScreen(
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel: BulletinViewModel = koinInject()
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(initial = null)
    var shimmerState by remember { mutableStateOf(ShimmerState.Active) }
    Box(
        modifier = modifier.fillMaxSize(), // Use passed modifier
        contentAlignment = Alignment.Center
    ) {
        when {
            viewState.loading -> {
                shimmerState = ShimmerState.Active
            }

            viewState.error != null -> {
                shimmerState = ShimmerState.Inactive
                ErrorContent(
                    errorMessage = viewState.error ?: "Unknown error",
                    onRetry = { viewModel.obtainEvent(BulletinEvent.Retry) }
                )
            }

            else -> {
                shimmerState = ShimmerState.Inactive
            }
        }

//        if (!viewState.loading && viewState.error == null) {
        ZvaviShimmerProvider(shimmerState = shimmerState) {
            BulletinView(viewState = viewState) { event ->
                viewModel.obtainEvent(event)
            }
//            }
        }
    }

    // Handle navigation actions
    when (viewAction) {
        is BulletinAction.OpenProblemInfoScreen -> {
            onNavigate()
            viewModel.clearAction()
        }

        else -> {}
    }
}