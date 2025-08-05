package ge.avalanche.zvavi.designsystem.components.expandableSection

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
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import ge.avalanche.zvavi.designsystem.dimens.ZvaviAngle
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun ZvaviExpandableSection(
    sectionTitle: @Composable () -> Unit,
    isExpanded: Boolean = false,
    onExpandedChange: ((Boolean) -> Unit)? = null,
    isNavigationMode: Boolean = false,
    onNavigateClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) ZvaviAngle.angle0 else ZvaviAngle.angleMinus90,
        label = "expandArrowRotation"
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = ZvaviSpacing.spacing100,
            alignment = Alignment.CenterVertically
        ),


                modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null  // This removes the ripple
            ) {
                when {
                    isNavigationMode && onNavigateClick != null -> onNavigateClick()
                    !isNavigationMode && onExpandedChange != null -> onExpandedChange(!isExpanded)
                }
            }
            .wrapContentHeight()
            .padding(vertical = ZvaviSpacing.spacing150)
    ) {
        ExpandableToggleRow(
            isExpanded = isExpanded,
            sectionTitle = sectionTitle,
            rotationAngle = rotationAngle,

            )

        if (!isNavigationMode) {
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
}

@Composable
private fun ExpandableToggleRow(
    isExpanded: Boolean,
    rotationAngle: Float,
    sectionTitle: @Composable() () -> Unit = {},
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        sectionTitle()
        Icon(
            imageVector = ZvaviIcons.DropDownArrow,
            contentDescription = if (isExpanded) stringResource(ZvaviStrings.collapse) else stringResource(
                ZvaviStrings.expand
            ),
            tint = ZvaviTheme.colors.contentNeutralTertiary,
            modifier = Modifier.graphicsLayer(rotationZ = rotationAngle)
        )
    }
}