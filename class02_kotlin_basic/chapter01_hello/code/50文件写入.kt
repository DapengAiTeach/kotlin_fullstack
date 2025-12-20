import java.io.File

fun main() {
    // 1. 覆盖写字符串
    File("data.txt").writeText("Hello Kotlin")

    // 2. 追加写
    File("data.txt").appendText("Append line\n")

    // 3. 缓冲流大块写
    File("data.txt").bufferedWriter().use { writer ->
        repeat(1000) { writer.write("Line $it\n") }
    }

    // 验证文件内容
    println("out.txt内容:")
    println(File("data.txt").readText())

    println("\nbig.txt行数:")
    println(File("data.txt").readLines().size)
}
