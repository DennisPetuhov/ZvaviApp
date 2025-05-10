package ge.avalanche.zvavi.bulletin.presentation.screen.boards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig

@Composable
fun RiskBoard(
    backgroundColor: Color = ZvaviTheme.colors.backgroundNegativeHigh,
    avalancheRiskLevel: ImageVector = ZvaviIcons.AvalancheRiskLevel4,
    modifier: Modifier = Modifier
) {
    val layoutConfig = LocalLayoutConfig.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(ZvaviRadius.radius550))
            .background(color = backgroundColor)
            .padding(
                vertical = ZvaviSpacing.spacing350,
                horizontal = layoutConfig.contentCompensation
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight().weight(3.5f, fill = false)
        ) {
            Text(
                text = "Overall risk level",
                style = ZvaviTheme.typography.text250Default.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
            )
            Text(
                text = "High",
                style = ZvaviTheme.typography.display500Accent.copy(color = ZvaviTheme.colors.contentStaticDarkPrimary),
                modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
            )
        }
        Image(
            imageVector = avalancheRiskLevel,
            contentDescription = "danger level",
            modifier = Modifier.weight(1f, fill = false).aspectRatio(1f)
        )
    }
}