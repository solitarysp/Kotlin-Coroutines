import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val parentJob = launch(newSingleThreadContext("Ctx1")) {
            val childJob = launch(newSingleThreadContext("Ctx12")) {
                var count = 1
                while (count <= 5) {
                    println("Count: $count")
                    delay(100)
                    count++
                }
            }
        }
        delay(250)
        println("Cancelling parent job")
        parentJob.cancel()
    }
}
