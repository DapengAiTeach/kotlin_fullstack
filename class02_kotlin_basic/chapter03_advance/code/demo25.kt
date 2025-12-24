/**
 * Kotlin 多维数组详细演示
 *
 * 本文件专门演示Kotlin中多维数组的使用方法
 * 包括：
 * 1. 二维数组的创建和访问
 * 2. 三维数组的创建和访问
 * 3. 多维数组的遍历方法
 * 4. 多维数组的实际应用场景
 * 5. 多维数组的常用操作
 *
 * 每个示例都是独立的方法，结构清晰，适合零基础学习者
 * 大白话说明：多维数组就是"数组的数组"
 * 比如：二维数组就是一个数组，里面的每个元素都是一个数组
 */

/**
 * 演示1: 二维数组基础概念
 *
 * 二维数组就像一个表格或矩阵
 * 有行和列，可以用 [行][列] 来访问元素
 *
 * 语法: Array<IntArray>(行数) { IntArray(列数) }
 */
fun demonstrate2DArrayBasic() {
    println("【演示1】二维数组基础概念 - 什么是二维数组")
    println("-".repeat(60))

    // 创建一个 3行4列 的二维数组
    // 外层数组有3个元素，每个元素都是一个包含4个整数的数组
    val matrix = Array(3) { IntArray(4) }

    println("创建代码: val matrix = Array(3) { IntArray(4) }")
    println("说明: 创建了一个3行4列的二维数组")
    println("  - 外层数组有3个元素（3行）")
    println("  - 每个元素都是一个包含4个整数的数组（4列）")
    println("  - 所有元素默认初始化为 0")
    println()

    // 打印数组结构
    println("数组结构:")
    for (i in matrix.indices) {
        println("  第${i}行: ${matrix[i].contentToString()}")
    }
    println()
}

/**
 * 演示2: 二维数组的多种创建方式
 *
 * 创建二维数组有很多种方法
 * 可以直接指定值，也可以用lambda动态生成
 */
fun demonstrate2DArrayCreation() {
    println("【演示2】二维数组的多种创建方式")
    println("-".repeat(60))

    // 方式1: 直接初始化（最直观）
    val array1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    println("方式1 - 直接初始化（最直观）:")
    println("  创建代码:")
    println("    val array1 = arrayOf(")
    println("        intArrayOf(1, 2, 3),")
    println("        intArrayOf(4, 5, 6),")
    println("        intArrayOf(7, 8, 9)")
    println("    )")
    println("  数组内容:")
    for (row in array1) {
        println("    ${row.contentToString()}")
    }
    println()

    // 方式2: 使用 Array 构造函数 + lambda
    val array2 = Array(3) { row ->
        IntArray(3) { col ->
            (row + 1) * 10 + (col + 1)
        }
    }
    println("方式2 - 使用 Array 构造函数 + lambda:")
    println("  创建代码: Array(3) { row -> IntArray(3) { col -> (row + 1) * 10 + (col + 1) } }")
    println("  说明: 根据行号和列号动态计算每个元素的值")
    println("  数组内容:")
    for (row in array2) {
        println("    ${row.contentToString()}")
    }
    println()

    // 方式3: 创建全1矩阵
    val array3 = Array(4) { IntArray(4) { 1 } }
    println("方式3 - 创建全1矩阵:")
    println("  创建代码: Array(4) { IntArray(4) { 1 } }")
    println("  说明: 所有元素都初始化为 1")
    println("  数组内容:")
    for (row in array3) {
        println("    ${row.contentToString()}")
    }
    println()

    // 方式4: 创建单位矩阵（对角线为1，其他为0）
    val array4 = Array(4) { row ->
        IntArray(4) { col ->
            if (row == col) 1 else 0
        }
    }
    println("方式4 - 创建单位矩阵（对角线为1）:")
    println("  创建代码: Array(4) { row -> IntArray(4) { col -> if (row == col) 1 else 0 } }")
    println("  数组内容:")
    for (row in array4) {
        println("    ${row.contentToString()}")
    }
    println()
}

/**
 * 演示3: 二维数组的访问和修改
 *
 * 访问二维数组的元素就像查表
 * 先找行，再找列，用 [行][列] 的方式
 */
fun demonstrate2DArrayAccess() {
    println("【演示3】二维数组的访问和修改")
    println("-".repeat(60))

    // 创建一个3x3的二维数组
    val grid = Array(3) { IntArray(3) }

    println("创建代码: val grid = Array(3) { IntArray(3) }")
    println("初始状态（全是0）:")
    for (row in grid) {
        println("  ${row.contentToString()}")
    }
    println()

    // 访问和修改元素
    println("访问和修改元素:")
    println("  grid[0][0] = 10  // 修改第0行第0列的元素")
    grid[0][0] = 10

    println("  grid[1][1] = 20  // 修改第1行第1列的元素")
    grid[1][1] = 20

    println("  grid[2][2] = 30  // 修改第2行第2列的元素")
    grid[2][2] = 30

    println("修改后的状态:")
    for (i in grid.indices) {
        println("  ${grid[i].contentToString()}")
    }
    println()

    // 读取元素
    println("读取元素:")
    println("  grid[0][0] = ${grid[0][0]}")
    println("  grid[1][1] = ${grid[1][1]}")
    println("  grid[2][2] = ${grid[2][2]}")
    println()

    // 获取数组的大小
    println("获取数组的大小:")
    println("  行数: ${grid.size}")
    println("  列数: ${grid[0].size}")
    println()
}

/**
 * 演示4: 二维数组的遍历方法
 *
 * 遍历二维数组就是逐个访问每个元素
 * 有多种方法可以做到，选择最方便的就行
 */
fun demonstrate2DArrayTraversal() {
    println("【演示4】二维数组的遍历方法")
    println("-".repeat(60))

    // 创建一个3x3的二维数组
    val matrix = Array(3) { row ->
        IntArray(3) { col ->
            (row + 1) * 10 + (col + 1)
        }
    }

    println("原始数组:")
    for (row in matrix) {
        println("  ${row.contentToString()}")
    }
    println()

    // 方法1: 使用 for 循环 + indices
    println("方法1 - 使用 for 循环 + indices（最常用）:")
    println("  代码: for (i in matrix.indices) { for (j in matrix[i].indices) { ... } }")
    println("  遍历结果:")
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("  matrix[$i][$j]=${matrix[i][j]}")
        }
        println()
    }
    println()

    // 方法2: 使用 for-in 循环
    println("方法2 - 使用 for-in 循环（最简洁）:")
    println("  代码: for (row in matrix) { for (value in row) { ... } }")
    println("  遍历结果:")
    for (row in matrix) {
        print("  ")
        for (value in row) {
            print("$value ")
        }
        println()
    }
    println()

    // 方法3: 使用 forEach
    println("方法3 - 使用 forEach（函数式风格）:")
    println("  代码: matrix.forEach { row -> row.forEach { value -> ... } }")
    println("  遍历结果:")
    matrix.forEach { row ->
        print("  ")
        row.forEach { value ->
            print("$value ")
        }
        println()
    }
    println()

    // 方法4: 使用 withIndex 获取索引
    println("方法4 - 使用 withIndex 获取索引:")
    println("  代码: matrix.withIndex().forEach { (i, row) -> ... }")
    println("  遍历结果:")
    matrix.withIndex().forEach { (i, row) ->
        row.withIndex().forEach { (j, value) ->
            print("  [$i][$j]=$value ")
        }
        println()
    }
    println()
}

/**
 * 演示5: 三维数组基础
 *
 * 三维数组就是"二维数组的数组"
 * 可以想象成一个立方体，有长、宽、高三个维度
 * 用 [深度][行][列] 来访问元素
 */
fun demonstrate3DArrayBasic() {
    println("【演示5】三维数组基础 - 什么是三维数组")
    println("-".repeat(60))

    // 创建一个 2x3x4 的三维数组
    // 第一维：2（深度，可以想象成2层）
    // 第二维：3（行数）
    // 第三维：4（列数）
    val cube = Array(2) { Array(3) { IntArray(4) } }

    println("创建代码: val cube = Array(2) { Array(3) { IntArray(4) } }")
    println("说明: 创建了一个 2x3x4 的三维数组")
    println("  - 第一维：2（深度，2层）")
    println("  - 第二维：3（行数）")
    println("  - 第三维：4（列数）")
    println("  - 所有元素默认初始化为 0")
    println()

    // 打印数组结构
    println("数组结构:")
    for (d in cube.indices) {
        println("  第${d}层:")
        for (r in cube[d].indices) {
            println("    ${cube[d][r].contentToString()}")
        }
    }
    println()
}

/**
 * 演示6: 三维数组的访问和遍历
 *
 * 访问三维数组就像在立方体中找一个点
 * 需要指定深度、行、列三个坐标
 */
fun demonstrate3DArrayAccess() {
    println("【演示6】三维数组的访问和遍历")
    println("-".repeat(60))

    // 创建一个 2x2x2 的三维数组，并初始化值
    val cube = Array(2) { d ->
        Array(2) { r ->
            IntArray(2) { c ->
                (d + 1) * 100 + (r + 1) * 10 + (c + 1)
            }
        }
    }

    println("创建代码: Array(2) { d -> Array(2) { r -> IntArray(2) { c -> ... } } }")
    println("初始化规则: 值 = (深度+1)*100 + (行+1)*10 + (列+1)")
    println()

    // 访问单个元素
    println("访问单个元素:")
    println("  cube[0][0][0] = ${cube[0][0][0]}")
    println("  cube[0][1][1] = ${cube[0][1][1]}")
    println("  cube[1][1][1] = ${cube[1][1][1]}")
    println()

    // 遍历三维数组
    println("遍历三维数组:")
    for (d in cube.indices) {
        println("  第${d}层:")
        for (r in cube[d].indices) {
            print("    ")
            for (c in cube[d][r].indices) {
                print("${cube[d][r][c]} ")
            }
            println()
        }
    }
    println()

    // 修改元素
    println("修改元素:")
    println("  修改前: cube[1][0][0] = ${cube[1][0][0]}")
    cube[1][0][0] = 999
    println("  修改后: cube[1][0][0] = ${cube[1][0][0]}")
    println()
}

/**
 * 演示7: 二维数组的实际应用 - 学生成绩表
 *
 * 用二维数组存储学生的多次考试成绩
 * 行代表学生，列代表考试次数
 */
fun demonstrate2DArrayRealWorld() {
    println("【演示7】二维数组的实际应用 - 学生成绩表")
    println("-".repeat(60))

    // 创建一个 4x3 的成绩表
    // 4个学生，3次考试
    val scores = arrayOf(
        intArrayOf(85, 90, 88),  // 学生1的三次成绩
        intArrayOf(92, 88, 95),  // 学生2的三次成绩
        intArrayOf(78, 82, 80),  // 学生3的三次成绩
        intArrayOf(95, 93, 97)   // 学生4的三次成绩
    )

    println("学生成绩表（4个学生，3次考试）:")
    println("学生\\考试  第1次  第2次  第3次")
    for (i in scores.indices) {
        print("学生${i + 1}    ")
        for (j in scores[i].indices) {
            print("${scores[i][j]}   ")
        }
        println()
    }
    println()

    // 计算每个学生的平均成绩
    println("计算每个学生的平均成绩:")
    for (i in scores.indices) {
        val average = scores[i].sum() / scores[i].size
        println("  学生${i + 1}的平均成绩: $average")
    }
    println()

    // 计算每次考试的平均成绩
    println("计算每次考试的平均成绩:")
    for (j in scores[0].indices) {
        var sum = 0
        for (i in scores.indices) {
            sum += scores[i][j]
        }
        val average = sum / scores.size
        println("  第${j + 1}次考试的平均成绩: $average")
    }
    println()

    // 找出最高分
    println("找出最高分:")
    var maxScore = 0
    var maxStudent = 0
    var maxExam = 0
    for (i in scores.indices) {
        for (j in scores[i].indices) {
            if (scores[i][j] > maxScore) {
                maxScore = scores[i][j]
                maxStudent = i
                maxExam = j
            }
        }
    }
    println("  最高分: $maxScore（学生${maxStudent + 1}在第${maxExam + 1}次考试）")
    println()
}

/**
 * 演示8: 二维数组的实际应用 - 矩阵运算
 *
 * 用二维数组表示矩阵，进行矩阵运算
 * 比如矩阵转置、矩阵相加等
 */
fun demonstrate2DArrayMatrix() {
    println("【演示8】二维数组的实际应用 - 矩阵运算")
    println("-".repeat(60))

    // 创建一个 3x3 的矩阵
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    println("原始矩阵:")
    for (row in matrix) {
        println("  ${row.contentToString()}")
    }
    println()

    // 矩阵转置（行变列，列变行）
    println("矩阵转置（行变列，列变行）:")
    val transposed = Array(3) { col ->
        IntArray(3) { row ->
            matrix[row][col]
        }
    }
    println("  转置后的矩阵:")
    for (row in transposed) {
        println("    ${row.contentToString()}")
    }
    println()

    // 矩阵相加
    println("矩阵相加:")
    val matrix2 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 1)
    )
    println("  第二个矩阵:")
    for (row in matrix2) {
        println("    ${row.contentToString()}")
    }
    val sum = Array(3) { i ->
        IntArray(3) { j ->
            matrix[i][j] + matrix2[i][j]
        }
    }
    println("  相加结果:")
    for (row in sum) {
        println("    ${row.contentToString()}")
    }
    println()

    // 计算矩阵的迹（对角线元素之和）
    println("计算矩阵的迹（对角线元素之和）:")
    var trace = 0
    for (i in matrix.indices) {
        trace += matrix[i][i]
    }
    println("  矩阵的迹: $trace")
    println()
}

/**
 * 演示9: 二维数组的实际应用 - 图像像素处理
 *
 * 用二维数组表示图像的像素
 * 每个元素代表一个像素的灰度值（0-255）
 */
fun demonstrate2DArrayImage() {
    println("【演示9】二维数组的实际应用 - 图像像素处理")
    println("-".repeat(60))

    // 创建一个 5x5 的图像（灰度值）
    val image = Array(5) { row ->
        IntArray(5) { col ->
            // 创建一个简单的渐变效果
            (row + col) * 25
        }
    }

    println("5x5 图像的灰度值:")
    for (row in image) {
        print("  ")
        for (value in row) {
            print("${String.format("%3d", value)} ")
        }
        println()
    }
    println()

    // 图像反转（255 - 灰度值）
    println("图像反转（255 - 灰度值）:")
    val inverted = Array(5) { row ->
        IntArray(5) { col ->
            255 - image[row][col]
        }
    }
    for (row in inverted) {
        print("  ")
        for (value in row) {
            print("${String.format("%3d", value)} ")
        }
        println()
    }
    println()

    // 计算图像的平均灰度值
    println("计算图像的平均灰度值:")
    var sum = 0
    var count = 0
    for (row in image) {
        for (value in row) {
            sum += value
            count++
        }
    }
    val average = sum / count
    println("  平均灰度值: $average")
    println()
}

/**
 * 演示10: 二维数组的实际应用 - 游戏棋盘
 *
 * 用二维数组表示游戏棋盘
 * 比如象棋、国际象棋、五子棋等
 */
fun demonstrate2DArrayGameBoard() {
    println("【演示10】二维数组的实际应用 - 游戏棋盘")
    println("-".repeat(60))

    // 创建一个 8x8 的国际象棋棋盘
    // 0 表示空，1 表示白棋，2 表示黑棋
    val board = Array(8) { IntArray(8) }

    // 初始化棋盘（简化版，只放几个棋子）
    board[0][0] = 1  // 白棋
    board[0][7] = 1  // 白棋
    board[7][0] = 2  // 黑棋
    board[7][7] = 2  // 黑棋
    board[3][3] = 1  // 白棋
    board[4][4] = 2  // 黑棋

    println("8x8 国际象棋棋盘（0=空，1=白棋，2=黑棋）:")
    println("  列: 0 1 2 3 4 5 6 7")
    for (i in board.indices) {
        print("行$i: ")
        for (j in board[i].indices) {
            print("${board[i][j]} ")
        }
        println()
    }
    println()

    // 统计棋子数量
    println("统计棋子数量:")
    var whiteCount = 0
    var blackCount = 0
    for (row in board) {
        for (value in row) {
            when (value) {
                1 -> whiteCount++
                2 -> blackCount++
            }
        }
    }
    println("  白棋数量: $whiteCount")
    println("  黑棋数量: $blackCount")
    println()

    // 检查某个位置是否有棋子
    println("检查某个位置是否有棋子:")
    val checkRow = 3
    val checkCol = 3
    val piece = board[checkRow][checkCol]
    val pieceType = when (piece) {
        0 -> "空"
        1 -> "白棋"
        2 -> "黑棋"
        else -> "未知"
    }
    println("  位置[$checkRow][$checkCol]: $pieceType")
    println()

    // 移动棋子
    println("移动棋子:")
    println("  将位置[3][3]的棋子移动到[4][3]")
    board[4][3] = board[3][3]
    board[3][3] = 0
    println("  移动后的棋盘:")
    println("  列: 0 1 2 3 4 5 6 7")
    for (i in board.indices) {
        print("行$i: ")
        for (j in board[i].indices) {
            print("${board[i][j]} ")
        }
        println()
    }
    println()
}

fun main() {
    println("========== Kotlin 多维数组完整演示 ==========\n")

    // 调用各个演示方法
    demonstrate2DArrayBasic()
    demonstrate2DArrayCreation()
    demonstrate2DArrayAccess()
    demonstrate2DArrayTraversal()
    demonstrate3DArrayBasic()
    demonstrate3DArrayAccess()
    demonstrate2DArrayRealWorld()
    demonstrate2DArrayMatrix()
    demonstrate2DArrayImage()
    demonstrate2DArrayGameBoard()

    println("\n========== 演示结束 ==========")
}
