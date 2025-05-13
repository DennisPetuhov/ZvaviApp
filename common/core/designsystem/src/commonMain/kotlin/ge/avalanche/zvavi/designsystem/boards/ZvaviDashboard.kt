package ge.avalanche.zvavi.designsystem.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.designsystem.dimens.Stroke
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

interface ZvaviDashboardEvent {
    object InfoClicked : ZvaviDashboardEvent
}

@Composable
fun ZvaviDashboard(
    name: String,
    eventHandler: (ZvaviDashboardEvent) -> Unit,
    layoutConfig: LayoutConfig,
    backgroundColor: Color = ZvaviTheme.colors.layerFloor1,
    modifier: Modifier = Modifier,
    mainBlock: @Composable BoxScope. () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .border(
                width = Stroke.stroke200,
                shape = RoundedCornerShape(ZvaviRadius.radius550),
                color = ZvaviTheme.colors.borderNeutralTertiary
            )
            .background(backgroundColor)
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.contentCompensation
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing50),
            modifier = Modifier.fillMaxSize()
        ) {
            DashboardHeader(name = name, eventHandler = eventHandler)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) { mainBlock() }
        }
    }
}

@Composable
private fun DashboardHeader(
    name: String,
    eventHandler: (ZvaviDashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
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
            onClick = { eventHandler(ZvaviDashboardEvent.InfoClicked) },
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
}