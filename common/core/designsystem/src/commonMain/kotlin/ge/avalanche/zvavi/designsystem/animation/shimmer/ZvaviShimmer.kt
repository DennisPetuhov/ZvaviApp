package ge.avalanche.zvavi.designsystem.animation.shimmer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.node.currentValueOf
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

private const val SHIMMER_ANIMATION_DURATION = 1200
private const val SHIMMER_GRADIENT_WIDTH = 100f
private const val SHIMMER_DEFAULT_CORNER_RADIUS = 8

/**
 * CompositionLocal that provides the current shimmer state
 */
val LocalShimmerState = compositionLocalOf { ShimmerState.Inactive }

/**
 * Provider component that makes shimmer state available to child composables
 * @param shimmerState The current state of shimmer animation
 * @param content The content to be displayed with shimmer effect
 */
@Composable
fun ZvaviShimmerProvider(shimmerState: ShimmerState, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalShimmerState provides shimmerState
    ) { content() }
}

/**
 * Utility object for shimmer-related constants and default values
 */
object ZvaviShimmer {
    /**
     * Returns the default colors for shimmer effect
     * @return List of colors for shimmer gradient
     */
    @Composable
    fun getDefaultColors(): List<Color> = listOf(
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f)
    )
}

private class ShimmerNode(
    var shimmerColors: List<Color>,
    var animationValue: Float
) : Modifier.Node(), DrawModifierNode, CompositionLocalConsumerModifierNode {
    var shimmerJob: Job? = null
    private val alpha = Animatable(1f)
    private var shimmerState = ShimmerState.Inactive

    override fun ContentDrawScope.draw() {
        shimmerState = currentValueOf(LocalShimmerState)

        if (shimmerState.isActive) {
            val brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(animationValue - SHIMMER_GRADIENT_WIDTH, animationValue - SHIMMER_GRADIENT_WIDTH),
                end = Offset(animationValue + SHIMMER_GRADIENT_WIDTH, animationValue + SHIMMER_GRADIENT_WIDTH),
            )
            drawRect(brush)
        }
        drawContent()
    }

    override fun onAttach() {
        shimmerJob = coroutineScope.launch {
            alpha.animateTo(
                0f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = SHIMMER_ANIMATION_DURATION,
                        easing = LinearEasing,
                    ),
                    repeatMode = RepeatMode.Restart,
                )
            )
        }
    }

    override fun onDetach() {
        shimmerJob?.cancel()
    }
}

private class ShimmerElement(
    private val shimmerColors: List<Color>,
    private val animationValue: Float
) : ModifierNodeElement<ShimmerNode>() {
    override fun create(): ShimmerNode = ShimmerNode(shimmerColors, animationValue)

    override fun update(node: ShimmerNode) {
        node.shimmerColors = shimmerColors
        node.animationValue = animationValue
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ShimmerElement) return false
        return shimmerColors == other.shimmerColors &&
                animationValue == other.animationValue
    }

    override fun hashCode(): Int {
        var result = shimmerColors.hashCode()
        result = 31 * result + animationValue.hashCode()
        return result
    }
}

/**
 * Modifier that applies shimmer effect to a composable
 * @param shimmerColors List of colors for shimmer gradient
 * @param shape Shape of the shimmer effect
 * @return Modifier with shimmer effect
 */
@Composable
fun Modifier.shimmerEffect(
    shimmerColors: List<Color> = ZvaviShimmer.getDefaultColors(),
    shape: Shape = RoundedCornerShape(SHIMMER_DEFAULT_CORNER_RADIUS.dp),
): Modifier {
    val transition = rememberInfiniteTransition(label = "shimmer_transition")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 500f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = SHIMMER_ANIMATION_DURATION,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "shimmer_animation",
    ).value

    return this.then(ShimmerElement(shimmerColors, translateAnimation))
}