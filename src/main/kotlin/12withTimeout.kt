import kotlinx.coroutines.*
import sun.plugin2.util.SystemUtil
import java.lang.reflect.Field

fun main() {

    runBlocking(newSingleThreadContext("root Dispatcher")) {
        withTimeout(10000L) {
            launch {
                delay(500L)
                println("B")
            }
            launch {
                delay(500000L)
                println("C")
            }
        }
    }
}

