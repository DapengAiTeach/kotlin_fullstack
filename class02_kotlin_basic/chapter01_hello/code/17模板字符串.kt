fun main() {
    val name = "Kotlin"
    val stars = 5
    kotlin.io.println("语言：$name，星级：$stars")           // 语言：Kotlin，星级：5
    kotlin.io.println("长度：${name.length}")              // 长度：6
    
    val flag = true
    kotlin.io.println("状态：${if (flag) "上线" else "下线"}") // 状态：上线
}