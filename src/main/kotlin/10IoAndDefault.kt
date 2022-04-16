import kotlinx.coroutines.*
import sun.plugin2.util.SystemUtil
import java.lang.reflect.Field

fun main() {

    runBlocking(newSingleThreadContext("root Dispatcher")) {

        launch(Dispatchers.Default) { // Sử dụng DefaultDispatcher
            println("A")
        }
        launch(Dispatchers.IO) { // Sử dụng DefaultDispatcher
            println("B")
        }
    }

}

