/**
 * Kotlin 数组的创建和操作示例
 * 演示各种数组创建方式和常用操作方法
 */

fun main() {
    println("========== Kotlin 数组演示 ==========\n")
    
    // ===== 1. 使用 intArrayOf() 创建整数数组 =====
    println("1. 使用 intArrayOf() 创建整数数组")
    val intArray = intArrayOf(10, 20, 30, 40, 50)
    println("整数数组: ${intArray.contentToString()}")
    println("数组长度: ${intArray.size}")
    println("第一个元素: ${intArray[0]}")
    println("最后一个元素: ${intArray[intArray.size - 1]}\n")
    
    // ===== 2. 使用 IntArray 构造函数创建数组 =====
    println("2. 使用 IntArray 构造函数创建数组")
    // 创建一个大小为5的整数数组，所有元素初始化为0
    val intArray2 = IntArray(5)
    println("初始化后的数组: ${intArray2.contentToString()}")
    
    // 创建一个大小为5的整数数组，所有元素初始化为100
    val intArray3 = IntArray(5) { 100 }
    println("初始化为100的数组: ${intArray3.contentToString()}\n")
    
    // ===== 3. 使用 lambda 表达式初始化数组 =====
    println("3. 使用 lambda 表达式初始化数组")
    // 创建一个包含 0 到 9 的数组
    val intArray4 = IntArray(10) { it }
    println("包含 0-9 的数组: ${intArray4.contentToString()}")
    
    // 创建一个包含 1 到 10 的数组
    val intArray5 = IntArray(10) { it + 1 }
    println("包含 1-10 的数组: ${intArray5.contentToString()}\n")
    
    // ===== 4. 创建字符串数组 =====
    println("4. 创建字符串数组")
    val stringArray = arrayOf("Kotlin", "Java", "Python", "Go", "Rust")
    println("字符串数组: ${stringArray.contentToString()}")
    println("数组长度: ${stringArray.size}")
    println("第二个元素: ${stringArray[1]}\n")
    
    // ===== 5. 创建泛型数组 =====
    println("5. 创建泛型数组")
    val genericArray: Array<Any> = arrayOf(1, "Hello", 3.14, true, 'A')
    println("泛型数组: ${genericArray.contentToString()}")
    println("第一个元素类型: ${genericArray[0]::class.simpleName}\n")
    
    // ===== 6. 创建浮点数数组 =====
    println("6. 创建浮点数数组")
    val doubleArray = doubleArrayOf(1.5, 2.5, 3.5, 4.5)
    println("浮点数数组: ${doubleArray.contentToString()}")
    println("数组长度: ${doubleArray.size}\n")
    
    // ===== 7. 创建布尔数组 =====
    println("7. 创建布尔数组")
    val boolArray = booleanArrayOf(true, false, true, true, false)
    println("布尔数组: ${boolArray.contentToString()}")
    println("数组长度: ${boolArray.size}\n")
    
    // ===== 8. 创建字符数组 =====
    println("8. 创建字符数组")
    val charArray = charArrayOf('A', 'B', 'C', 'D', 'E')
    println("字符数组: ${charArray.contentToString()}")
    println("转换为字符串: ${charArray.joinToString("")}\n")
    
    // ===== 9. 数组的修改操作 =====
    println("9. 数组的修改操作")
    val mutableArray = intArrayOf(1, 2, 3, 4, 5)
    println("原始数组: ${mutableArray.contentToString()}")
    
    // 修改数组元素
    mutableArray[0] = 100
    mutableArray[4] = 500
    println("修改后的数组: ${mutableArray.contentToString()}\n")
    
    // ===== 10. 数组的遍历 =====
    println("10. 数组的遍历")
    val traverseArray = intArrayOf(10, 20, 30, 40, 50)
    
    // 方式1: 使用 for 循环
    print("方式1 - for循环: ")
    for (element in traverseArray) {
        print("$element ")
    }
    println()
    
    // 方式2: 使用 forEach
    print("方式2 - forEach: ")
    traverseArray.forEach { print("$it ") }
    println()
    
    // 方式3: 使用 forEachIndexed
    print("方式3 - forEachIndexed: ")
    traverseArray.forEachIndexed { index, value -> print("[$index]=$value ") }
    println("\n")
    
    // ===== 11. 数组的常用操作 =====
    println("11. 数组的常用操作")
    val operationArray = intArrayOf(5, 2, 8, 1, 9, 3)
    
    // 求和
    println("数组: ${operationArray.contentToString()}")
    println("求和: ${operationArray.sum()}")
    
    // 求平均值
    println("平均值: ${operationArray.average()}")
    
    // 求最大值
    println("最大值: ${operationArray.maxOrNull()}")
    
    // 求最小值
    println("最小值: ${operationArray.minOrNull()}")
    
    // 排序
    println("排序后: ${operationArray.sorted()}")
    
    // 反向排序
    println("反向排序: ${operationArray.sortedDescending()}\n")
    
    // ===== 12. 数组的过滤和映射 =====
    println("12. 数组的过滤和映射")
    val filterArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // 过滤偶数
    val evenNumbers = filterArray.filter { it % 2 == 0 }
    println("原数组: ${filterArray.contentToString()}")
    println("偶数: $evenNumbers")
    
    // 映射 - 每个元素乘以2
    val doubled = filterArray.map { it * 2 }
    println("每个元素乘以2: $doubled\n")
    
    // ===== 13. 数组的查找 =====
    println("13. 数组的查找")
    val searchArray = intArrayOf(10, 20, 30, 40, 50)
    
    // 检查是否包含某个元素
    println("数组: ${searchArray.contentToString()}")
    println("是否包含30: ${30 in searchArray}")
    println("是否包含25: ${25 in searchArray}")
    
    // 查找第一个满足条件的元素
    val firstEven = searchArray.find { it % 2 == 0 }
    println("第一个偶数: $firstEven")
    
    // 查找所有满足条件的元素
    val allEven = searchArray.filter { it % 2 == 0 }
    println("所有偶数: $allEven\n")
    
    // ===== 14. 数组的复制 =====
    println("14. 数组的复制")
    val originalArray = intArrayOf(1, 2, 3, 4, 5)
    
    // 浅复制
    val copiedArray = originalArray.copyOf()
    println("原数组: ${originalArray.contentToString()}")
    println("复制数组: ${copiedArray.contentToString()}")
    
    // 修改复制后的数组，原数组不受影响
    copiedArray[0] = 100
    println("修改复制数组后:")
    println("原数组: ${originalArray.contentToString()}")
    println("复制数组: ${copiedArray.contentToString()}\n")
    
    // ===== 15. 数组的合并 =====
    println("15. 数组的合并")
    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(4, 5, 6)
    
    // 使用 plus 操作符合并
    val mergedArray = array1 + array2
    println("数组1: ${array1.contentToString()}")
    println("数组2: ${array2.contentToString()}")
    println("合并后: $mergedArray\n")
    
    // ===== 16. 二维数组 =====
    println("16. 二维数组")
    // 创建一个 3x3 的二维数组
    val matrix = Array(3) { IntArray(3) }
    
    // 初始化二维数组
    for (i in 0 until 3) {
        for (j in 0 until 3) {
            matrix[i][j] = (i + 1) * (j + 1)
        }
    }
    
    // 打印二维数组
    println("3x3 乘法表:")
    for (row in matrix) {
        println(row.contentToString())
    }
    println()
    
    // ===== 17. 数组的分割 =====
    println("17. 数组的分割")
    val splitArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // 取前3个元素
    val first3 = splitArray.take(3)
    println("原数组: ${splitArray.contentToString()}")
    println("前3个元素: $first3")
    
    // 取最后3个元素
    val last3 = splitArray.takeLast(3)
    println("最后3个元素: $last3")
    
    // 跳过前3个元素
    val skipFirst3 = splitArray.drop(3)
    println("跳过前3个元素: $skipFirst3\n")
    
    // ===== 18. 数组的分组 =====
    println("18. 数组的分组")
    val groupArray = intArrayOf(1, 2, 3, 4, 5, 6)
    
    // 按大小分组 - 使用 slice 和 indices 实现分组
    println("原数组: ${groupArray.contentToString()}")
    println("按2个元素分组:")
    for (i in groupArray.indices step 2) {
        val end = minOf(i + 2, groupArray.size)
        val group = groupArray.slice(i until end)
        println("  $group")
    }
    println()
    
    println("========== 演示结束 ==========")
}
