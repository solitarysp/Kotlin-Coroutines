package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

private fun transformSimple(): Flow<Int> = flow { // flow builder
    for (i in 1..6) {
        delay(100) // Fake làm 1 điều gì đó và bị đình chỉ 100 ms
        emit(i) // emit next value sau khi đã có kết quả
    }
}

fun main() = runBlocking {
    transformSimple()
        .transform { request ->
            if (request > 2) {
                emit("Data > 2 :  $request")
            }
            if (request > 5) {
                emit("Data > 5 thi emit them data * 2 :  ${request * 2}")
            }
        }.collect { value -> println(value) }
}