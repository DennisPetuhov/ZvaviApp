package ge.avalanche.zvavi.foundation.logger

import co.touchlab.kermit.CommonWriter
import co.touchlab.kermit.LogWriter

actual fun zvaviPlatformLogWriter(): LogWriter =  CommonWriter()