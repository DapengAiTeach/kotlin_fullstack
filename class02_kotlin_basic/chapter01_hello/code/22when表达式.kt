fun main() {
    // 从控制台输入分数
    println("请输入分数：")
    val score = readln().toInt()

    // 根据分数推断等级
    val grade = when (score) {
        in 90..100 -> "A"
        in 80..89  -> "B"
        in 70..79  -> "C"
        in 60..69  -> "D"
        else       -> "F"
    }
    println("等级=$grade")
}