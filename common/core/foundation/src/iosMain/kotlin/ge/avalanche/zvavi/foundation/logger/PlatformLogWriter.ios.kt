package ge.avalanche.zvavi.foundation.logger

import co.touchlab.kermit.LogWriter
import co.touchlab.kermit.NSLogWriter

actual fun zvaviPlatformLogWriter(): LogWriter = NSLogWriter()