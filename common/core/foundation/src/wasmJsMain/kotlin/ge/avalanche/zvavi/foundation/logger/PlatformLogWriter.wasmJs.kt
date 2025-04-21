package ge.avalanche.zvavi.foundation.logger

import co.touchlab.kermit.ConsoleWriter
import co.touchlab.kermit.LogWriter

actual fun zvaviPlatformLogWriter(): LogWriter  = ConsoleWriter()