package ge.avalanche.zvavi.designsystem.animation.shimmer

/**
 * Represents the state of shimmer animation
 * @property isActive Whether the shimmer effect is currently active
 */
data class ShimmerState(val isActive: Boolean) {
    companion object {
        val Active = ShimmerState(isActive = true)
        val Inactive = ShimmerState(isActive = false)
    }
}