/**
 * 一个用于测量代码块执行时间的高阶函数
 *
 * @param block 需要被测量执行时间的代码块，是一个无参且无返回值的函数类型参数
 * @return 返回代码块执行所消耗的时间（单位：纳秒）
 */
fun time(block: () -> Unit): Long {
    // 记录开始执行前的时间戳（单位：纳秒）
    val start = System.nanoTime()

    // 执行传入的代码块
    block()

    // 记录执行结束后的时间戳，并计算差值得到执行时间
    return System.nanoTime() - start
}

fun main() {
    // 使用 time 函数测量一段代码的执行时间
    val cost = time {
        Thread.sleep(10) // 模拟耗时操作：休眠 10 毫秒
    }

    // 输出执行时间，转换为毫秒并打印
    println("耗时 ${cost / 1_000_000} ms")
}