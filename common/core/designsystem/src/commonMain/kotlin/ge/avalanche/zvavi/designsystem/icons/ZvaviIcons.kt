package ge.avalanche.zvavi.designsystem.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.vectorResource
import zvaviapp.common.core.designsystem.generated.resources.Res
import zvaviapp.common.core.designsystem.generated.resources.avalanche_risk_level_4
import zvaviapp.common.core.designsystem.generated.resources.cross_button
import zvaviapp.common.core.designsystem.generated.resources.icon_problem_wet_loose
import zvaviapp.common.core.designsystem.generated.resources.info_20dp
import zvaviapp.common.core.designsystem.generated.resources.level_high4
import zvaviapp.common.core.designsystem.generated.resources.overal_risk_border

object ZvaviIcons {
    val InfoIcon: ImageVector
        @Composable get() = vectorResource(Res.drawable.info_20dp)
    val AvalancheRiskLevel4: ImageVector
        @Composable get() = vectorResource(Res.drawable.avalanche_risk_level_4)
    val AvalancheProblemWetLoose: ImageVector
        @Composable get() = vectorResource(Res.drawable.icon_problem_wet_loose)
    val OverallRiskBorder: ImageVector
        @Composable get() = vectorResource(Res.drawable.overal_risk_border)
    val OverallRiskIcon: ImageVector
        @Composable get() = vectorResource(Res.drawable.level_high4)
    val CrossButton: ImageVector
    @Composable get() = vectorResource(Res.drawable.cross_button)


}