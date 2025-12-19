fun main() {
    // 准备列表
    val list = listOf(1, 2, 3)

    // map 接收一个列表，遍历列表中的元素
    // 对每个元素执行 lambda 表达式，并返回一个新列表
    val doubled = list.map { it * 2 }   // lambda 表达式

    // 输出
    println(doubled)                    // [2, 4, 6]
}