package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ResponsiveContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val config = LocalLayoutConfig.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = config.marginHorizontal)
    ) {
        content()
    }
}

@Composable
fun ResponsiveGrid(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val config = LocalLayoutConfig.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(config.colNumber),
        horizontalArrangement = Arrangement.spacedBy(config.gutter),
        verticalArrangement = Arrangement.spacedBy(config.gutter),
        modifier = modifier.padding(horizontal = config.marginHorizontal)
    ) {
        item {
            content()
        }
    }
}