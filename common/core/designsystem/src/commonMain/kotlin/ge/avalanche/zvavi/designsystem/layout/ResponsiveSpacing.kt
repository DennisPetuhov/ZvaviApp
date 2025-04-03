package ge.avalanche.zvavi.designsystem.layout

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

@Composable
fun Modifier.responsiveSpacing(
    horizontal: Boolean = true,
    vertical: Boolean = true
) = composed {
    val config = LocalLayoutConfig.current
    when {
        horizontal && vertical -> padding(
            horizontal = config.marginHorizontal,
            vertical = config.contentCompensation
        )

        horizontal -> padding(horizontal = config.marginHorizontal)
        vertical -> padding(vertical = config.contentCompensation)
        else -> this
    }
}
//
//@Composable
//fun ResponsiveComponent() {
//    ResponsiveContainer {
//        Column(
//            modifier = Modifier
//                .responsiveSpacing()
//                .responsiveComponentSpacing()
//        ) {
//            Text(
//                text = "Responsive Text",
//                modifier = Modifier.responsiveTextStyle(),
//                fontSize = responsiveSize(16.dp).value.sp
//            )
//
//            Button(
//                onClick = { },
//                modifier = Modifier.responsiveTouchTarget()
//            ) {
//                Text("Click Me")
//            }
//        }
//    }
//}

//@Composable
//fun responsiveSize(baseSize: Dp): Dp {
//    val windowSize = LocalWindowSize.current
//    return when (windowSize) {
//        WindowSize.COMPACT -> baseSize * 0.8f // This was wrong
//        WindowSize.TABLET_PORTRAIT -> baseSize * 0.9f // This was wrong
//        WindowSize.TABLET_LANDSCAPE -> baseSize * 0.95f // This was wrong
//        WindowSize.DESKTOP -> baseSize // This was wrong
//    }
//}

//@Composable
//fun ResponsiveContainer(
//    modifier: Modifier = Modifier,
//    content: @Composable () -> Unit
//) {
//    val config = LocalLayoutConfig.current
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = config.marginHorizontal) // Uses spacing.100 (4.dp) for mobile
//    ) {
//        content()
//    }
//}