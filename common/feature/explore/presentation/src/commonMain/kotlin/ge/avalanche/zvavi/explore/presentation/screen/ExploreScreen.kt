package ge.avalanche.zvavi.explore.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ge.avalanche.zvavi.designsystem.components.expandableSection.ZvaviExpandableSection
import ge.avalanche.zvavi.designsystem.components.header.ZvaviHeader
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.strings.ZvaviStrings
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig
import ge.avalanche.zvavi.designsystem.tokens.layout.LocalLayoutConfig
import org.jetbrains.compose.resources.StringResource

private class ExploreExpandableSection(
    val title: String,
    val isExpanded: Boolean,
    val onExpandedChange: (Boolean) -> Unit,
    val content: @Composable ColumnScope.() -> Unit
)

@Composable
fun ExploreScreen() {
    val layoutConfig = LocalLayoutConfig.current
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        ExploreView(layoutConfig = layoutConfig)
    }
}

@Composable
fun ExploreView(
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = modifier.fillMaxSize().padding(
            vertical = ZvaviSpacing.spacing350,
            horizontal = layoutConfig.marginHorizontal,
        )
    ) {
        AvalancheBlock(layoutConfig = layoutConfig)

    }
}

@Composable
fun AvalancheBlock(
    layoutConfig: LayoutConfig,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing200),
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(
            top = ZvaviSpacing.spacing350,
            start = layoutConfig.contentCompensation,
            end = layoutConfig.contentCompensation
        )
    ) {
        ZvaviHeader(
            text = ZvaviStrings.explore,
            modifier = modifier.padding(
                top = ZvaviSpacing.spacing300 + ZvaviSpacing.spacing100,
                bottom = ZvaviSpacing.spacing100
            )
        )
        ZvaviExpandableSection(
            sectionTitle = { ExploreBodyText(text = ZvaviStrings.avalancheSafety,modifier = Modifier.weight(1f)) },
            isExpanded = true,
            onNavigateClick = { /* Handle navigation */ }
        )

    }
}

@Composable
fun ExploreBodyText(
    text: StringResource,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Avalanche problems",
        style = ZvaviTheme.typography.compact300Default,
        color = ZvaviTheme.colors.contentNeutralPrimary,
        modifier = modifier.fillMaxWidth().wrapContentHeight(),
    )
}