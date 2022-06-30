package flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println((1..5).asFlow().first())

        println((1..5).asFlow().last())

        println((1..5).asFlow().toList())
        println((1..5).asFlow().toSet())

        println((1..5).asFlow().reduce { a, b -> a + b })

        // Star với giá trị ban đầu
        println((1..5).asFlow().fold(5) { a, b -> a + b })
    }
}