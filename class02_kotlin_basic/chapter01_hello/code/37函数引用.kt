import kotlin.collections.filter

/**
 * 判断一个整数是否为奇数的函数
 *
 * @param n 要判断的整数
 * @return 如果是奇数返回true，否则返回false
 *
 * 原理：使用取模运算符(%)计算n除以2的余数
 * 如果余数为1，则说明n是奇数；如果余数为0，则说明n是偶数
 */
fun isOdd(n: Int) = n % 2 == 1


fun main() {
    // 创建一个包含整数1, 2, 3的只读列表
    val nums = kotlin.collections.listOf(1, 2, 3)

    // 使用filter函数和函数引用来筛选出奇数
    // ::isOdd 是函数引用语法，它引用上面定义的isOdd函数
    // filter函数会对列表中的每个元素调用isOdd函数
    // 只有当isOdd返回true时，该元素才会被保留在结果列表中
    val oddNumbers = nums.filter(::isOdd)

    // 打印筛选后的结果
    kotlin.io.println(oddNumbers)// 结果是 [1, 3]
}