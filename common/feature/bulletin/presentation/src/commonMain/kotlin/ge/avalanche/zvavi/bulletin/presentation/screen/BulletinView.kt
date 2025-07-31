package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.AvalanchesSnowpackWeatherBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.DataLocationBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.OverallRisksBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.ProblemsBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks.RiskByHeightBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.boards.OverallRiskLevelBoard
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig

@Composable
internal fun BulletinView(
    viewState: BulletinViewState,
    modifier: Modifier = Modifier,
    eventHandler: (BulletinEvent) -> Unit,
) {
    val layoutConfig = LocalLayoutConfig.current
    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    var headerSize by remember { mutableStateOf(IntSize.Zero) }
    var dataLocationSize by remember { mutableStateOf(IntSize.Zero) }

    val headerHeightPx = with(density) {
        if (headerSize.height > 0) {
            headerSize.height.toDp().toPx()
        } else {
            0f
        }
    }

    val dataLocationHeightDp = with(density) {
        if (dataLocationSize.height > 0) {
            dataLocationSize.height.toDp()
        } else {
            0.dp
        }
    }

    val dataLocationHeightPx = with(density) { dataLocationHeightDp.toPx() }

    val collapsibleHeightPx = (headerHeightPx - dataLocationHeightPx).coerceAtLeast(0f)

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = layoutConfig.marginHorizontal)
             .background(ZvaviTheme.colors.layerFloor0)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged { size ->
                    headerSize = size
                }
        ) {
            OverallRiskLevelBoard(
                viewState = viewState,
                layoutConfig = layoutConfig,
                scroll = scrollState,
                headerHeightPx = collapsibleHeightPx,
                dataLocationHeight = dataLocationHeightDp,
                modifier = Modifier.fillMaxWidth()
            )
        }
        ContentBlocks(
            viewState = viewState,
            layoutConfig = layoutConfig,
            scrollState = scrollState,
            eventHandler = eventHandler,
            headerSize = headerSize,
            density = density
        )
        DataLocationBlock(
            viewState = viewState,
            layoutConfig = layoutConfig,
            scroll = scrollState,
            headerHeightPx = collapsibleHeightPx,
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged { size ->
                    dataLocationSize = size
                }
        )
    }
}

@Composable
private fun ContentBlocks(
    viewState: BulletinViewState,
    layoutConfig: LayoutConfig,
    scrollState: ScrollState,
    eventHandler: (BulletinEvent) -> Unit,
    headerSize: IntSize,
    density: Density
) {
    val headerHeight = with(density) { headerSize.height.toDp() }

    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(Modifier.height(if (headerHeight > 0.dp) headerHeight else 200.dp))
        OverallRisksBlock(
            viewState = viewState,
            eventHandler = eventHandler,
            layoutConfig = layoutConfig
        )
        RiskByHeightBlock(viewState = viewState, layoutConfig = layoutConfig)
        ProblemsBlock(
            viewState = viewState,
            eventHandler = eventHandler,
            layoutConfig = layoutConfig
        )
        AvalanchesSnowpackWeatherBlock(layoutConfig, viewState = viewState,eventHandler = eventHandler)
    }
}