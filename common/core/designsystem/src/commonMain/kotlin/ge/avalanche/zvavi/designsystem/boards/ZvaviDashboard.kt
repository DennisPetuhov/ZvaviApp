package ge.avalanche.zvavi.designsystem.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.dimens.Stroke
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun ZvaviDashboard(
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
            .background(ZvaviTheme.colors.layerFloor1)
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = ZvaviSpacing.spacing200
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing300),
            modifier = Modifier.fillMaxSize()
        ) {
            DashboardHeader(name = name)
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
private fun DashboardHeader(name: String) {
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
//            Icon(
//                imageVector = ZvaviIcons.InfoIcon,
//                contentDescription = "Info",
//                tint = ZvaviTheme.colors.contentNeutralTertiary,
//                modifier = Modifier.size(16.dp)
//            )
        }
    }
}