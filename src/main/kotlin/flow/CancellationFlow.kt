package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

private fun cancellationFlowUseTimeOut(): Flow<Int> = flow {
    for (i in 1..50) {
        delay(100)
        println("cancellationFlowUseTimeOut Emitting $i")
        emit(i)
    }
}

private fun cancelCoroutines(): Flow<Int> = flow {
    for (i in 1..50) {
        delay(100)
        println("cancelCoroutines Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms
        cancellationFlowUseTimeOut().collect { value -> println(value) }
    }
    var jobCancelCoroutines = launch {
        cancelCoroutines().collect { value -> println(value) }
    }
    delay(250)
    jobCancelCoroutines.cancelAndJoin()
    println("Done")
}