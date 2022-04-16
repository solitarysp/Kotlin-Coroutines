import kotlinx.coroutines.*

fun main() {
    // scope parent
    runBlocking {
        // scope child 1 of parent
        launch(newSingleThreadContext("Ct1")) {
            for (i in 1..100_000) {
                // scope child 2 of child 1
                launch {
                    delay(5000L)
                    println(".")
                    delay(5000L)
                    println("..")
                }
            }
        }
    }
}
