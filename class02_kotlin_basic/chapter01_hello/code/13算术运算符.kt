fun main() {
    val a = 7
    val b = 2

    // 除法运算
    kotlin.io.println(a + b)   // 9
    kotlin.io.println(a / b)   // 3   整除
    kotlin.io.println(a.toDouble() / b) // 3.5


    // 取余运算
    kotlin.io.println(a % b)   // 1

    // 自增运算
    var c = 5
    c++
    kotlin.io.println(c)       // 6
}