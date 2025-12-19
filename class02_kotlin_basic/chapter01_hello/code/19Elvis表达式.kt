fun main() {
    kotlin.io.println("请输入你的昵称：")
    val nick: String? = kotlin.io.readLine()
    val display = nick ?: "匿名"       // Elvis 兜底
    kotlin.io.println("你好，$display")
}