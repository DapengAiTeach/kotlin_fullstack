fun main() {
    // 从控制台输入两个数字
    println("请输入数字1：")
    val a = readln().toInt()
    println("请输入数字2：")
    val b = readln().toInt()

    // 求最大值
    val max = if (a > b) a else b      // 表达式返回值
    println("较大值=$max")
}