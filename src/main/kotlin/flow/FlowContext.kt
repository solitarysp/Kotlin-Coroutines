package flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main() {
    runBlocking {
        withContext(newSingleThreadContext("Ctx1")) {
            (1..5).asFlow().collect {
                println("Example1: $it :  ${Thread.currentThread().name}")
            }
        }
    }
}