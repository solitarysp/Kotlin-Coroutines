package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun cancellationFlowUseTimeOut(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(100) // pretend we are computing it
        yield(i) // yield next value
    }
}

fun main() = runBlocking {
    // Launch một concurrent coroutine để kiểm tra thread không bị block
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Chặn thread và chạy hết đã
    cancellationFlowUseTimeOut().forEach { value -> println(value) }
}