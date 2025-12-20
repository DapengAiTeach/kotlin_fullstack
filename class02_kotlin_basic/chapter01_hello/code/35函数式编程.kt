import kotlin.collections.filter
import kotlin.collections.map
import kotlin.collections.reduce

fun main() {
    // 准备列表
    val result = kotlin.collections.listOf(1, 2, 3)
        .map { it * 2 }   // 变换 [2, 4, 6]
        .filter { it > 2 }   // 筛选 [4, 6]
        .reduce { a, b -> a + b } // 聚合 0+4+6=10

    // 输出
    kotlin.io.println(result)
}