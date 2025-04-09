package ge.avalanche.zvavi.designsystem.tokens.base

import androidx.compose.runtime.Immutable
import ge.avalanche.zvavi.designsystem.dimens.ZvaviSpacing
import ge.avalanche.zvavi.designsystem.tokens.zvaviLayout.ZvaviLayoutContract


@Immutable
abstract class BaseMobileLayout : ZvaviLayoutContract {
    override val breakpoint = "mobile"
    override val marginHorizontal = ZvaviSpacing.spacing100
    override val contentCompensation = ZvaviSpacing.spacing350
    override val ignoreMarginHorizontal = -marginHorizontal
}

@Immutable
abstract class BaseTabletLayout : ZvaviLayoutContract {
    override val marginHorizontal = ZvaviSpacing.spacing400
    override val contentCompensation = ZvaviSpacing.spacing0
    override val ignoreMarginHorizontal = -marginHorizontal
}

@Immutable
abstract class BaseDesktopLayout : ZvaviLayoutContract {
    override val marginHorizontal = ZvaviSpacing.spacing700
    override val contentCompensation = ZvaviSpacing.spacing0
    override val ignoreMarginHorizontal = -marginHorizontal
}