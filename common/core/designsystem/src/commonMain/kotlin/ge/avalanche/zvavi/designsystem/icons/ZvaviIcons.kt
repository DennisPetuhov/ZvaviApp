package ge.avalanche.zvavi.designsystem.icons

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.vectorResource
import zvaviapp.common.core.designsystem.generated.resources.Res
import zvaviapp.common.core.designsystem.generated.resources.cornice_fall
import zvaviapp.common.core.designsystem.generated.resources.cross_button
import zvaviapp.common.core.designsystem.generated.resources.deep_persistent_slab
import zvaviapp.common.core.designsystem.generated.resources.dry_loose
import zvaviapp.common.core.designsystem.generated.resources.glode_avalanche
import zvaviapp.common.core.designsystem.generated.resources.info_20dp
import zvaviapp.common.core.designsystem.generated.resources.persistent_slab
import zvaviapp.common.core.designsystem.generated.resources.risk_considerable
import zvaviapp.common.core.designsystem.generated.resources.risk_extreme
import zvaviapp.common.core.designsystem.generated.resources.risk_high
import zvaviapp.common.core.designsystem.generated.resources.risk_low
import zvaviapp.common.core.designsystem.generated.resources.risk_moderate
import zvaviapp.common.core.designsystem.generated.resources.storm_slam
import zvaviapp.common.core.designsystem.generated.resources.wet_loose
import zvaviapp.common.core.designsystem.generated.resources.wet_slab
import zvaviapp.common.core.designsystem.generated.resources.wind_slab

object ZvaviIcons {
    val InfoIcon: ImageVector
        @Composable get() = vectorResource(Res.drawable.info_20dp)
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
    val AvalancheProblemWetLoose: ImageVector
        @Composable get() = vectorResource(Res.drawable.wet_loose)
    val AvalancheProblemDryLoose: ImageVector
        @Composable get() = vectorResource(Res.drawable.dry_loose)
    val AvalancheProblemCorniceFall: ImageVector
        @Composable get() = vectorResource(Res.drawable.cornice_fall)
    val AvalancheProblemWindSlab: ImageVector
        @Composable get() = vectorResource(Res.drawable.wind_slab)
    val AvalancheProblemPersistentSlab: ImageVector
        @Composable get() = vectorResource(Res.drawable.persistent_slab)
    val AvalancheProblemDeepPersistentSlab: ImageVector
        @Composable get() = vectorResource(Res.drawable.deep_persistent_slab)
    val AvalancheProblemGlideAvalanche: ImageVector
        @Composable get() = vectorResource(Res.drawable.glode_avalanche)
    val AvalancheProblemStormSlab: ImageVector
        @Composable get() = vectorResource(Res.drawable.storm_slam)
    val AvalancheProblemWetSlab: ImageVector
        @Composable get() = vectorResource(Res.drawable.wet_slab)
}