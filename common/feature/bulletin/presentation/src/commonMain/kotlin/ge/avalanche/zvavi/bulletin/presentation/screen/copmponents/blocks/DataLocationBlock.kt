package ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.blocks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig


@Composable
fun DataLocationBlock(modifier: Modifier = Modifier) {
    val layoutConfig = LocalLayoutConfig.current

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = layoutConfig.marginHorizontal, vertical = ZvaviSpacing.spacing100)
    ) {
        LocationText(
            text = "Feb 10",
            style = ZvaviTheme.typography.compact250Default,
            color = ZvaviTheme.colors.contentNeutralSecondary
        )
        LocationText(
            text = "Gudauri",
            style = ZvaviTheme.typography.compact400Accent,
            color = ZvaviTheme.colors.contentNeutralPrimary
        )
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
            .wrapContentHeight()
            .padding(horizontal = ZvaviSpacing.spacing200, vertical = ZvaviSpacing.spacing100)
    )
}