fun main() {
    // 方式1：使用listOf()函数创建不可变List
    val immutableList = listOf(1, 2, 3, 4, 5)
    println("不可变List: $immutableList")

    // 方式2：使用mutableListOf()创建可变List
    val mutableList = mutableListOf("Kotlin", "Java", "Python")
    println("可变List: $mutableList")

    // 方式3：使用List构造函数和lambda初始化
    val listWithInit = List(5) { index -> index * 2 }
    println("使用lambda初始化的List: $listWithInit")

    // 方式4：使用emptyList()创建空List
    val emptyList = emptyList<String>()
    println("空List: $emptyList")

    // 方式5：使用范围转换为List
    val rangeList = (1..3).toList()
    println("从范围转换的List: $rangeList")
}