import java.io.File

/**
 * Kotlin also函数示例程序
 * 演示also函数在数据处理链中的调试作用
 */
fun main() {
    // 创建文件并写入初始内容用于演示
    File("data.txt").writeText("   Hello, Kotlin!   \n\t  ")

    // 使用链式调用处理文件内容，并在关键步骤插入调试信息
    val data = File("data.txt")
        // 读取文件内容
        .readText()
        // also函数用于在不中断链式调用的情况下插入副作用操作（如日志）
        .also { println("原始长度=${it.length}") } // 插入日志，显示原始内容长度
        // 去除首尾空白字符（包括空格、换行符、制表符等）
        .trim()
        // 再次使用also插入日志，显示去除空白后的长度
        .also { println("去空后=${it.length}") }

    // 输出最终处理结果
    println("最终内容: '$data'")
    println("最终长度: ${data.length}")
}
