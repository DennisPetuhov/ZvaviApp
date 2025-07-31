package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import ge.avalanche.zvavi.bulletin.api.models.Aspects
import ge.avalanche.zvavi.bulletin.api.models.RecentAvalanche
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.designsystem.dimens.ZvaviAngle
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.dimens.ZvaviStroke
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import org.jetbrains.compose.resources.stringResource

private data class ExpandableSection(
    val title: String,
    val isExpanded: Boolean,
    val onExpandedChange: (Boolean) -> Unit,
    val content: @Composable ColumnScope.() -> Unit
)

@Composable
fun AvalanchesSnowpackWeatherBlock(
    layoutConfig: LayoutConfig,
    viewState: BulletinViewState,
    eventHandler: (BulletinEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    var expandedStateAvalanche by remember { mutableStateOf(false) }
    var expandedStateSnowPack by remember { mutableStateOf(false) }
    var expandedStateWeather by remember { mutableStateOf(false) }

    // Create sections list to eliminate repetition - DRY principle
    val sections = listOf(
        ExpandableSection(
            title = stringResource(ZvaviStrings.recentAvalanches),
            isExpanded = expandedStateAvalanche,
            onExpandedChange = { expandedStateAvalanche = it }
        ) {
            viewState.recentAvalanches.forEach { recentAvalanche ->
                AvalancheCell(recentAvalanche, eventHandler)
            }
        },
        ExpandableSection(
            title = stringResource(ZvaviStrings.snowpack),
            isExpanded = expandedStateSnowPack,
            onExpandedChange = { expandedStateSnowPack = it }
        ) {
            BodyText(text = viewState.snowpack)
        },
        ExpandableSection(
            title = stringResource(ZvaviStrings.weather),
            isExpanded = expandedStateWeather,
            onExpandedChange = { expandedStateWeather = it }
        ) {
            BodyText(text = viewState.weather)
        }
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = ZvaviSpacing.spacing400,
                start = layoutConfig.contentCompensation,
                end = layoutConfig.contentCompensation
            )
    ) {
        sections.forEach { section ->
            ZvaviExpandableText(
                fieldName = section.title,
                isExpanded = section.isExpanded,
                onExpandedChange = section.onExpandedChange,
                content = section.content
            )
        }
    }
}

@Composable
fun ZvaviExpandableText(
    fieldName: String,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) ZvaviAngle.angle0 else ZvaviAngle.angleMinus90,
        label = "expandArrowRotation"
    )

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onExpandedChange(!isExpanded) } // Removed unnecessary MutableInteractionSource
            .wrapContentHeight()
            .padding(vertical = ZvaviSpacing.spacing150)
    ) {
        ExpandableHeader(
            fieldName = fieldName,
            isExpanded = isExpanded,
            rotationAngle = rotationAngle
        )

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = ZvaviSpacing.spacing200,
                        vertical = ZvaviSpacing.spacing200
                    )
            ) {
                content()
            }
        }
    }
}

@Composable
private fun ExpandableHeader(
    fieldName: String,
    isExpanded: Boolean,
    rotationAngle: Float
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AccentText(
            text = fieldName,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = ZvaviIcons.DropDownArrow,
            contentDescription = if (isExpanded) stringResource(ZvaviStrings.collapse) else stringResource(ZvaviStrings.expand),
            tint = ZvaviTheme.colors.contentNeutralTertiary,
            modifier = Modifier.graphicsLayer(rotationZ = rotationAngle)
        )
    }
}

@Composable
fun AvalancheCell(
    recentAvalanche: RecentAvalanche,
    eventHandler: (BulletinEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = ZvaviTheme.colors.overlayNeutral,
                shape = RoundedCornerShape(ZvaviRadius.radius550)
            )
            .border(
                width = ZvaviStroke.stroke200,
                shape = RoundedCornerShape(ZvaviRadius.radius550),
                color = ZvaviTheme.colors.borderNeutralTertiary
            )
            .padding(ZvaviSpacing.spacing350)
    ) {
        AvalancheHeader(recentAvalanche = recentAvalanche, eventHandler = eventHandler)
        VerticalSpacer(spacing = ZvaviSpacing.spacing250)
        AspectsByElevationSection(aspects = recentAvalanche.aspects)
        VerticalSpacer(spacing = ZvaviSpacing.spacing250)
        DetailedDescriptionSection(description = recentAvalanche.description)
    }
    VerticalSpacer(spacing = ZvaviSpacing.spacing100)
}

@Composable
private fun AvalancheHeader(
    recentAvalanche: RecentAvalanche,
    eventHandler: (BulletinEvent) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = ZvaviSpacing.spacing200)
    ) {
        AvalancheDate(text = recentAvalanche.date)

        Row(horizontalArrangement = Arrangement.End) {
            AvalancheSize(text = "Size: ${recentAvalanche.size}")
            Spacer(modifier = Modifier.size(ZvaviSpacing.spacing350))
            InfoButton(eventHandler = eventHandler)
        }
    }
}

@Composable
private fun AspectsByElevationSection(aspects: Aspects) { // Replace Any with proper type
    SectionTitle(text = stringResource(ZvaviStrings.aspectByElevation))
    VerticalSpacer(spacing = ZvaviSpacing.spacing250)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(bottom = ZvaviSpacing.spacing200)
    ) {
        val elevationData = listOf(
            stringResource(ZvaviStrings.highAlpine) to aspects.highAlpine.keys,
            stringResource(ZvaviStrings.alpine) to aspects.alpine.keys,
            stringResource(ZvaviStrings.subAlpine) to aspects.subAlpine.keys
        )

        elevationData.forEachIndexed { index, (elevation, aspectText) ->
            if (index > 0) {
                Spacer(modifier = Modifier.weight(0.05f))
            }
            if (aspectText.isNotEmpty()) {
                ElevationCell(
                    elevationText = elevation,
                    aspectText = { ColoredElevationText(aspectText) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun DetailedDescriptionSection(description: String) {
    SectionTitle(text = stringResource(ZvaviStrings.detailedDescription))
    VerticalSpacer(spacing = ZvaviSpacing.spacing250)
    BodyText(
        text = description,
        modifier = Modifier.padding(horizontal = ZvaviSpacing.spacing250)
    )
}

@Composable
private fun InfoButton(eventHandler: (BulletinEvent) -> Unit) {
    IconButton(
        onClick = { eventHandler(BulletinEvent.AvalancheSizeInfoClicked) },
        modifier = Modifier.size(ZvaviSize.size150)
    ) {
        Icon(
            imageVector = ZvaviIcons.InfoIcon,
            contentDescription = stringResource(ZvaviStrings.info),
            tint = ZvaviTheme.colors.contentNeutralTertiary,
            modifier = Modifier.size(ZvaviSize.size100) // Use design system token
        )
    }
}

@Composable
fun ColoredElevationText(aspects: Set<String>) {
    if (aspects.isEmpty()) {
        AvalancheAspects(text = "* * *")
        return
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        aspects.chunked(3).forEach { rowAspects ->
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                rowAspects.forEach { aspect ->
                    AvalancheAspects(
                        text = aspect.uppercase(),
                        modifier = Modifier.padding(horizontal = ZvaviSpacing.spacing150)
                    )
                }
            }
        }
    }
}

@Composable
fun ElevationCell(
    elevationText: String,
    aspectText: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxHeight()
    ) {
        DefaultText(text = elevationText)
        VerticalSpacer(spacing = ZvaviSpacing.spacing200)
        aspectText()
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ZvaviSpacing.spacing250),
            color = ZvaviTheme.colors.borderNeutralTertiary,
            thickness = ZvaviStroke.stroke100
        )
    }
}

@Composable
private fun AccentText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.compact300Accent,
        color = ZvaviTheme.colors.contentNeutralPrimary,
        modifier = modifier
    )
}

@Composable
private fun BodyText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.text300Default,
        color = ZvaviTheme.colors.contentNeutralPrimary,
        modifier = modifier
    )
}

@Composable
private fun AvalancheDate(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.display350Accent,
        color = ZvaviTheme.colors.contentNeutralPrimary,
        modifier = modifier
    )
}

@Composable
private fun AvalancheSize(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.display350Accent,
        color = ZvaviTheme.colors.backgroundBrandHigh,
        modifier = modifier
    )
}

@Composable
private fun AvalancheAspects(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.text250Accent,
        color = ZvaviTheme.colors.backgroundBrandHigh,
        modifier = modifier
    )
}

@Composable
private fun SectionTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.text200Accent,
        color = ZvaviTheme.colors.contentNeutralSecondary,
        modifier = modifier
    )
}

@Composable
private fun DefaultText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = ZvaviTheme.typography.text250Default,
        color = ZvaviTheme.colors.contentNeutralPrimary,
        modifier = modifier
    )
}

@Composable
private fun VerticalSpacer(spacing: Dp) {
    Spacer(modifier = Modifier.size(spacing))
}