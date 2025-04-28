package ge.avalanche.zvavi.bulletin.presentation.screen.blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvalancheProblemsBottomSheet(
    layoutConfig: LayoutConfig,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f),
        sheetState = rememberModalBottomSheetState(),
        shape = RoundedCornerShape(
            topStart = ZvaviRadius.radius550,
            topEnd = ZvaviRadius.radius550
        ),
        containerColor = ZvaviTheme.colors.layerFloor1
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = layoutConfig.contentCompensation,
                    vertical = ZvaviSpacing.spacing200
                )
        ) {
            Row(modifier = Modifier) {
                Text(text = "Wet Loose")
            }
            Text(
                text = "Avalanche Problems",
                style = ZvaviTheme.typography.display400Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary,
                modifier = Modifier.padding(bottom = ZvaviSpacing.spacing300)
            )
            // Add your problem details here
            Text(
                text = "Persistent slab",
                style = ZvaviTheme.typography.compact300Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary,
                modifier = Modifier.padding(bottom = ZvaviSpacing.spacing200)
            )
            Text(
                text = "Wind slab",
                style = ZvaviTheme.typography.compact300Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary,
                modifier = Modifier.padding(bottom = ZvaviSpacing.spacing200)
            )
            Text(
                text = "Wet loose",
                style = ZvaviTheme.typography.compact300Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary,
                modifier = Modifier.padding(bottom = ZvaviSpacing.spacing200)
            )
        }
    }
} 