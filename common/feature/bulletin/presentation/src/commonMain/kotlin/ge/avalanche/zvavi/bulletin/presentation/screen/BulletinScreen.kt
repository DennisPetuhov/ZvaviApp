package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when {
                viewState.loading -> {
                    CircularProgressIndicator()
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
                            onClick = {  }
                        ) {
                            Text("Retry")
                        }
                    }
                }

                else -> {
                    BulletinView(viewState = viewState, paddingValues = paddingValues) {
                        viewModel.obtainEvent(it)
                    }
                }
            }
        }
    }
}
