package ge.avalanche.zvavi.foundation.logger


import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity

object LoggerConfig {
    fun initLogger() {
        Logger.setLogWriters(zvaviPlatformLogWriter())
        Logger.setMinSeverity(Severity.Debug)
    }
}