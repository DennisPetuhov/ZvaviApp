package ge.avalanche.zvavi.designsystem.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.vectorResource
import zvaviapp.common.core.designsystem.generated.resources.Res
import zvaviapp.common.core.designsystem.generated.resources.cross_button
import zvaviapp.common.core.designsystem.generated.resources.icon_problem_wet_loose
import zvaviapp.common.core.designsystem.generated.resources.info_20dp
import zvaviapp.common.core.designsystem.generated.resources.risk_considerable
import zvaviapp.common.core.designsystem.generated.resources.risk_extreme
import zvaviapp.common.core.designsystem.generated.resources.risk_high
import zvaviapp.common.core.designsystem.generated.resources.risk_low
import zvaviapp.common.core.designsystem.generated.resources.risk_moderate

object ZvaviIcons {
    val InfoIcon: ImageVector
        @Composable get() = vectorResource(Res.drawable.info_20dp)
    val AvalancheProblemWetLoose: ImageVector
        @Composable get() = vectorResource(Res.drawable.icon_problem_wet_loose)
    val CrossButton: ImageVector
        @Composable get() = vectorResource(Res.drawable.cross_button)
    val RiskLevelLow: ImageVector
        @Composable get() = vectorResource(Res.drawable.risk_low)
    val RiskLevelModerate: ImageVector
        @Composable get() = vectorResource(Res.drawable.risk_moderate)
    val RiskLevelConsiderable: ImageVector
        @Composable get() = vectorResource(Res.drawable.risk_considerable)
    val RiskLevelHigh: ImageVector
        @Composable get() = vectorResource(Res.drawable.risk_high)
    val RiskLevelExtreme: ImageVector
        @Composable get() = vectorResource(Res.drawable.risk_extreme)
}