import kotlinx.coroutines.*

fun main() {
    // scope parent
    runBlocking {
        coroutineScope {
            delay(5000L)
            println(".")
            delay(5000L)
            println("..")
        }
    }
}
