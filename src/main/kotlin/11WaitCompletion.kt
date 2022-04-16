import kotlinx.coroutines.*
import sun.plugin2.util.SystemUtil
import java.lang.reflect.Field

fun main() {

    runBlocking(newSingleThreadContext("root Dispatcher")) {
        var job = launch(Dispatchers.Default) { // Sử dụng DefaultDispatcher
            delay(1000)
            println("Done launch")
        }
        job.join() // hoặc gọi cancel và chờ job.cancelAndJoin()
        println("Done")
    }

    runBlocking(newSingleThreadContext("root Dispatcher")) {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // cancellable computation loop
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L) // delay a bit
        job.cancelAndJoin()
        println("Done")

    }



}

