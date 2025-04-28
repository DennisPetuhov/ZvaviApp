package ge.avalanche.zvavi.bulletin.presentation.screen.boards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecentAvalancheBoard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().wrapContentHeight()) {
        Text("13.05.2023", modifier = modifier.fillMaxWidth())
    }
}