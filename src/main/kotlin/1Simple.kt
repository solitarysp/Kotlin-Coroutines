import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch {
            doWorld()
        }
        delay(100L)
        println("Hello ${Thread.currentThread().name}")
        job.isActive
    }
}

suspend fun doWorld() {
    delay(1000L)
    println("World! ${Thread.currentThread().name}")
}
