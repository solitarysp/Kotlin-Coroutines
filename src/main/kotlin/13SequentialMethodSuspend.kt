import kotlinx.coroutines.*
import sun.plugin2.util.SystemUtil
import java.lang.reflect.Field
import kotlin.system.measureTimeMillis

fun main() {

    //measureTimeMillis là method sử dụng để đo thời gian call

    // defult tuần tự từng method một
    runBlocking() {
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            println("The answer is ${one + two}")
        }
        println("Completed in $time ms")
    }

    // async  chờ kết quả cả 2 method chạy xong xong
    runBlocking() {
        val time = measureTimeMillis {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }


}


suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne")
    delay(3000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo")
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}
