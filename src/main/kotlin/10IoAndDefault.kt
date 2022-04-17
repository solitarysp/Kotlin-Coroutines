import kotlinx.coroutines.*
import sun.plugin2.util.SystemUtil
import java.lang.reflect.Field

fun main() {

    runBlocking(newSingleThreadContext("root Dispatcher")) {
            launch(Dispatchers.Default.limitedParallelism(1)) { // Sử dụng DefaultDispatcher
                println("Default: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().hashCode()} \n")

            }
        launch(Dispatchers.IO) { // Sử dụng thread của Default
            println("4: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().hashCode()} \n")
        }
        launch(Dispatchers.IO) { // Sử dụng thread của Default
            println("5: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().hashCode()} \n")
        }
    }

}

