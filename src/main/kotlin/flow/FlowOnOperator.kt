package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    simple()
        .map {
            println("Task 1 : $it :  ${Thread.currentThread().name}")
            delay(10000)
            it
        }
        .flowOn(newSingleThreadContext("Ctx1"))
        .map {
            println("Task 2 : $it :  ${Thread.currentThread().name}")
            it
        }
        .flowOn(newSingleThreadContext("Ctx2"))
        .map {
            println("Task 3: $it :  ${Thread.currentThread().name}")
            it
        }
        .collect {  }
}