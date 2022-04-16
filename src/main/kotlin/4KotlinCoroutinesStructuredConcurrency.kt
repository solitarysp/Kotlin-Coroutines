import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val parentJob = launch(newSingleThreadContext("Ctx1")) {
            val childJob = launch(newSingleThreadContext("Ctx12")) {
                var count = 1
                val startTime = System.currentTimeMillis()
                var nextPrintTime = startTime
                while (count <= 5 && isActive) {
                    if (System.currentTimeMillis() >= nextPrintTime) {
                        println("Count: $count")
                        nextPrintTime += 100L
                        count++
                    }
                }
            }
        }
        delay(250)
        println("Cancelling parent job")
        parentJob.cancel()
    }}
