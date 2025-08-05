package ge.avalanche.zvavi.designsystem.components.header

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ZvaviHeader(text: StringResource, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(text),
        style = ZvaviTheme.typography.display400Accent.copy(color = ZvaviTheme.colors.contentNeutralPrimary),
        modifier = modifier.fillMaxWidth().wrapContentHeight()
    )
}