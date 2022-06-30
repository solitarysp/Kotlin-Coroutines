package flow

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun flowOperators(): Flow<Int> = flow { // flow builder
    for (i in 1..10) {
        emit(i)
    }
}

private suspend fun testFunction(int: Int) {
    println("$int testFunction ${Thread.currentThread().name}")
    delay(1000L)
}

fun main() {
    val flow = flowOperators()
        .buffer()
        .filter { i -> i % 2 == 0 }
        .map {
           // async {}
            it * 2
        }

    runBlocking {
        async {

        }
        flow.collect { }
    }
}