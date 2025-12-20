import java.io.File

/**
 * Kotlin 文件删除示例程序
 * 演示多种文件删除方式和安全检查
 */
fun main() {
    // 1. 创建测试文件用于删除演示
    prepareTestFiles()

    // 2. 演示安全删除文件
    safeDeleteFile()

    // 3. 演示强制删除文件
    forceDeleteFile()

    // 4. 演示删除目录
    deleteDirectory()
}

/**
 * 准备测试文件和目录
 */
fun prepareTestFiles() {
    println("=== 准备测试文件 ===")

    // 创建单个文件
    File("test_file.txt").writeText("这是一个测试文件")
    println("创建文件: test_file.txt")

    // 创建另一个文件
    File("temp_file.txt").writeText("这是临时文件")
    println("创建文件: temp_file.txt")

    // 创建目录和其中的文件
    val dir = File("test_directory")
    dir.mkdirs()
    File(dir, "inner_file.txt").writeText("目录内的文件")
    println("创建目录: test_directory")
    println("创建文件: test_directory/inner_file.txt")

    println()
}

/**
 * 安全删除文件 - 先检查文件是否存在
 * 适用于不确定文件是否存在的场景
 */
fun safeDeleteFile() {
    println("=== 安全删除文件 ===")

    val fileToDelete = File("test_file.txt")

    // 检查文件是否存在
    if (fileToDelete.exists()) {
        // 检查是否为文件（而不是目录）
        if (fileToDelete.isFile) {
            // 执行删除操作
            val success = fileToDelete.delete()
            if (success) {
                println("✓ 成功删除文件: ${fileToDelete.name}")
            } else {
                println("✗ 删除失败: ${fileToDelete.name}")
            }
        } else {
            println("✗ 不是文件: ${fileToDelete.name}")
        }
    } else {
        println("⚠ 文件不存在: ${fileToDelete.name}")
    }

    println()
}

/**
 * 强制删除文件 - 直接尝试删除
 * 适用于确定文件存在且需要快速删除的场景
 */
fun forceDeleteFile() {
    println("=== 强制删除文件 ===")

    try {
        // 直接删除文件，不进行存在性检查
        val success = File("temp_file.txt").delete()
        if (success) {
            println("✓ 成功删除文件: temp_file.txt")
        } else {
            println("✗ 删除失败: temp_file.txt")
        }
    } catch (e: SecurityException) {
        println("✗ 权限不足，无法删除文件: ${e.message}")
    } catch (e: Exception) {
        println("✗ 删除过程中发生错误: ${e.message}")
    }

    println()
}
/**
 * 删除目录 - 使用 Kotlin 内置方法
 * 演示递归删除目录的方法
 */
fun deleteDirectory() {
    println("=== 删除目录 ===")

    val directory = File("test_directory")

    // 检查目录是否存在
    if (directory.exists()) {
        // 使用 Kotlin 内置的 deleteRecursively 方法
        val success = directory.deleteRecursively()
        if (success) {
            println("✓ 成功删除目录及其所有内容: ${directory.name}")
        } else {
            println("✗ 删除目录失败: ${directory.name}")
        }
    } else {
        println("⚠ 目录不存在: ${directory.name}")
    }

    println()
}