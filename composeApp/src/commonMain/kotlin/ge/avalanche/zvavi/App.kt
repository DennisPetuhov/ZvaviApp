package ge.avalanche.zvavi

import androidx.compose.runtime.Composable
import ge.avalanche.zvavi.bulletin.data.di.bulletinDataModule
import ge.avalanche.zvavi.network.di.networkModule
import org.koin.compose.KoinApplication

@Composable
internal fun App() = KoinApplication(application = {
    modules(
        networkModule,
        bulletinDataModule
    )
}) {
    ZvaviApp()
}
