package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.PentagonView
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.RectangleView
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.StyledPyramidText
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.toColor

import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import org.jetbrains.compose.resources.stringResource


@Composable
fun RiskByHeightBlock(
    layoutConfig: LayoutConfig,
    viewState: BulletinViewState,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = layoutConfig.contentCompensation, end = ZvaviSpacing.spacing100)
    ) {
        RiskRow(
            topText = {
                Text(
                    text = stringResource(ZvaviStrings.riskByHeight),
                    style = ZvaviTheme.typography.display400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    modifier = Modifier.fillMaxWidth().padding(vertical = ZvaviSpacing.spacing100)
                )
            },
            bottomText = stringResource(ZvaviStrings.highAlpine),
            riskView = {
                PentagonView(
                    canvasWidth = (152f * layoutConfig.canvasScale).dp,
                    canvasHeight = (100f * layoutConfig.canvasScale).dp,
                    color = viewState.riskLevelHighAlpine.toColor(),
                    contentCenterOffsetFromXMax = 100.dp,
                    content = { StyledPyramidText(text = viewState.riskLevelHighAlpine.name) },
                    modifier = Modifier,
                )
            },
            layoutConfig = layoutConfig,
            modifier = Modifier
        )
        RiskRow(
            topText = {
                Text(
                    text = stringResource(ZvaviStrings.height2600),
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    minLines = 1,
                    modifier = Modifier.wrapContentSize()
                )
            },
            bottomText = stringResource(ZvaviStrings.alpine),
            riskView = {
                RectangleView(
                    canvasWidth = (182f * layoutConfig.canvasScale).dp,
                    canvasHeight = (50f * layoutConfig.canvasScale).dp,
                    color = viewState.riskLevelAlpine.toColor(),
                    content = { StyledPyramidText(text = viewState.riskLevelAlpine.name) },
                    modifier = Modifier
                )
            },
            layoutConfig = layoutConfig,
            modifier = Modifier
        )

        RiskRow(
            topText = {
                Text(
                    text = stringResource(ZvaviStrings.height2000),
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    minLines = 1,
                    modifier = Modifier.wrapContentSize()
                )
            },
            bottomText = stringResource(ZvaviStrings.subAlpine),
            riskView = {
                RectangleView(
                    canvasWidth = (212f * layoutConfig.canvasScale).dp,
                    canvasHeight = (50f * layoutConfig.canvasScale).dp,
                    needCorrectionX = true,
                    color = viewState.riskLevelSubAlpine.toColor(),
                    content = { StyledPyramidText(text = viewState.riskLevelSubAlpine.name) },
                )
            },
            layoutConfig = layoutConfig,
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            Text(
                text = stringResource(ZvaviStrings.height0),
                style = ZvaviTheme.typography.compact200Default,
                color = ZvaviTheme.colors.contentNeutralSecondary,
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}

@Composable
private fun RiskRow(
    layoutConfig: LayoutConfig,
    bottomText: String,
    modifier: Modifier = Modifier,
    riskView: @Composable RowScope.() -> Unit,
    topText: @Composable ColumnScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(layoutConfig.pyramidSpacing),
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = 1f, fill = false)
        ) {
            topText()
            Spacer(modifier = Modifier.weight(1f, fill = false))
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = bottomText,
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralTertiary,
                    minLines = 1,
                    modifier = Modifier.wrapContentSize()
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = ZvaviTheme.colors.borderNeutralSecondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.05f, fill = false))
        riskView()
    }
}