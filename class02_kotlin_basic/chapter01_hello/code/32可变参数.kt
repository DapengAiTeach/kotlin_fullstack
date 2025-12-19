fun sum(vararg nums: Int) = nums.sum()

fun main() {
    // 传3个数
    println(sum(1, 2, 3))        // 6

    // 传数组
    val a = intArrayOf(4, 5, 6)
    println(sum(*a))             // 展开运算符 *，输出 15
}