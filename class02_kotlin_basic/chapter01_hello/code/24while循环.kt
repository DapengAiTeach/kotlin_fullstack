fun main() {
    // 先判断
    var i = 0
    while (i < 3) {
        print(i++)
    } // 输出 012
    println()

    // 先执行一次
    var j = 0
    do {
        print(j++)
    } while (j < 3) // 输出 012（至少一次）
}