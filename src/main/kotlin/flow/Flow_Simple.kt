package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun cancellationFlowUseTimeOut(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // Fake làm 1 điều gì đó và bị đình chỉ 100 ms
        emit(i) // emit next value sau khi đã có kết quả
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
    // Collect the flow
    cancellationFlowUseTimeOut().collect { value -> println(value) }
}