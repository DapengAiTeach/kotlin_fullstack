fun main() {
    kotlin.io.println("请输入昵称：")
    val nick: String? = kotlin.io.readLine()
    val len = nick?.length        // 安全调用
    kotlin.io.println("字符数=${len ?: 0}") // 与 Elvis 组合兜底
}