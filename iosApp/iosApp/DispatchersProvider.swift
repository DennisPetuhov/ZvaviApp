import Foundation
import shared
 
class IosDispatchersProvider: DispatchersProvider {
    let io: CoroutineDispatcher = Dispatchers.Default
    let main: CoroutineDispatcher = Dispatchers.Main
    let default_: CoroutineDispatcher = Dispatchers.Default
} 