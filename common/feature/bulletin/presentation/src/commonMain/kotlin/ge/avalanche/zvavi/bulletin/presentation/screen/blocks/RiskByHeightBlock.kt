package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import ge.avalanche.zvavi.bulletin.presentation.screen.PentagonView
import ge.avalanche.zvavi.bulletin.presentation.screen.RectangleView
import ge.avalanche.zvavi.bulletin.presentation.screen.utill.StyledPyramidText
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
fun RiskByHeightBlock(modifier: Modifier = Modifier) {
    val layoutConfig = LocalLayoutConfig.current

    Column(
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = layoutConfig.contentCompensation,
                end = ZvaviSpacing.spacing100
            )
    ) {
        RiskRow(
            topText = {
                Text(
                    text = "Risk by height",
                    style = ZvaviTheme.typography.display400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = ZvaviSpacing.spacing100)
                )
            },
            bottomText = "High Alpine",
            view = {
                PentagonView(
                    canvasWidth = (152f * 1.4f).dp,
                    canvasHeight = (100f * 1.4f).dp,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier,
                )
            }, modifier = Modifier
        )
        RiskRow(
            topText = {
                Text(
                    text = "2 600",
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    minLines = 1,
                    modifier = Modifier.wrapContentSize()
                )
            },
            bottomText = "Alpine",
            view = {
                RectangleView(
                    canvasWidth = (182f * 1.4f).dp,
                    canvasHeight = (50f * 1.4f).dp,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier
                )
            },

            modifier = Modifier
        )

        RiskRow(
            topText = {
                Text(
                    text = "2 000",
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    minLines = 1,
                    modifier = Modifier.wrapContentSize()
                )
            },
            bottomText = "Sub Alpine",
            view = {
                RectangleView(
                    canvasWidth = (214f * 1.4f).dp,
                    canvasHeight = (50f * 1.4f).dp,
                    needCorrectionX = true,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier
                )
            },

            modifier = Modifier
        )
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            Text(
                "0",
                style = ZvaviTheme.typography.compact200Default,
                color = ZvaviTheme.colors.contentNeutralSecondary,
                modifier = Modifier.wrapContentSize()
            )
        }
    }
}

@Composable
private fun RiskRow(
    bottomText: String,
    modifier: Modifier,
    view: @Composable RowScope.() -> Unit,
    topText: @Composable () -> Unit
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing650),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(weight = 1f, fill = false)
        ) {
            topText()
            Column(
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
        view()
    }
}
