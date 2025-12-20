import java.io.File
import kotlin.io.writeText
import kotlin.run


fun main() {
    // 有接收者：先初始化再计算
    // run函数扩展函数形式，对接收者File("data.txt")执行操作
    val size = java.io.File("data.txt").run {
        // 调用File对象的createNewFile()方法
        java.io.File.createNewFile()
        // 调用File对象的writeText()方法
        writeText("Hi")
        // 调用File对象的length()方法，返回计算值
        java.io.File.length()
    }

    // 无接收者：立即执行块
    // run函数顶层函数形式，直接执行代码块
    val token = kotlin.run {
        // 调用generateToken()函数
        val t = generateToken()
        kotlin.io.println("新生成 token: $t")
        // 最后一行作为返回值
        t
    }

    kotlin.io.println("文件大小: $size 字节")
    kotlin.io.println("生成的token: $token")
}

/**
 * 模拟生成token的函数
 */
fun generateToken(): String {
    return "abc123xyz"
}
