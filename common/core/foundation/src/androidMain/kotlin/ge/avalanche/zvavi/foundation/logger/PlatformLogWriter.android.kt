package ge.avalanche.zvavi.foundation.logger

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.LogcatWriter

actual fun zvaviPlatformLogWriter(): LogWriter  = LogcatWriter()