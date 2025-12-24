/**
 * Kotlin 数组构造函数详细演示
 *
 * 本文件专门演示Kotlin中各种原生数组的构造函数用法
 * 包括：
 * 1. 基础构造函数（指定大小）
 * 2. 带初始化块的构造函数（lambda表达式）
 * 3. 不同数据类型的构造函数
 * 4. 构造函数的实际应用场景
 *
 * 每个示例都是独立的方法，结构清晰，适合零基础学习者
 */

fun main() {
    println("========== Kotlin 数组构造函数完整演示 ==========\n")

    // 调用各个演示方法
    demonstrateBasicIntArrayConstructor()
    demonstrateIntArrayWithInitializer()
    demonstrateIntArrayWithLambda()
    demonstrateDoubleArrayConstructor()
    demonstrateBooleanArrayConstructor()
    demonstrateCharArrayConstructor()
    demonstrateByteArrayConstructor()
    demonstrateShortArrayConstructor()
    demonstrateLongArrayConstructor()
    demonstrateFloatArrayConstructor()
    demonstrateConstructorWithComplexLogic()
    demonstrateConstructorForRealWorldScenario()

    println("\n========== 演示结束 ==========")
}

/**
 * 演示1: IntArray 基础构造函数
 *
 * 最简单的构造函数用法：只指定数组大小
 * 数组会自动用默认值（0）填充所有元素
 *
 * 语法: IntArray(size)
 */
fun demonstrateBasicIntArrayConstructor() {
    println("【演示1】IntArray 基础构造函数 - 只指定大小")
    println("-".repeat(60))

    // 创建一个大小为5的整数数组
    // 所有元素默认初始化为 0
    val numbers = IntArray(5)

    println("创建代码: val numbers = IntArray(5)")
    println("数组大小: ${numbers.size}")
    println("数组内容: ${numbers.contentToString()}")
    println("说明: 所有元素都自动初始化为 0（整数的默认值）")
    println()
}

/**
 * 演示2: IntArray 构造函数 - 指定初始值
 *
 * 使用构造函数并提供初始化块
 * 所有元素都会被设置为同一个值
 *
 * 语法: IntArray(size) { initialValue }
 */
fun demonstrateIntArrayWithInitializer() {
    println("【演示2】IntArray 构造函数 - 指定初始值")
    println("-".repeat(60))

    // 创建一个大小为5的整数数组，所有元素都初始化为 100
    val scores = IntArray(5) { 100 }

    println("创建代码: val scores = IntArray(5) { 100 }")
    println("数组大小: ${scores.size}")
    println("数组内容: ${scores.contentToString()}")
    println("说明: 所有元素都被设置为同一个值 100")
    println()
}

/**
 * 演示3: IntArray 构造函数 - 使用 Lambda 表达式动态生成元素
 *
 * 最强大的构造函数用法：使用 lambda 表达式
 * lambda 中的 it 代表当前元素的索引（从0开始）
 * 可以根据索引动态计算每个元素的值
 *
 * 语法: IntArray(size) { index -> expression }
 */
fun demonstrateIntArrayWithLambda() {
    println("【演示3】IntArray 构造函数 - 使用 Lambda 表达式")
    println("-".repeat(60))

    // 示例1: 根据索引生成数值
    // it 是索引，从0开始
    val sequence1 = IntArray(5) { it }
    println("示例1 - 生成索引序列:")
    println("  创建代码: val sequence1 = IntArray(5) { it }")
    println("  数组内容: ${sequence1.contentToString()}")
    println("  说明: it 代表索引，所以结果是 [0, 1, 2, 3, 4]")
    println()

    // 示例2: 根据索引生成倍数
    val multiples = IntArray(5) { it * 10 }
    println("示例2 - 生成倍数序列:")
    println("  创建代码: val multiples = IntArray(5) { it * 10 }")
    println("  数组内容: ${multiples.contentToString()}")
    println("  说明: 每个索引乘以10，所以结果是 [0, 10, 20, 30, 40]")
    println()

    // 示例3: 生成平方数
    val squares = IntArray(5) { (it + 1) * (it + 1) }
    println("示例3 - 生成平方数:")
    println("  创建代码: val squares = IntArray(5) { (it + 1) * (it + 1) }")
    println("  数组内容: ${squares.contentToString()}")
    println("  说明: 计算 (索引+1) 的平方，所以结果是 [1, 4, 9, 16, 25]")
    println()
}

/**
 * 演示4: DoubleArray 构造函数
 *
 * DoubleArray 用于存储浮点数
 * 默认初始值为 0.0
 *
 * 语法: DoubleArray(size) { lambda }
 */
fun demonstrateDoubleArrayConstructor() {
    println("【演示4】DoubleArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val temps1 = DoubleArray(3)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val temps1 = DoubleArray(3)")
    println("  数组内容: ${temps1.contentToString()}")
    println("  说明: 默认初始值为 0.0")
    println()

    // 示例2: 使用 lambda 生成浮点数
    val temps2 = DoubleArray(4) { (it + 1) * 36.5 }
    println("示例2 - 使用 lambda 生成温度数据:")
    println("  创建代码: val temps2 = DoubleArray(4) { (it + 1) * 36.5 }")
    println("  数组内容: ${temps2.contentToString()}")
    println("  说明: 生成温度数据，每个值都是 (索引+1) * 36.5")
    println()
}

/**
 * 演示5: BooleanArray 构造函数
 *
 * BooleanArray 用于存储布尔值（true 或 false）
 * 默认初始值为 false
 *
 * 语法: BooleanArray(size) { lambda }
 */
fun demonstrateBooleanArrayConstructor() {
    println("【演示5】BooleanArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val flags1 = BooleanArray(5)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val flags1 = BooleanArray(5)")
    println("  数组内容: ${flags1.contentToString()}")
    println("  说明: 默认初始值为 false")
    println()

    // 示例2: 使用 lambda 生成布尔值
    // 偶数索引为 true，奇数索引为 false
    val flags2 = BooleanArray(6) { it % 2 == 0 }
    println("示例2 - 偶数位置为 true:")
    println("  创建代码: val flags2 = BooleanArray(6) { it % 2 == 0 }")
    println("  数组内容: ${flags2.contentToString()}")
    println("  说明: 索引为偶数时为 true，奇数时为 false")
    println()
}

/**
 * 演示6: CharArray 构造函数
 *
 * CharArray 用于存储单个字符
 * 默认初始值为 '\u0000'（空字符）
 *
 * 语法: CharArray(size) { lambda }
 */
fun demonstrateCharArrayConstructor() {
    println("【演示6】CharArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val chars1 = CharArray(3)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val chars1 = CharArray(3)")
    println("  数组内容: ${chars1.contentToString()}")
    println("  说明: 默认初始值为空字符 '\\u0000'")
    println()

    // 示例2: 生成字母序列
    val letters = CharArray(5) { ('A' + it).toChar() }
    println("示例2 - 生成字母序列:")
    println("  创建代码: val letters = CharArray(5) { ('A' + it).toChar() }")
    println("  数组内容: ${letters.contentToString()}")
    println("  转换为字符串: ${letters.joinToString("")}")
    println("  说明: 从 'A' 开始，每次加1生成下一个字母")
    println()

    // 示例3: 生成数字字符
    val digits = CharArray(10) { ('0' + it).toChar() }
    println("示例3 - 生成数字字符:")
    println("  创建代码: val digits = CharArray(10) { ('0' + it).toChar() }")
    println("  数组内容: ${digits.contentToString()}")
    println("  转换为字符串: ${digits.joinToString("")}")
    println("  说明: 生成 0-9 的数字字符")
    println()
}

/**
 * 演示7: ByteArray 构造函数
 *
 * ByteArray 用于存储字节值（-128 到 127）
 * 常用于处理二进制数据
 * 默认初始值为 0
 *
 * 语法: ByteArray(size) { lambda }
 */
fun demonstrateByteArrayConstructor() {
    println("【演示7】ByteArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val bytes1 = ByteArray(4)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val bytes1 = ByteArray(4)")
    println("  数组内容: ${bytes1.contentToString()}")
    println("  说明: 默认初始值为 0")
    println()

    // 示例2: 使用 lambda 生成字节数据
    val bytes2 = ByteArray(5) { (it * 50).toByte() }
    println("示例2 - 生成字节数据:")
    println("  创建代码: val bytes2 = ByteArray(5) { (it * 50).toByte() }")
    println("  数组内容: ${bytes2.contentToString()}")
    println("  说明: 每个索引乘以50，然后转换为字节类型")
    println()
}

/**
 * 演示8: ShortArray 构造函数
 *
 * ShortArray 用于存储短整数值（-32768 到 32767）
 * 占用内存比 IntArray 少
 * 默认初始值为 0
 *
 * 语法: ShortArray(size) { lambda }
 */
fun demonstrateShortArrayConstructor() {
    println("【演示8】ShortArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val shorts1 = ShortArray(3)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val shorts1 = ShortArray(3)")
    println("  数组内容: ${shorts1.contentToString()}")
    println("  说明: 默认初始值为 0")
    println()

    // 示例2: 使用 lambda 生成短整数
    val shorts2 = ShortArray(4) { (it * 1000).toShort() }
    println("示例2 - 生成短整数数据:")
    println("  创建代码: val shorts2 = ShortArray(4) { (it * 1000).toShort() }")
    println("  数组内容: ${shorts2.contentToString()}")
    println("  说明: 每个索引乘以1000，然后转换为短整数类型")
    println()
}

/**
 * 演示9: LongArray 构造函数
 *
 * LongArray 用于存储长整数值（64位）
 * 当整数超过 Int 范围时使用
 * 默认初始值为 0L
 *
 * 语法: LongArray(size) { lambda }
 */
fun demonstrateLongArrayConstructor() {
    println("【演示9】LongArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val longs1 = LongArray(3)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val longs1 = LongArray(3)")
    println("  数组内容: ${longs1.contentToString()}")
    println("  说明: 默认初始值为 0L")
    println()

    // 示例2: 使用 lambda 生成大数值
    val longs2 = LongArray(4) { (it + 1) * 1000000000L }
    println("示例2 - 生成大数值:")
    println("  创建代码: val longs2 = LongArray(4) { (it + 1) * 1000000000L }")
    println("  数组内容: ${longs2.contentToString()}")
    println("  说明: 生成十亿级别的数值")
    println()
}

/**
 * 演示10: FloatArray 构造函数
 *
 * FloatArray 用于存储单精度浮点数
 * 精度较低但占用内存少
 * 默认初始值为 0.0f
 *
 * 语法: FloatArray(size) { lambda }
 */
fun demonstrateFloatArrayConstructor() {
    println("【演示10】FloatArray 构造函数")
    println("-".repeat(60))

    // 示例1: 基础构造函数
    val floats1 = FloatArray(3)
    println("示例1 - 基础构造函数:")
    println("  创建代码: val floats1 = FloatArray(3)")
    println("  数组内容: ${floats1.contentToString()}")
    println("  说明: 默认初始值为 0.0f")
    println()

    // 示例2: 使用 lambda 生成浮点数
    val floats2 = FloatArray(5) { (it + 1) * 1.5f }
    println("示例2 - 生成浮点数:")
    println("  创建代码: val floats2 = FloatArray(5) { (it + 1) * 1.5f }")
    println("  数组内容: ${floats2.contentToString()}")
    println("  说明: 生成 1.5, 3.0, 4.5, 6.0, 7.5")
    println()
}

/**
 * 演示11: 构造函数 - 复杂逻辑示例
 *
 * 演示在 lambda 中使用更复杂的逻辑
 * 可以包含条件判断、计算等
 */
fun demonstrateConstructorWithComplexLogic() {
    println("【演示11】构造函数 - 复杂逻辑示例")
    println("-".repeat(60))

    // 示例1: 生成斐波那契数列的前几项
    val fibonacci = IntArray(8) { index ->
        when {
            index == 0 -> 0
            index == 1 -> 1
            else -> {
                // 这里只能返回基于索引的值，不能访问前面的元素
                // 所以我们用公式计算
                val phi = (1 + Math.sqrt(5.0)) / 2
                val psi = (1 - Math.sqrt(5.0)) / 2
                val result = ((Math.pow(phi, (index + 1).toDouble()) -
                        Math.pow(psi, (index + 1).toDouble())) / Math.sqrt(5.0)).toInt()
                result
            }
        }
    }
    println("示例1 - 斐波那契数列:")
    println("  创建代码: IntArray(8) { index -> ... }")
    println("  数组内容: ${fibonacci.contentToString()}")
    println("  说明: 使用 when 表达式和复杂计算生成斐波那契数列")
    println()

    // 示例2: 生成条件判断的结果
    val evenOdd = IntArray(10) { index ->
        if (index % 2 == 0) index * 2 else index * 3
    }
    println("示例2 - 条件判断:")
    println("  创建代码: IntArray(10) { index -> if (index % 2 == 0) index * 2 else index * 3 }")
    println("  数组内容: ${evenOdd.contentToString()}")
    println("  说明: 偶数索引乘以2，奇数索引乘以3")
    println()
}

/**
 * 演示12: 构造函数 - 实际应用场景
 *
 * 演示在真实项目中如何使用数组构造函数
 */
fun demonstrateConstructorForRealWorldScenario() {
    println("【演示12】构造函数 - 实际应用场景")
    println("-".repeat(60))

    // 场景1: 生成学生成绩数组（模拟随机成绩）
    val studentScores = IntArray(5) { (Math.random() * 50 + 50).toInt() }
    println("场景1 - 生成学生成绩:")
    println("  创建代码: IntArray(5) { (Math.random() * 50 + 50).toInt() }")
    println("  数组内容: ${studentScores.contentToString()}")
    println("  说明: 生成5个学生的成绩，范围在50-100之间")
    println()

    // 场景2: 生成时间戳数组（模拟每小时的数据）
    val hourlyData = LongArray(24) { hour ->
        System.currentTimeMillis() + (hour * 3600000L)
    }
    println("场景2 - 生成24小时的时间戳:")
    println("  创建代码: LongArray(24) { hour -> System.currentTimeMillis() + (hour * 3600000L) }")
    println("  前3个时间戳: ${hourlyData.take(3)}")
    println("  说明: 生成24个时间戳，每个相隔1小时")
    println()

    // 场景3: 生成RGB颜色数组
    val colorValues = ByteArray(3) { ((Math.random() * 256).toInt() and 0xFF).toByte() }
    println("场景3 - 生成RGB颜色值:")
    println("  创建代码: ByteArray(3) { (Math.random() * 256).toByte() }")
    println("  数组内容: ${colorValues.contentToString()}")
    println("  说明: 生成RGB三个颜色分量，每个值在0-255之间")
    println()

    // 场景4: 生成棋盘坐标
    val boardPositions = IntArray(64) { position ->
        position // 0-63 代表棋盘的64个位置
    }
    println("场景4 - 生成棋盘位置:")
    println("  创建代码: IntArray(64) { position -> position }")
    println("  前8个位置: ${boardPositions.take(8)}")
    println("  说明: 生成64个棋盘位置（8x8棋盘）")
    println()
}
