package ge.avalanche.zvavi.bulletin.presentation.screen.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ge.avalanche.zvavi.bulletin.api.models.AvalancheProblem
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinEvent
import ge.avalanche.zvavi.bulletin.presentation.models.BulletinViewState
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemAspectElevation
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemDistribution
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemSensitivity
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemTimeOfDay
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ProblemTrend
import ge.avalanche.zvavi.bulletin.presentation.screen.copmponents.views.problem.ZvaviProblemSize
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboard
import ge.avalanche.zvavi.designsystem.boards.ZvaviDashboardEvent
import ge.avalanche.zvavi.designsystem.dimens.ZvaviRadius
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.icons.ZvaviIcons
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme
import ge.avalanche.zvavi.designsystem.tokens.layout.LayoutConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AvalancheProblemsBottomSheet(
    viewState: BulletinViewState,
    problem: AvalancheProblem?,
    sheetState: SheetState,
    layoutConfig: LayoutConfig,
    onDismiss: () -> Unit,
    eventHandler: (BulletinEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        contentColor = ZvaviTheme.colors.layerFloor1,
        shape = RoundedCornerShape(
            topStart = ZvaviRadius.radius600, topEnd = ZvaviRadius.radius600
        ),
        sheetState = sheetState,
        modifier = modifier
            .fillMaxWidth(),
        containerColor = ZvaviTheme.colors.layerFloor1,
        dragHandle = null,
    ) {
        problem?.let {
            ModalContainer(
                viewState = viewState,
                problem = it,
                layoutConfig,
                eventHandler,
                modifier = Modifier.fillMaxHeight(0.8f)
            )
        }
    }
}

@Composable
private fun ModalContainer(
    viewState: BulletinViewState,
    problem: AvalancheProblem,
    layoutConfig: LayoutConfig,
    eventHandler: (BulletinEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Bottom) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = ZvaviSpacing.spacing300,
                    horizontal = layoutConfig.marginHorizontal + layoutConfig.contentCompensation
                )
        ) {
            Text(
                text = problem.type.value,
                style = ZvaviTheme.typography.compact400Accent,
                color = ZvaviTheme.colors.contentNeutralPrimary
            )
            RoundCrossButton(
                imageVector = ZvaviIcons.CrossButton,
                onClick = {
                    eventHandler(BulletinEvent.CloseBottomSheet)
                })


        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    top = ZvaviSpacing.spacing100,
                    bottom = ZvaviSpacing.spacing350,
                    start = layoutConfig.marginHorizontal,
                    end = layoutConfig.marginHorizontal,
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .padding(horizontal = layoutConfig.contentCompensation)
            ) {
                Text(
                    text = problem.description,
                    style = ZvaviTheme.typography.text300Default,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.padding(vertical = ZvaviSpacing.spacing100)
                )
            }
            DashBoard(
                viewState = viewState,
                problem = problem,
                eventHandler = eventHandler,
                layoutConfig = layoutConfig
            )
        }
    }
}

@Composable
private fun DashBoard(
    viewState: BulletinViewState,
    problem: AvalancheProblem,
    layoutConfig: LayoutConfig,
    eventHandler: (BulletinEvent) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            ZvaviDashboard(
                name = "Size",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                layoutConfig = layoutConfig,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                modifier = Modifier.weight(1f, fill = false)
            ) {

                Text(
                    text = " ${problem.avalancheSize}",
                    style = ZvaviTheme.typography.display500Accent,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                ZvaviProblemSize(
                    avalancheSize = problem.avalancheSize,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )

            }
            ZvaviDashboard(
                name = "Aspect / elevation",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                layoutConfig = layoutConfig,
                modifier = Modifier
                    .weight(1f, fill = false)
            ) {
                ProblemAspectElevation(
                    problem = problem,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }

        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min)
        ) {
            ZvaviDashboard(
                name = "Sensitivity",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                layoutConfig = layoutConfig,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = problem.sensitivity.keys.first(),
                    style = ZvaviTheme.typography.display350Accent,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                ProblemSensitivity(
                    problem = problem,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
            ZvaviDashboard(
                name = "Distribution",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                layoutConfig = layoutConfig,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = problem.distribution.keys.first(),
                    style = ZvaviTheme.typography.display350Accent,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                ProblemDistribution(
                    distributionPercentage = problem.distribution.values.first(),
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(ZvaviSpacing.spacing100),
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            ZvaviDashboard(
                name = "Trend",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                layoutConfig = layoutConfig,
                modifier = Modifier.weight(1f, fill = false)
            ) {
                Text(
                    text = problem.trend.direction,
                    style = ZvaviTheme.typography.display350Accent,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                ProblemTrend(
                    direction = problem.trend,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
            ZvaviDashboard(
                name = "Time of day",
                backgroundColor = ZvaviTheme.colors.overlayNeutral,
                eventHandler = { event ->
                    when (event) {
                        ZvaviDashboardEvent.InfoClicked -> eventHandler(BulletinEvent.CloseBottomSheet)
                    }
                    eventHandler(BulletinEvent.ProblemInfoClicked)
                },
                layoutConfig = layoutConfig,
                modifier = Modifier.weight(1f, fill = false)
            ) {
                Text(
                    text = if (problem.timeOfDay.isAllDay) {
                        "All day"
                    } else {
                        "${problem.timeOfDay.start}:00\n${problem.timeOfDay.end}:00"
                    },
                    style = ZvaviTheme.typography.display350Accent,
                    color = ZvaviTheme.colors.contentNeutralPrimary,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                ProblemTimeOfDay(
                    timeOfDay = problem.timeOfDay,
                    modifier = Modifier.align(Alignment.BottomEnd)
                )
            }
        }
    }
}

@Composable
private fun RoundCrossButton(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = ZvaviTheme.colors.overlayNeutral),
        contentPadding = PaddingValues(0.dp),
        modifier = modifier.size(32.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) { Icon(imageVector = imageVector, contentDescription = "close button") }
    }
}