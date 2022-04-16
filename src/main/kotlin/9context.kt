import kotlinx.coroutines.*

fun main() {
    runBlocking(newSingleThreadContext("root Dispatcher")) {
        launch {
            delay(10)
            println("1: My context is: $coroutineContext \n: I'm working in thread ${Thread.currentThread().name} \n")
        }
        launch(Dispatchers.Unconfined) { // not confined -- sử dụng Thread của Dispatcher bên ngoài
            println("2: My context is: $coroutineContext \n: I'm working in thread ${Thread.currentThread().name} \n")
            delay(100)
            println("2.1: My context is: $coroutineContext \n: I'm working in thread ${Thread.currentThread().name} \n")
            withContext(newSingleThreadContext("root Dispatcher 2")) {

            }
            println("2.2: My context is: $coroutineContext \n: I'm working in thread ${Thread.currentThread().name} \n")
        }
        launch(Dispatchers.Default) { // Sử dụng DefaultDispatcher
            delay(200)
            println("3: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().name} \n")
        }
        launch(Dispatchers.IO) { // Sử dụng DefaultDispatcher
            delay(300)
            println("4: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().name} \n")
        }
        // thêm element vào context
        launch(Dispatchers.Default  + CoroutineName("nameNew")) { // Sử dụng DefaultDispatcher
            delay(500)
            println("5: My context is: $coroutineContext  \n: I'm working in thread ${Thread.currentThread().name} \n")
        }
    }
}
