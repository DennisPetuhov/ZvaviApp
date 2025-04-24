package ge.avalanche.zvavi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ge.avalanche.zvavi.database.platform.PlatformConfiguration
import ge.avalanche.zvavi.di.Inject

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val platformConfig = PlatformConfiguration(applicationContext)

        Inject.createDependencies(platformConfig) {
            // Additional modules can be added here if needed
        }
        
        enableEdgeToEdge()
        setContent { App(platformConfig) }
    }
}