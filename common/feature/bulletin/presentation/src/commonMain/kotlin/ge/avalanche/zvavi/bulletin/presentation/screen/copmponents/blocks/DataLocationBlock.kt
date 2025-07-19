package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.designsystem.animation.shimmer.shimmerEffect
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import org.jetbrains.compose.resources.stringResource

@Composable
fun DataLocationBlock(
    viewState: BulletinViewState,
    layoutConfig: LayoutConfig,
    scroll: ScrollState,
    headerHeightPx: Float,
    modifier: Modifier = Modifier
) {
    val collapseFraction = if (headerHeightPx > 0) {
        (scroll.value / headerHeightPx).coerceIn(0f, 1f)
    } else 0f

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = layoutConfig.marginHorizontal)
            .clip(RoundedCornerShape(ZvaviRadius.radius400))
            .background(
                color = lerp(
                    ZvaviTheme.colors.layerFloor0,
                    ZvaviTheme.colors.contentPositiveSecondary,
                    collapseFraction
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = ZvaviSpacing.spacing500, vertical = ZvaviSpacing.spacing50)
        ) {
            LocationText(
                text = viewState.bulletinData,
                style = ZvaviTheme.typography.compact250Default,
                color = ZvaviTheme.colors.contentNeutralSecondary,
            )
            LocationText(
                text = stringResource(ZvaviStrings.gudauri),
                style = ZvaviTheme.typography.compact400Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary
            )
        }
    }
}

@Composable
private fun LocationText(
    text: String,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        textAlign = TextAlign.Start,
        style = style.copy(color = color),
        modifier = modifier
            .fillMaxWidth()
            .shimmerEffect()
    )
}