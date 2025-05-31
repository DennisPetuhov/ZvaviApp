package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.boards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.designsystem.animation.shimmer.shimmerEffect
import ge.avalanche.zvavi.designsystem.dimens.ZvaviAngle
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@Composable
fun ZvaviProblemBoard(
    problem: AvalancheProblem,
    layoutConfig: LayoutConfig,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .background(color = ZvaviTheme.colors.overlayNeutral)
            .padding(
                vertical = ZvaviSpacing.spacing200,
                horizontal = layoutConfig.contentCompensation
            ).clickable(
                onClick = onClick,
                enabled = true,
                role = null,
                indication = null,
                interactionSource = null
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = ZvaviSpacing.spacing150)
        ) {
            Image(
                ZvaviIcons.AvalancheProblemWetLoose, "persistent slab",
                modifier = Modifier
                    .weight(0.6f, fill = false)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(ZvaviRadius.radius550))
                    .border(BorderStroke(1.dp, ZvaviTheme.colors.contentNeutralTertiary))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.weight(0.12f))
            Text(
                text = problem.type,
                style = ZvaviTheme.typography.compact300Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                maxLines = 1,
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(2f)
                    .padding(vertical = ZvaviSpacing.spacing150).shimmerEffect()
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "expanded arrow",
                tint = ZvaviTheme.colors.contentNeutralSecondary,
                modifier = Modifier
                    .padding(start = ZvaviSpacing.spacing200)
                    .graphicsLayer(rotationZ = ZvaviAngle.angleMinus90)
            )
        }
    }
}