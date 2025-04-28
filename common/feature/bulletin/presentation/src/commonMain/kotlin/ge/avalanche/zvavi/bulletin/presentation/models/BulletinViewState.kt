package ge.avalanche.zvavi.bulletin.presentation.models

import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel

data class BulletinViewState(
    val riskLevelOverall: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val overallInformation: String = "",
    val avalancheRiskLevel: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val travelAdvice: String = "",
    val riskLevelHighAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val riskLevelAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val riskLevelSubAlpine: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val problems: List<String> = emptyList(),
    val recentAvalanches: List<String> = emptyList(),
    val snowpack: String = "WOWOWO",
    val weather: String = "WOWOWOOWOWOWO",
    val loading: Boolean = false,
    val error: String? = null,
    val topTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val middleTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,
    val bottomTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.GENERAL_INFORMATION,

    ) {
    companion object {
        val EMPTY = BulletinViewState()
    }
}

