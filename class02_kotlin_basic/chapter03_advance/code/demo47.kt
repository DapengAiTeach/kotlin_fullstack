fun main() {
    // 准备一个list测试集合
    val numbers = listOf(10, 20, 30, 40, 50)

    // 通过索引访问元素
    println("第一个元素: ${numbers[0]}")
    println("最后一个元素: ${numbers.last()}")
    println("第一个元素（安全方式）: ${numbers.firstOrNull()}")

    // 获取List的大小
    println("List的大小: ${numbers.size}")

    // 检查元素是否存在
    println("是否包含30: ${numbers.contains(30)}")
    println("是否包含100: ${100 in numbers}")

    // 查找元素的索引
    println("30的索引位置: ${numbers.indexOf(30)}")
}