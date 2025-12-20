import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption

/**
 * Kotlin 文件复制示例程序
 * 演示多种文件复制方式和使用场景
 */
fun main() {
    // 1. 准备源文件用于复制演示
    prepareSourceFiles()

    // 2. 演示基本文件复制
    basicFileCopy()

    // 3. 演示带选项的文件复制
    advancedFileCopy()

    // 4. 演示目录复制
    directoryCopy()

    // 5. 清理演示文件
    cleanupFiles()
}

/**
 * 准备源文件用于复制操作
 */
fun prepareSourceFiles() {
    println("=== 准备源文件 ===")

    // 创建源文件
    File("source.txt").writeText("这是要复制的源文件内容\n包含多行文本")
    println("创建源文件: source.txt")

    // 创建源目录及其中的文件
    val sourceDir = File("source_dir")
    sourceDir.mkdirs()
    File(sourceDir, "file1.txt").writeText("目录文件1")
    File(sourceDir, "file2.txt").writeText("目录文件2")
    File(sourceDir, "subdir").mkdirs()
    File(File(sourceDir, "subdir"), "nested.txt").writeText("嵌套文件")
    println("创建源目录: source_dir")

    println()
}

/**
 * 基本文件复制 - 使用 Kotlin 标准库方法
 * 适用于简单的文件复制需求
 */
fun basicFileCopy() {
    println("=== 基本文件复制 ===")

    try {
        val sourceFile = File("source.txt")
        val targetFile = File("basic_copy.txt")

        // 使用 Kotlin 的 copyTo 方法进行基本复制
        sourceFile.copyTo(targetFile)
        println("✓ 成功复制文件: ${sourceFile.name} -> ${targetFile.name}")
        println("  复制后内容: ${targetFile.readText()}")

    } catch (e: Exception) {
        println("✗ 文件复制失败: ${e.message}")
    }

    println()
}

/**
 * 高级文件复制 - 使用 Java NIO 并指定复制选项
 * 适用于需要特殊复制行为的场景
 */
fun advancedFileCopy() {
    println("=== 高级文件复制 ===")

    try {
        val sourceFile = File("source.txt")
        val targetFile = File("advanced_copy.txt")

        // 使用 Java NIO 的 Files.copy 方法
        // StandardCopyOption.REPLACE_EXISTING: 如果目标文件存在则替换
        // StandardCopyOption.COPY_ATTRIBUTES: 复制文件属性
        Files.copy(
            sourceFile.toPath(),
            targetFile.toPath(),
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
        )

        println("✓ 成功复制文件(带选项): ${sourceFile.name} -> ${targetFile.name}")
        println("  目标文件大小: ${targetFile.length()} 字节")

    } catch (e: Exception) {
        println("✗ 文件复制失败: ${e.message}")
    }

    println()
}

/**
 * 目录复制 - 递归复制整个目录结构
 * 演示如何复制目录及其所有内容
 */
fun directoryCopy() {
    println("=== 目录复制 ===")

    try {
        val sourceDir = File("source_dir")
        val targetDir = File("copied_dir")

        // 使用 Kotlin 的 copyRecursively 方法递归复制目录
        sourceDir.copyRecursively(
            target = targetDir,
            overwrite = true  // 覆盖已存在的文件
        ) { file, exception ->
            // 处理复制过程中的异常
            println("复制文件 ${file.name} 时出错: ${exception.message}")
            OnErrorAction.SKIP  // 跳过出错的文件继续复制
        }

        println("✓ 成功复制目录: ${sourceDir.name} -> ${targetDir.name}")
        println("  目标目录内容数: ${targetDir.listFiles()?.size ?: 0}")

    } catch (e: Exception) {
        println("✗ 目录复制失败: ${e.message}")
    }

    println()
}

/**
 * 5. 清理演示文件
 * 删除演示过程中创建的临时文件和目录
 */
fun cleanupFiles() {
    println("=== 清理文件 ===")

    val filesToDelete = listOf(
        "source.txt",
        "basic_copy.txt",
        "advanced_copy.txt",
        "source_dir",
        "copied_dir"
    )

    filesToDelete.forEach { fileName ->
        val file = File(fileName)
        if (file.exists()) {
            if (file.isFile) {
                if (file.delete()) {
                    println("✓ 已删除文件: $fileName")
                } else {
                    println("✗ 删除文件失败: $fileName")
                }
            } else {
                // 对于目录使用 deleteRecursively
                if (file.deleteRecursively()) {
                    println("✓ 已删除目录: $fileName")
                } else {
                    println("✗ 删除目录失败: $fileName")
                }
            }
        } else {
            println("⚠ 文件/目录不存在: $fileName")
        }
    }

    println()
}
