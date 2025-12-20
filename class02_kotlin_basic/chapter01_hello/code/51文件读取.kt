import java.io.File

/**
 * Kotlin 文件读取示例程序
 * 演示多种文件读取方式
 */
fun main() {
    // 首先创建一个示例文件用于读取演示
    prepareSampleFile()

    // 1. 一次性读取整个文件内容为字符串
    readFileAsString()

    // 2. 按行读取文件内容
    readFileAsLines()

    // 3. 使用缓冲流逐行读取大文件（内存友好）
    readFileWithBufferedReader()
}

/**
 * 准备示例文件
 */
fun prepareSampleFile() {
    File("data.txt").writeText(
        """
        第一行内容
        Second line content
        第三行内容 with English
        最后一行内容
        """.trimIndent()
    )
    println("示例文件 data.txt 已创建")
}

/**
 * 方式一：一次性读取整个文件为字符串
 * 适用于小型文件
 */
fun readFileAsString() {
    println("\n=== 方式一：读取为字符串 ===")
    try {
        // 使用 readText() 方法一次性读取整个文件内容
        val content = File("data.txt").readText()
        println("文件内容：")
        println(content)
        println("总字符数：${content.length}")
    } catch (e: Exception) {
        println("读取文件失败：${e.message}")
    }
}

/**
 * 方式二：按行读取文件内容为列表
 * 适用于需要逐行处理的小到中型文件
 */
fun readFileAsLines() {
    println("\n=== 方式二：按行读取 ===")
    try {
        // 使用 readLines() 方法将文件内容按行分割为字符串列表
        val lines = File("data.txt").readLines()
        println("文件共有 ${lines.size} 行")

        // 遍历并打印每一行
        lines.forEachIndexed { index, line ->
            println("第${index + 1}行: $line")
        }
    } catch (e: Exception) {
        println("读取文件失败：${e.message}")
    }
}

/**
 * 方式三：使用缓冲读取器逐行读取
 * 适用于大型文件，节省内存
 */
fun readFileWithBufferedReader() {
    println("\n=== 方式三：缓冲流读取 ===")
    try {
        // 使用 bufferedReader() 创建缓冲读取器
        File("data.txt").bufferedReader().use { reader ->
            var lineNumber = 1
            var line: String?

            // 逐行读取直到文件结束
            while (reader.readLine().also { line = it } != null) {
                println("第${lineNumber}行: $line")
                lineNumber++
            }
            println("总共读取了 $lineNumber 行")
        }
    } catch (e: Exception) {
        println("读取文件失败：${e.message}")
    }
}