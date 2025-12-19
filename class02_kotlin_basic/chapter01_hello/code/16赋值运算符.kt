fun main() {
    var score = 100
    score -= 20          // 复合赋值
    score += 5
    kotlin.io.println(score)       // 85

    val (name, age) = kotlin.Pair("Lisa", 23) // 解构赋值
    kotlin.io.println("$name is $age")           // Lisa is 23
}