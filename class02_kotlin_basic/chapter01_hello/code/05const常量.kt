const val MAX_RETRY = 3              // 顶层
const val API_BASE = "https://api.x.com"

object UiConst {
    const val TAG_HOME = "HOME"      // object 内
}

fun main() {
    kotlin.io.println(MAX_RETRY)               // 输出：3
    kotlin.io.println(UiConst.TAG_HOME)        // 输出：HOME
}