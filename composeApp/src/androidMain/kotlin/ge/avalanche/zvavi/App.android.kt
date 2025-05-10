package ge.avalanche.zvavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.core.view.WindowCompat

import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val platformConfig = PlatformConfiguration(applicationContext)

        Inject.createDependencies(platformConfig) {}
//        val systemBarsPadding = WindowInsets.systemBars
//            .only(WindowInsetsSides.Top)
//            .asPaddingValues()

        enableEdgeToEdge()
        setContent { App(platformConfig) }
    }
}