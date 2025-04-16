package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import ge.avalanche.zvavi.designsystem.dimens.ZvaviAngle
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@Composable
fun AvalanchesSnowpackWeatherBlock(layoutConfig: LayoutConfig, modifier: Modifier= Modifier) {
    var expandedStateAvalanche by remember { mutableStateOf(false) }
    var expandedStateSnowPack by remember { mutableStateOf(false) }
    var expandedStateWeather by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = modifier.fillMaxWidth().wrapContentHeight()
            .padding(
                top = ZvaviSpacing.spacing400,
                start = layoutConfig.contentCompensation,
                end = layoutConfig.contentCompensation
            )
    ) {

        ZvaviExpandableText(
            fieldName = ("Recent avalanches"),
            isExpanded = expandedStateAvalanche,
            onExpandedChange = { expandedStateAvalanche = it },
            recentInformation = { },
            modifier = modifier
        )
        ZvaviExpandableText(
            fieldName = "Snowpack",
            isExpanded = expandedStateSnowPack,
            onExpandedChange = { expandedStateSnowPack = it },
            recentInformation = { },
            modifier = modifier
        )
        ZvaviExpandableText(
            fieldName = "Weather",
            isExpanded = expandedStateWeather,
            onExpandedChange = { expandedStateWeather = it },
            recentInformation = { },
            modifier = modifier
        )

    }

}

@Composable
fun ZvaviExpandableText(
    fieldName: String,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    recentInformation: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    val rotationAngle = animateFloatAsState(
        targetValue = if (isExpanded) ZvaviAngle.angle0 else ZvaviAngle.angleMinus90,
        label = ""
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .clickable(interactionSource, null) { onExpandedChange(!isExpanded) }
            .wrapContentHeight()
            .padding(vertical =ZvaviSpacing.spacing150 )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = fieldName,
                style = ZvaviTheme.typography.compact300Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = if (isExpanded) "colapse" else "expanded",
                tint = ZvaviTheme.colors.contentNeutralTertiary,
                modifier = Modifier.graphicsLayer(rotationZ = rotationAngle.value)
            )
        }
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
            }
        }
    }
}