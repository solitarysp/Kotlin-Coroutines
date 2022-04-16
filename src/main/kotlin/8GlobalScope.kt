import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val parentJob = launch(newSingleThreadContext("Ctx1")) {
            GlobalScope.launch(newSingleThreadContext("Ctx12")) {
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
        delay(250)
    }
}
