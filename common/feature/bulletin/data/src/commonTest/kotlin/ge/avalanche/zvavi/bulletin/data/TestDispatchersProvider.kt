package ge.avalanche.zvavi.bulletin.data

import ge.avalanche.zvavi.common.core.foundation.base.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.UnconfinedTestCoroutineDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatchersProvider : DispatchersProvider {
    private val testDispatcher = UnconfinedTestCoroutineDispatcher()
    
    override val io: CoroutineDispatcher = testDispatcher
    override val main: CoroutineDispatcher = testDispatcher
    override val default: CoroutineDispatcher = testDispatcher
    
    fun cleanup() {
        testDispatcher.cleanupTestCoroutines()
    }
} 