/**
 * 性能测量工具函数
 * 使用内联函数避免lambda对象创建开销，精确测量代码块执行时间
 *
 * @param block 要测量执行时间的代码块
 * @return 执行时间(ns)
 */
inline fun measure(block: () -> Unit): Long {
    // 记录开始时间(纳秒)，System.nanoTime()提供高精度时间戳
    val start = System.nanoTime()

    // 执行传入的代码块
    block()

    // 返回执行耗时(纳秒)
    // 通过内联，block代码会被直接嵌入到调用处，避免函数调用开销
    return System.nanoTime() - start
}

/**
 * 主函数：演示性能测量工具的使用
 */
fun main() {
    // 测量Thread.sleep(10)的执行时间
    // 由于measure函数被标记为inline，这里不会创建lambda对象
    // block参数会直接内联到measure函数体中，提高执行效率
    val ns = measure {
        // 暂停当前线程10毫秒(10,000,000纳秒)
        Thread.sleep(10)
    }

    // 将纳秒转换为毫秒并输出结果
    // 1毫秒 = 1,000,000纳秒
    println("耗时 ${ns / 1_000_000} ms")
}
