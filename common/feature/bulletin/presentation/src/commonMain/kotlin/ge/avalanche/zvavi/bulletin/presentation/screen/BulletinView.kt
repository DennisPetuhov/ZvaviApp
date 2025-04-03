package ge.avalanche.zvavi.bulletin.presentation.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.zIndex
import ge.avalanche.zvavi.designsystem.Stroke
import ge.avalanche.zvavi.designsystem.ZvaviLayout
import ge.avalanche.zvavi.designsystem.ZvaviRadius
import ge.avalanche.zvavi.designsystem.ZvaviSize
import ge.avalanche.zvavi.designsystem.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun BulletinView(modifier: Modifier = Modifier) {
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
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier.padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = ZvaviLayout.marginHorizontal
            )
        ) {
            OverallRiskBlock(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    ZvaviSpacing.spacing100,
                    Alignment.CenterHorizontally
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                ZvaviBoard(
                    mainBlock = {
                        Text(
                            "I am SuperDuper and natural avalanches are likely, human triggered avalanches are very likely",
                            style = ZvaviTheme.typography.compact300Default.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                            minLines = 2,
//                            maxLines = 2,
                        )
                    },
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .fillMaxHeight()
                )
                ZvaviBoard(
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
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .zIndex(1f)
                    .background(Color.Red)
                    .border(1.dp, Color.Black)
            )
        }
    }
}


@Composable
fun ZvaviBoard(
    name: String = "Size and distribution",
    mainBlock: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
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
                horizontal = ZvaviLayout.contentCompensation
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
fun DataLocationBlock(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing50),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .heightIn(min = ZvaviSize.size450)
            .padding(horizontal = ZvaviSpacing.spacing400, vertical = ZvaviSpacing.spacing100)
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
            modifier = Modifier // Scoped modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = ZvaviSpacing.spacing200, vertical = ZvaviSpacing.spacing100)
                .heightIn(min = ZvaviSize.size90)
        )
    }
}

@Composable
fun OverallRiskBlock(
    backgroundColor: Color = ZvaviTheme.colors.backgroundNegativeHigh,
    avalancheRiskLevel: ImageVector = ZvaviIcons.AvalancheRiskLevel4,
    modifier: Modifier = Modifier
) {
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
                    horizontal = ZvaviLayout.contentCompensation
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
