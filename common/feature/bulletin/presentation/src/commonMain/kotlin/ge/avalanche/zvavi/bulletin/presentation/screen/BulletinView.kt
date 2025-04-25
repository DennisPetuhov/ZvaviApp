package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.bulletin.presentation.BulletinViewModel
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.AvalanchesSnowpackWeatherBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.DataLocationBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.OverallRisksBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.ProblemBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.RiskByHeightBlock
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
fun BulletinView(
    viewModel: BulletinViewModel,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(ZvaviTheme.colors.layerFloor0)
    ) {
        DataLocationBlock(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ZvaviSpacing.spacing400, vertical = ZvaviSpacing.spacing100)
        )
        ContentBlocks(
            viewModel,
            layoutConfig = layoutConfig,
            scrollState = scrollState
        )
    }
}

@Composable
private fun ContentBlocks(
    viewModel: BulletinViewModel,
    layoutConfig: LayoutConfig,
    scrollState: ScrollState
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = Modifier.fillMaxSize()
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.marginHorizontal
            )
            .verticalScroll(scrollState)
    ) {
        OverallRisksBlock()
        RiskByHeightBlock(layoutConfig)
        ProblemBlock(
            onProblemClick = { viewModel.fetchBulletinData() },
            layoutConfig = layoutConfig
        )
        AvalanchesSnowpackWeatherBlock(layoutConfig)
    }
}