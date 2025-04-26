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
            alpine = AvalancheRiskLevel.GENERAL_INFORMATION,
            overall = AvalancheRiskLevel.GENERAL_INFORMATION,
            subAlpine = AvalancheRiskLevel.GENERAL_INFORMATION,
            highAlpine = AvalancheRiskLevel.GENERAL_INFORMATION
        )
    }
}