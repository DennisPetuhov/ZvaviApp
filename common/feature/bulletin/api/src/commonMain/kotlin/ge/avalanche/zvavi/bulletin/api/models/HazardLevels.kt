package ge.avalanche.zvavi.bulletin.api.models

import kotlinx.serialization.Serializable

@Serializable
data class HazardLevels(
    val alpine: AvalancheRiskLevel,
    val overall: AvalancheRiskLevel,
    val subAlpine: AvalancheRiskLevel,
    val highAlpine: AvalancheRiskLevel,
){
    companion object{
        val EMPTY = HazardLevels(
            alpine = AvalancheRiskLevel.NO_INFO,
            overall = AvalancheRiskLevel.NO_INFO,
            subAlpine = AvalancheRiskLevel.NO_INFO,
            highAlpine = AvalancheRiskLevel.NO_INFO
        )
    }
}