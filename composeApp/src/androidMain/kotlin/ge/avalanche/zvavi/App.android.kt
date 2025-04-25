package ge.avalanche.zvavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val platformConfig = PlatformConfiguration(applicationContext)

        Inject.createDependencies(platformConfig) {
        }

        enableEdgeToEdge()
        setContent { App(platformConfig) }
    }
}