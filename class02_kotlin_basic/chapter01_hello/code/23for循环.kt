fun main() {
    // 1. 区间
    for (i in 1..5) print(i)          // 12345
    // 2. 倒序+步长
    for (i in 5 downTo 1 step 2) print(i) // 531
    // 3. 集合
    val list = listOf("A", "B", "C")
    for (item in list) print(item)    // ABC
    // 4. 索引+元素
    for ((idx, v) in list.withIndex()) println("$idx:$v")
}