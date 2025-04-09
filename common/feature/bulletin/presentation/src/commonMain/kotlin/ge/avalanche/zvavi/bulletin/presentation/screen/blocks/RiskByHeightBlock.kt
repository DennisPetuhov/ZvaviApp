package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import ge.avalanche.zvavi.bulletin.presentation.screen.views.PentagonView
import ge.avalanche.zvavi.bulletin.presentation.screen.views.RectangleView
import ge.avalanche.zvavi.bulletin.presentation.screen.views.StyledBoxWithText
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
fun RiskByHeightBlock(
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current

    Column(
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight().padding(
                start = layoutConfig.contentCompensation,
                end = ZvaviSpacing.spacing100,
            )
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxHeight()
                    .weight(1f, fill = false)
            ) {
                Text(
                    "Risk by height",
                    style = ZvaviTheme.typography.display400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Start)
                        .padding(vertical = ZvaviSpacing.spacing100)
                )
                Spacer(modifier = Modifier.size(ZvaviSpacing.spacing650))
                Text(
                    "High Alpine",
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralTertiary,
                    modifier = Modifier.wrapContentSize()
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = ZvaviTheme.colors.borderNeutralSecondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            PentagonView(
                canvasWidth = (152 * 1.4).dp,
                canvasHeight = (100 * 1.4).dp,
            ) { StyledBoxWithText("Moderate") }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f, fill = false)
            ) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        "2 600",
                        style = ZvaviTheme.typography.compact200Default,
                        color = ZvaviTheme.colors.contentNeutralSecondary,
                        modifier = Modifier.wrapContentSize()
                    )
                    Spacer(modifier = Modifier.height(ZvaviSpacing.spacing650))
                    Text(
                        "Alpine",
                        style = ZvaviTheme.typography.compact200Default,
                        color = ZvaviTheme.colors.contentNeutralTertiary,
                        modifier = Modifier.wrapContentSize()
                    )
                }
                HorizontalDivider(
                    thickness = 2.dp,
                    color = ZvaviTheme.colors.borderNeutralSecondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            RectangleView(
                canvasWidth = (182 * 1.4).dp,
                canvasHeight = (50 * 1.4).dp,
                modifier = Modifier.weight(2.15f, fill = false),

                ) { StyledBoxWithText("Moderate") }
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.wrapContentSize()) { }
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(0.4f, fill = false)
            ) {
                Text(
                    "2 000",
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralSecondary,
                    modifier = Modifier.wrapContentSize()
                )
                Spacer(modifier = Modifier.height(ZvaviSpacing.spacing650))
                Text(
                    "Sub Alpine",
                    style = ZvaviTheme.typography.compact200Default,
                    color = ZvaviTheme.colors.contentNeutralTertiary,
                    modifier = Modifier.wrapContentSize()
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = ZvaviTheme.colors.borderNeutralSecondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            RectangleView(
                canvasWidth = (214 * 1.4).dp,
                canvasHeight = (50 * 1.4).dp,
                modifier = Modifier.weight(2.1f, fill = false),
                needCorrectionX = true

            ) {
                StyledBoxWithText("Moderate")
            }
        }
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