fun main() {
    // 声明一个数组，并赋值给 items
    val items = kotlin.collections.listOf("A", "B", "C")
    // 声明数组的索引，也叫做下标
    // 只能用 Int 当下标
    val index: Int = 1
    // 输出索引处的元素
    // 输出 B
    kotlin.io.println(items[index])

    // 千位分隔符，仍是 Int
    val million = 1_000_000
    // 输出 2000000
    kotlin.io.println(million * 2)
}