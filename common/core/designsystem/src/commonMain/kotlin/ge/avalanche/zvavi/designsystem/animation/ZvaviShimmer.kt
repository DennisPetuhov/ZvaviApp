package ge.avalanche.zvavi.designsystem.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ge.avalanche.zvavi.designsystem.theme.ZvaviTheme

data class ShimmerState(val isLoading: Boolean = false)

val LocalShimmerState = staticCompositionLocalOf { ShimmerState() }

@Composable
fun ShimmerProvider(isLoading: Boolean, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalShimmerState provides ShimmerState(isLoading = isLoading),
        content = content
    )
}

object ZvaviShimmer {
    val state: ShimmerState
        @Composable
        get() = LocalShimmerState.current
        
    @Composable
    fun getDefaultColors(): List<Color> = listOf(
        ZvaviTheme.colors.backgroundNeutralLow.copy(alpha = 0.0f),
        ZvaviTheme.colors.backgroundNeutralHigh.copy(alpha = 0.3f),
        ZvaviTheme.colors.backgroundNeutralLow.copy(alpha = 0.0f)
    )
}

private class ShimmerNode(
    var shimmerColors: List<Color>,
    var animationValue: Float
) : Modifier.Node(), DrawModifierNode {
    var shimmerJob: Job? = null
    private val alpha = Animatable(1f)

    override fun ContentDrawScope.draw() {
        // Original implementation that replaces content
        val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset(animationValue - size.width, 0f),
            end = Offset(animationValue, size.height),
        )
        drawRect(brush)
    }

    override fun onAttach() {
        shimmerJob = coroutineScope.launch {
            alpha.animateTo(
                0f, animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1000,
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

    override fun create(): ShimmerNode {
        return ShimmerNode(shimmerColors, animationValue)
    }

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

@Composable
fun Modifier.shimmerEffect(
    shimmerColors: List<Color> = ZvaviShimmer.getDefaultColors(),
    shape: Shape = RoundedCornerShape(8.dp),
): Modifier {
    if (!ZvaviShimmer.state.isLoading) return this
    
    val transition = rememberInfiniteTransition(label = "shimmer_transition")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,  // Faster animation
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "shimmer_animation",
    ).value

    return this.then(ShimmerElement(shimmerColors, translateAnimation))
}