package ge.avalanche.zvavi.bulletin.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.AvalanchesSnowpackWeatherBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.blocks.ProblemBlock
import ge.avalanche.zvavi.bulletin.presentation.screen.views.PentagonView
import ge.avalanche.zvavi.bulletin.presentation.screen.views.RectangleView
import ge.avalanche.zvavi.bulletin.presentation.screen.views.StyledBoxWithText
import ge.avalanche.zvavi.designsystem.dimens.Stroke
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
fun BulletinView(modifier: Modifier = Modifier) {
    val layoutConfig = LocalLayoutConfig.current
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ZvaviTheme.colors.layerFloor0)
    ) {
        DataLocationBlock(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ZvaviSpacing.spacing400, vertical = ZvaviSpacing.spacing100)
        )
        //content
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier.padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.marginHorizontal
            ).verticalScroll(scrollState)
        ) {
            OverallsBlock()
            RiskByHeightBlock()
            AvalanchesSnowpackWeatherBlock(layoutConfig = layoutConfig)
            ProblemBlock(layoutConfig = layoutConfig)
        }
    }
}


@Composable
private fun OverallsBlock() {
    RiskBoard(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    Spacer(modifier = Modifier.height(ZvaviSpacing.spacing100))
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            ZvaviSpacing.spacing100,
            Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        ZvaviDashBoard(
            mainBlock = {
                Text(
                    "I am SuperDuper and natural avalanches are likely, human triggered avalanches are very likely",
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                    minLines = 2,
                )
            },
            modifier = Modifier
                .weight(1f, fill = false)
                .fillMaxHeight()
        )
        ZvaviDashBoard(
            name = "LikelyHood",
            mainBlock = {
                Text(
                    "I am",
                    style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary)
                )
            },
            modifier = Modifier
                .weight(1f, fill = false)
                .fillMaxHeight()
        )
    }
}

@Composable
fun DataLocationBlock(modifier: Modifier = Modifier) {
    val layoutConfig = LocalLayoutConfig.current

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing50),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .heightIn(min = ZvaviSize.size450)
            .padding(horizontal = layoutConfig.marginHorizontal, vertical = ZvaviSpacing.spacing100)
    ) {
        Text(
            text = "Feb 10",
            textAlign = TextAlign.Start,
            style = ZvaviTheme.typography.compact250Default.copy(color = ZvaviTheme.colors.contentNeutralSecondary),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = ZvaviSpacing.spacing200, vertical = ZvaviSpacing.spacing100)
                .heightIn(min = ZvaviSize.size40)
        )
        Text(
            text = "Gudauri",
            textAlign = TextAlign.Start,
            style = ZvaviTheme.typography.compact400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = ZvaviSpacing.spacing200, vertical = ZvaviSpacing.spacing100)
                .heightIn(min = ZvaviSize.size90)
        )
    }
}

@Composable
fun ZvaviDashBoard(
    name: String = "Size and distribution",
    mainBlock: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .widthIn(min = ZvaviSize.size900)
            .heightIn(min = ZvaviSize.size900)
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .border(
                width = Stroke.stroke200,
                shape = RoundedCornerShape(ZvaviRadius.radius550),
                color = ZvaviTheme.colors.borderNeutralTertiary
            )
            .background(color = ZvaviTheme.colors.layerFloor1)
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.contentCompensation
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                ZvaviSpacing.spacing300,
                Alignment.CenterVertically
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = name,
                    style = ZvaviTheme.typography.text250Default.copy(color = ZvaviTheme.colors.contentNeutralSecondary),
                    maxLines = 2,
                    modifier = Modifier
                        .weight(0.9f)
                        .align(Alignment.CenterVertically)
                        .padding(vertical = ZvaviSpacing.spacing100)
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.size(ZvaviSize.size150).weight(0.1f)
                ) {
                    Icon(
                        imageVector = ZvaviIcons.InfoIcon,
                        contentDescription = "Info",
                        tint = ZvaviTheme.colors.contentNeutralTertiary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier.fillMaxSize()
            ) {
                mainBlock()
            }
        }
    }
}

@Composable
fun RiskBoard(
    backgroundColor: Color = ZvaviTheme.colors.backgroundNegativeHigh,
    avalancheRiskLevel: ImageVector = ZvaviIcons.AvalancheRiskLevel4,
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current

    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(ZvaviRadius.radius550))
                .background(color = backgroundColor)
                .padding(
                    vertical = ZvaviSpacing.spacing350,
                    horizontal = layoutConfig.contentCompensation
                )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.weight(1f, fill = false)
            ) {
                Text(
                    text = "Overall risk level",
                    style = ZvaviTheme.typography.text250Default.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                    modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
                )
                Text(
                    text = "High",
                    style = ZvaviTheme.typography.display500Accent.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                    modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
                )
            }
            Image(
                imageVector = avalancheRiskLevel,
                contentDescription = "danger level 4",
                modifier = Modifier
                    .size(80.dp)
                    .weight(1f, fill = false)
            )
        }
    }
}

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