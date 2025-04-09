package ge.avalanche.zvavi.designsystem.tokens.zvaviLayout

import androidx.compose.ui.unit.Dp

interface ZvaviLayoutContract {
    val breakpoint: String
    val minWidth: Dp
    val maxWidth: Dp
    val width: Dp
    val height: Dp
    val colNumber: Int
    val colWidth: Dp
    val gutter: Dp
    val marginHorizontal: Dp
    val contentCompensation: Dp
    val ignoreMarginHorizontal: Dp
}