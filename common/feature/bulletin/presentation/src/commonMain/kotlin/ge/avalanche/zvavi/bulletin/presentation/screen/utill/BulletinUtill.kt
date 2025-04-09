package ge.avalanche.zvavi.bulletin.presentation.screen.utill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSize
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

@Composable
fun StyledPyramidText(text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .widthIn(ZvaviSize.size250)
            .heightIn(ZvaviSize.size250)
            .clip(RoundedCornerShape(ZvaviRadius.radius300))
            .background(color = ZvaviTheme.colors.backgroundStaticLightHigh)
            .padding(horizontal = ZvaviSpacing.spacing150)
    ) {
        Text(
            text,
            style = ZvaviTheme.typography.compact300Numeric.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
        )
    }
}