package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import ge.avalanche.zvavi.designsystem.dimens.ZvaviAngle
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@Composable
fun ProblemBlock(layoutConfig: LayoutConfig, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing200),
        modifier = modifier.fillMaxWidth().wrapContentHeight()
            .padding(top = ZvaviSpacing.spacing350)
    ) {
        Text(
            text = "Problems",
            style = ZvaviTheme.typography.display400Accent.copy(
                color = ZvaviTheme.colors.contentNeutralPrimary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    start = layoutConfig.contentCompensation,
                    end = layoutConfig.contentCompensation,
                    bottom = ZvaviSpacing.spacing100,
                    top = ZvaviSpacing.spacing300
                )
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            ZvaviProblemsBoard(layoutConfig = layoutConfig)
            ZvaviProblemsBoard(layoutConfig = layoutConfig)
            ZvaviProblemsBoard(layoutConfig = layoutConfig)
            ZvaviProblemsBoard(layoutConfig = layoutConfig)
        }

    }
}

@Composable
fun ZvaviProblemsBoard(layoutConfig: LayoutConfig, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .background(color = ZvaviTheme.colors.overlayNeutral)
            .padding(
                vertical = ZvaviSpacing.spacing200,
                horizontal = layoutConfig.contentCompensation
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing250),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = ZvaviSpacing.spacing150)
        ) {
            Image(
                ZvaviIcons.AvalancheProblemWetLoose, "persistent slab",
                modifier = Modifier.size(ZvaviSize.size500)
                    .border(BorderStroke(1.dp, color = ZvaviTheme.colors.contentNeutralTertiary))
                    .clip(RoundedCornerShape(ZvaviRadius.radius550))
            )
            Text(
                "Deep persistent slab",
                style = ZvaviTheme.typography.compact300Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
                modifier = Modifier.heightIn(ZvaviSize.size200).fillMaxWidth()
                    .padding(vertical = ZvaviSpacing.spacing150).weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "expanded arrow",
                tint = ZvaviTheme.colors.contentNeutralSecondary,
                modifier = Modifier.graphicsLayer(rotationZ = ZvaviAngle.angleMinus90)
            )
        }
    }
}