package ge.avalanche.zvavi.bulletin.presentation.models

import ge.avalanche.zvavi.bulletin.api.models.AvalancheRiskLevel

data class BulletinViewState(
    val riskLevelOverall: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val overallInformation: String = "",
    val avalancheRiskLevel: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val travelAdvice: String = "",
    val riskLevelHighAlpine: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val riskLevelAlpine: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val riskLevelSubAlpine: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val problems: List<String> = emptyList(),
    val recentAvalanches: List<String> = emptyList(),
    val snowpack: String = "",
    val weather: String = "",
    val loading: Boolean = true,
    val error: String? = null,
    val topTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val middleTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val bottomTriangleColor: AvalancheRiskLevel = AvalancheRiskLevel.NO_INFO,
    val showBottomSheet: Boolean = false

    ) {
    companion object {
        val EMPTY = BulletinViewState()
    }
}

