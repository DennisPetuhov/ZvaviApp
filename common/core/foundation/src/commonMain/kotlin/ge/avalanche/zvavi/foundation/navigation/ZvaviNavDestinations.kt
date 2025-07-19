package ge.avalanche.zvavi.foundation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink


interface ZvaviNavDestinations : ZvaviNavAnimations {
    val route: String
    val arguments: List<NamedNavArgument>
    fun getDeepLinks(): List<NavDeepLink> = listOf()
} 