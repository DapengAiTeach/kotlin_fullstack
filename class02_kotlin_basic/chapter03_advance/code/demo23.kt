/**
 * Kotlin 原生数组使用示例
 * 
 * 本文件演示Kotlin中各种原生数组的创建、初始化和基本操作
 * 每个示例都是一个独立的方法，结构清晰，适合零基础学习者
 * 
 * 原生数组类型：
 * - IntArray: 整数数组
 * - LongArray: 长整数数组
 * - DoubleArray: 双精度浮点数数组
 * - FloatArray: 单精度浮点数数组
 * - BooleanArray: 布尔值数组
 * - CharArray: 字符数组
 * - ByteArray: 字节数组
 * - ShortArray: 短整数数组
 */

fun main() {
    println("========== Kotlin 原生数组完整演示 ==========\n")
    
    // 调用各个演示方法
    demonstrateIntArray()
    demonstrateLongArray()
    demonstrateDoubleArray()
    demonstrateFloatArray()
    demonstrateBooleanArray()
    demonstrateCharArray()
    demonstrateByteArray()
    demonstrateShortArray()
    demonstrateArrayAccess()
    demonstrateArrayModification()
    demonstrateArrayIteration()
    demonstrateArraySize()
    demonstrateArrayComparison()
    demonstrateArrayCopy()
    demonstrateArrayConversion()
    
    println("\n========== 演示结束 ==========")
}

/**
 * 演示1: IntArray（整数数组）的使用
 * 
 * IntArray 用于存储整数值，是最常用的原生数组类型
 * 默认初始值为 0
 */
fun demonstrateIntArray() {
    println("【演示1】IntArray（整数数组）")
    println("-".repeat(50))
    
    // 方式1: 使用 intArrayOf() 直接创建并初始化
    val scores = intArrayOf(85, 90, 78, 92, 88)
    println("方式1 - 直接初始化: $scores")
    println("  内容: ${scores.contentToString()}")
    
    // 方式2: 使用 IntArray 构造函数指定大小
    val emptyScores = IntArray(5)
    println("方式2 - 指定大小（默认值为0）: ${emptyScores.contentToString()}")
    
    // 方式3: 使用 IntArray 构造函数并指定初始值
    val defaultScores = IntArray(5) { 100 }
    println("方式3 - 指定大小和初始值: ${defaultScores.contentToString()}")
    
    // 方式4: 使用 lambda 表达式动态生成元素
    val sequenceArray = IntArray(5) { it * 10 }
    println("方式4 - 使用lambda生成（0*10, 1*10, 2*10...）: ${sequenceArray.contentToString()}")
    
    println()
}

/**
 * 演示2: LongArray（长整数数组）的使用
 * 
 * LongArray 用于存储较大的整数值（64位）
 * 当整数超过 Int 范围时使用
 */
fun demonstrateLongArray() {
    println("【演示2】LongArray（长整数数组）")
    println("-".repeat(50))
    
    // 创建长整数数组
    val largeNumbers = longArrayOf(1000000000L, 2000000000L, 3000000000L)
    println("长整数数组: ${largeNumbers.contentToString()}")
    
    // 使用构造函数创建
    val longArray = LongArray(3) { (it + 1) * 1000000000L }
    println("使用lambda创建: ${longArray.contentToString()}")
    
    println()
}

/**
 * 演示3: DoubleArray（双精度浮点数数组）的使用
 * 
 * DoubleArray 用于存储浮点数，精度较高
 * 默认初始值为 0.0
 */
fun demonstrateDoubleArray() {
    println("【演示3】DoubleArray（双精度浮点数数组）")
    println("-".repeat(50))
    
    // 创建浮点数数组
    val temperatures = doubleArrayOf(36.5, 37.2, 36.8, 38.1, 37.0)
    println("温度数据: ${temperatures.contentToString()}")
    
    // 计算平均温度
    val average = temperatures.sum() / temperatures.size
    println("平均温度: $average")
    
    // 使用构造函数创建
    val prices = DoubleArray(4) { (it + 1) * 9.99 }
    println("价格数据: ${prices.contentToString()}")
    
    println()
}

/**
 * 演示4: FloatArray（单精度浮点数数组）的使用
 * 
 * FloatArray 用于存储浮点数，精度较低但占用内存少
 * 默认初始值为 0.0f
 */
fun demonstrateFloatArray() {
    println("【演示4】FloatArray（单精度浮点数数组）")
    println("-".repeat(50))
    
    // 创建单精度浮点数数组
    val weights = floatArrayOf(65.5f, 72.3f, 58.9f, 81.2f)
    println("体重数据: ${weights.contentToString()}")
    
    // 使用构造函数创建
    val ratings = FloatArray(5) { (it + 1) * 1.5f }
    println("评分数据: ${ratings.contentToString()}")
    
    println()
}

/**
 * 演示5: BooleanArray（布尔值数组）的使用
 * 
 * BooleanArray 用于存储 true 或 false 值
 * 默认初始值为 false
 */
fun demonstrateBooleanArray() {
    println("【演示5】BooleanArray（布尔值数组）")
    println("-".repeat(50))
    
    // 创建布尔值数组
    val isAvailable = booleanArrayOf(true, false, true, true, false)
    println("可用状态: ${isAvailable.contentToString()}")
    
    // 使用构造函数创建
    val flags = BooleanArray(5) { it % 2 == 0 }
    println("标志位（偶数位置为true）: ${flags.contentToString()}")
    
    // 统计 true 的个数
    val trueCount = isAvailable.count { it }
    println("可用项数: $trueCount")
    
    println()
}

/**
 * 演示6: CharArray（字符数组）的使用
 * 
 * CharArray 用于存储单个字符
 * 默认初始值为 '\u0000'（空字符）
 */
fun demonstrateCharArray() {
    println("【演示6】CharArray（字符数组）")
    println("-".repeat(50))
    
    // 创建字符数组
    val letters = charArrayOf('A', 'B', 'C', 'D', 'E')
    println("字母数组: ${letters.contentToString()}")
    println("转换为字符串: ${letters.joinToString("")}")
    
    // 使用构造函数创建
    val digits = CharArray(5) { ('0' + it).toChar() }
    println("数字字符: ${digits.contentToString()}")
    println("转换为字符串: ${digits.joinToString("")}")
    
    println()
}

/**
 * 演示7: ByteArray（字节数组）的使用
 * 
 * ByteArray 用于存储字节值（-128 到 127）
 * 常用于处理二进制数据
 */
fun demonstrateByteArray() {
    println("【演示7】ByteArray（字节数组）")
    println("-".repeat(50))
    
    // 创建字节数组
    val bytes = byteArrayOf(10, 20, 30, 40, 50)
    println("字节数组: ${bytes.contentToString()}")
    
    // 使用构造函数创建
    val byteData = ByteArray(5) { (it * 25).toByte() }
    println("字节数据: ${byteData.contentToString()}")
    
    println()
}

/**
 * 演示8: ShortArray（短整数数组）的使用
 * 
 * ShortArray 用于存储短整数值（-32768 到 32767）
 * 占用内存比 IntArray 少
 */
fun demonstrateShortArray() {
    println("【演示8】ShortArray（短整数数组）")
    println("-".repeat(50))
    
    // 创建短整数数组
    val shortNumbers = shortArrayOf(100, 200, 300, 400, 500)
    println("短整数数组: ${shortNumbers.contentToString()}")
    
    // 使用构造函数创建
    val shortData = ShortArray(5) { (it * 1000).toShort() }
    println("短整数数据: ${shortData.contentToString()}")
    
    println()
}

/**
 * 演示9: 数组元素访问
 * 
 * 演示如何访问数组中的元素
 * 数组索引从 0 开始
 */
fun demonstrateArrayAccess() {
    println("【演示9】数组元素访问")
    println("-".repeat(50))
    
    val numbers = intArrayOf(10, 20, 30, 40, 50)
    println("数组: ${numbers.contentToString()}")
    
    // 访问第一个元素（索引为0）
    println("第一个元素（索引0）: ${numbers[0]}")
    
    // 访问最后一个元素
    println("最后一个元素（索引${numbers.size - 1}）: ${numbers[numbers.size - 1]}")
    
    // 访问中间元素
    println("中间元素（索引2）: ${numbers[2]}")
    
    // 使用 first() 和 last() 方法
    println("使用 first() 方法: ${numbers.first()}")
    println("使用 last() 方法: ${numbers.last()}")
    
    println()
}

/**
 * 演示10: 数组元素修改
 * 
 * 演示如何修改数组中的元素
 * 原生数组是可变的
 */
fun demonstrateArrayModification() {
    println("【演示10】数组元素修改")
    println("-".repeat(50))
    
    val scores = intArrayOf(85, 90, 78, 92, 88)
    println("原始数组: ${scores.contentToString()}")
    
    // 修改单个元素
    scores[0] = 95
    println("修改第一个元素为95: ${scores.contentToString()}")
    
    // 修改多个元素
    scores[2] = 88
    scores[4] = 100
    println("修改第三和第五个元素: ${scores.contentToString()}")
    
    // 使用 set() 方法修改
    scores.set(1, 87)
    println("使用 set() 方法修改第二个元素: ${scores.contentToString()}")
    
    println()
}

/**
 * 演示11: 数组遍历
 * 
 * 演示多种遍历数组的方式
 */
fun demonstrateArrayIteration() {
    println("【演示11】数组遍历")
    println("-".repeat(50))
    
    val numbers = intArrayOf(10, 20, 30, 40, 50)
    
    // 方式1: for-in 循环
    print("方式1 - for-in循环: ")
    for (num in numbers) {
        print("$num ")
    }
    println()
    
    // 方式2: 传统 for 循环（使用索引）
    print("方式2 - 传统for循环: ")
    for (i in numbers.indices) {
        print("${numbers[i]} ")
    }
    println()
    
    // 方式3: forEach 方法
    print("方式3 - forEach方法: ")
    numbers.forEach { print("$it ") }
    println()
    
    // 方式4: forEachIndexed 方法（带索引）
    print("方式4 - forEachIndexed方法: ")
    numbers.forEachIndexed { index, value -> print("[$index]=$value ") }
    println()
    
    println()
}

/**
 * 演示12: 数组大小和长度
 * 
 * 演示如何获取数组的大小信息
 */
fun demonstrateArraySize() {
    println("【演示12】数组大小和长度")
    println("-".repeat(50))
    
    val numbers = intArrayOf(10, 20, 30, 40, 50)
    
    // 获取数组大小
    println("数组: ${numbers.contentToString()}")
    println("数组大小（size）: ${numbers.size}")
    println("数组长度（length）: ${numbers.size}")
    
    // 检查数组是否为空
    println("数组是否为空: ${numbers.isEmpty()}")
    println("数组是否非空: ${numbers.isNotEmpty()}")
    
    // 获取有效索引范围
    println("有效索引范围: ${numbers.indices}")
    println("最后一个有效索引: ${numbers.lastIndex}")
    
    println()
}

/**
 * 演示13: 数组比较
 * 
 * 演示如何比较两个数组
 */
fun demonstrateArrayComparison() {
    println("【演示13】数组比较")
    println("-".repeat(50))
    
    val array1 = intArrayOf(1, 2, 3, 4, 5)
    val array2 = intArrayOf(1, 2, 3, 4, 5)
    val array3 = intArrayOf(1, 2, 3, 4, 6)
    
    println("数组1: ${array1.contentToString()}")
    println("数组2: ${array2.contentToString()}")
    println("数组3: ${array3.contentToString()}")
    
    // 使用 contentEquals() 比较内容
    println("数组1和数组2内容相等: ${array1.contentEquals(array2)}")
    println("数组1和数组3内容相等: ${array1.contentEquals(array3)}")
    
    // 检查是否包含某个元素
    println("数组1是否包含3: ${3 in array1}")
    println("数组1是否包含10: ${10 in array1}")
    
    println()
}

/**
 * 演示14: 数组复制
 * 
 * 演示如何复制数组
 */
fun demonstrateArrayCopy() {
    println("【演示14】数组复制")
    println("-".repeat(50))
    
    val original = intArrayOf(1, 2, 3, 4, 5)
    println("原始数组: ${original.contentToString()}")
    
    // 方式1: 使用 copyOf() 复制整个数组
    val copy1 = original.copyOf()
    println("使用 copyOf() 复制: ${copy1.contentToString()}")
    
    // 修改复制后的数组，原数组不受影响
    copy1[0] = 100
    println("修改复制数组后:")
    println("  原始数组: ${original.contentToString()}")
    println("  复制数组: ${copy1.contentToString()}")
    
    // 方式2: 使用 copyOfRange() 复制部分数组
    val copy2 = original.copyOfRange(1, 4)
    println("使用 copyOfRange(1, 4) 复制: ${copy2.contentToString()}")
    
    println()
}

/**
 * 演示15: 数组类型转换
 * 
 * 演示如何在不同类型的数组之间转换
 */
fun demonstrateArrayConversion() {
    println("【演示15】数组类型转换")
    println("-".repeat(50))
    
    // IntArray 转换为 List
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val intList = intArray.toList()
    println("IntArray 转 List: $intList")
    
    // IntArray 转换为 Set
    val intSet = intArray.toSet()
    println("IntArray 转 Set: $intSet")
    
    // List 转换为 IntArray
    val list = listOf(10, 20, 30, 40, 50)
    val arrayFromList = list.toIntArray()
    println("List 转 IntArray: ${arrayFromList.contentToString()}")
    
    // CharArray 转换为 String
    val charArray = charArrayOf('H', 'e', 'l', 'l', 'o')
    val string = charArray.joinToString("")
    println("CharArray 转 String: $string")
    
    // String 转换为 CharArray
    val stringToCharArray = "Kotlin".toCharArray()
    println("String 转 CharArray: ${stringToCharArray.contentToString()}")
    
    println()
}
