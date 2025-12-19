fun main() {
    val nick: String? = kotlin.io.readLine()
    val len = nick?.length ?: 0        // 安全调用 + Elvis
    kotlin.io.println("字符数=$len")
}