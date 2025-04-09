package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
        RiskRowPentagon(
            "Risk by height",
            "High Alpine",
            view = {
                PentagonView(
                    canvasWidth = (152f * 1.4f).dp,
                    canvasHeight = (100f * 1.4f).dp,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier,
                )
            }, modifier = Modifier
        )
        RiskRowRectangle(
            "2 600",
            "Alpine",
            view = {
                RectangleView(
                    canvasWidth = (182f * 1.4f).dp,
                    canvasHeight = (50f * 1.4f).dp,
//                    needCorrectionX = true,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier
//                        .weight(2.15f, fill = false)
                )
            },
            innerTextWeight = 0.8f,
            modifier = Modifier
        )

        RiskRowRectangle(
            "2 000",
            "Sub Alpine",
            view = {
                RectangleView(
                    canvasWidth = (214f * 1.4f).dp,
                    canvasHeight = (50f * 1.4f).dp,
                    needCorrectionX = true,
                    content = { StyledPyramidText("Moderate") },
                    modifier = Modifier
//                          .weight(2.1f, fill = false),
                )
            },
            innerTextWeight = 0.4f,
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
private fun RiskRowPentagon(
    title: String, subtitle: String, modifier: Modifier,
    view: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        // before fillmaxwidth
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f, fill = false)
        ) {
            Text(
                title,
                style = ZvaviTheme.typography.display400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                color = ZvaviTheme.colors.contentNeutralSecondary,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Start)
                    .padding(vertical = ZvaviSpacing.spacing100)
            )
            Spacer(modifier = Modifier.height(ZvaviSpacing.spacing650))
            Text(
                subtitle,
                style = ZvaviTheme.typography.compact200Default,
                color = ZvaviTheme.colors.contentNeutralTertiary,
                modifier = Modifier.wrapContentSize(),
                minLines = 1
            )
            HorizontalDivider(
                thickness = 2.dp,
                color = ZvaviTheme.colors.borderNeutralSecondary,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        view()
    }
}

@Composable
private fun RiskRowRectangle(
    elevation: String,
    elevationName: String,
    modifier: Modifier,
    innerTextWeight: Float,
    view: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth().wrapContentHeight()
                .weight(weight = innerTextWeight, fill = false)
        ) {

            Text(
                elevation,
                style = ZvaviTheme.typography.compact200Default,
                color = ZvaviTheme.colors.contentNeutralSecondary,
                minLines = 1,
                modifier = Modifier.wrapContentSize()
            )
            Spacer(modifier = Modifier.height(ZvaviSpacing.spacing650))
            Text(
                elevationName,
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
        Spacer(modifier = Modifier.size(16.dp))
        view()
    }
}