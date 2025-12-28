/**
 * Kotlin List 集合完整示例
 *
 * 本示例演示Kotlin中List集合的各种常用操作和函数式编程的应用
 * 包括创建、转换、过滤、聚合等核心功能
 *
 * 核心概念：
 * - List是有序的、不可变的集合
 * - 支持丰富的函数式操作（map、filter、fold等）
 * - 采用链式调用实现优雅的数据处理流程
 * - 函数式编程强调不可变性和纯函数
 */

/**
 * 数据模型：学生信息
 * 使用data class定义不可变的数据结构
 *
 * @param id 学生ID
 * @param name 学生姓名
 * @param age 学生年龄
 * @param score 学生成绩（0-100）
 * @param major 专业
 */
data class Student(
    val id: Int,
    val name: String,
    val age: Int,
    val score: Double,
    val major: String
)

/**
 * 数据模型：课程信息
 *
 * @param courseId 课程ID
 * @param courseName 课程名称
 * @param credits 学分
 */
data class Course(
    val courseId: Int,
    val courseName: String,
    val credits: Int
)

/**
 * List集合操作的工具类
 * 使用object单例模式，包含所有与List相关的函数式操作
 */
object ListOperations {

    /**
     * 1. 创建List集合的各种方式
     * 演示List的初始化方法
     */
    fun demonstrateListCreation() {
        println("=== 1. List集合的创建方式 ===\n")

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
        val rangeList = (1..10).toList()
        println("从范围转换的List: $rangeList")

        println()
    }

    /**
     * 2. 基础访问操作
     * 演示如何访问List中的元素
     */
    fun demonstrateBasicAccess() {
        println("=== 2. 基础访问操作 ===\n")

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

        println()
    }

    /**
     * 3. 函数式操作：map（映射/转换）
     * 将List中的每个元素通过函数转换为新的值
     */
    fun demonstrateMap() {
        println("=== 3. Map操作（元素转换） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5)

        // 基础map：将每个数字乘以2
        val doubled = numbers.map { it * 2 }
        println("原始List: $numbers")
        println("乘以2后: $doubled")

        // map配合数据类：转换学生对象
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理")
        )

        // 提取学生姓名
        val names = students.map { it.name }
        println("学生姓名列表: $names")

        // 提取学生成绩并四舍五入
        val scores = students.map { it.score.toInt() }
        println("学生成绩列表: $scores")

        // 创建学生信息字符串
        val studentInfo = students.map { "${it.name}(${it.major})" }
        println("学生信息: $studentInfo")

        println()
    }

    /**
     * 4. 函数式操作：filter（过滤）
     * 根据条件筛选List中的元素
     */
    fun demonstrateFilter() {
        println("=== 4. Filter操作（元素过滤） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // 过滤偶数
        val evenNumbers = numbers.filter { it % 2 == 0 }
        println("原始List: $numbers")
        println("偶数: $evenNumbers")

        // 过滤奇数
        val oddNumbers = numbers.filter { it % 2 != 0 }
        println("奇数: $oddNumbers")

        // 过滤大于5的数字
        val greaterThanFive = numbers.filter { it > 5 }
        println("大于5的数字: $greaterThanFive")

        // 对学生List进行过滤
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机")
        )

        // 过滤成绩大于等于85的学生
        val excellentStudents = students.filter { it.score >= 85 }
        println("成绩优秀的学生: ${excellentStudents.map { it.name }}")

        // 过滤计算机专业的学生
        val csStudents = students.filter { it.major == "计算机" }
        println("计算机专业学生: ${csStudents.map { it.name }}")

        println()
    }

    /**
     * 5. 函数式操作：map + filter 链式调用
     * 组合多个操作实现复杂的数据处理
     */
    fun demonstrateMapAndFilter() {
        println("=== 5. Map和Filter的链式调用 ===\n")

        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机"),
            Student(5, "孙七", 21, 95.5, "数学")
        )

        // 场景1：获取成绩大于等于85的学生的姓名
        val excellentNames = students
            .filter { it.score >= 85 }
            .map { it.name }
        println("成绩优秀的学生: $excellentNames")

        // 场景2：获取计算机专业且成绩大于等于85的学生信息
        val excellentCsStudents = students
            .filter { it.major == "计算机" }
            .filter { it.score >= 85 }
            .map { "${it.name}(${it.score})" }
        println("计算机专业优秀学生: $excellentCsStudents")

        // 场景3：获取所有学生的成绩等级
        val gradeInfo = students
            .map { student ->
                val grade = when {
                    student.score >= 90 -> "A"
                    student.score >= 80 -> "B"
                    student.score >= 70 -> "C"
                    else -> "D"
                }
                "${student.name}: $grade"
            }
        println("学生成绩等级:")
        gradeInfo.forEach { println("  $it") }

        println()
    }

    /**
     * 6. 函数式操作：fold（折叠/聚合）
     * 将List中的所有元素聚合为单个值
     */
    fun demonstrateFold() {
        println("=== 6. Fold操作（元素聚合） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5)

        // 计算总和（初始值为0）
        val sum = numbers.fold(0) { accumulator, value ->
            accumulator + value
        }
        println("数字列表: $numbers")
        println("总和: $sum")

        // 计算乘积（初始值为1）
        val product = numbers.fold(1) { acc, value ->
            acc * value
        }
        println("乘积: $product")

        // 使用fold构建字符串
        val concatenated = numbers.fold("") { acc, value ->
            acc + value
        }
        println("连接字符串: $concatenated")

        // 对学生成绩进行聚合
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理")
        )

        // 计算平均成绩
        val totalScore = students.fold(0.0) { acc, student ->
            acc + student.score
        }
        val averageScore = totalScore / students.size
        println("学生平均成绩: $averageScore")

        // 使用fold构建学生信息字符串
        val studentList = students.fold("学生列表:\n") { acc, student ->
            acc + "  - ${student.name}(${student.major}): ${student.score}\n"
        }
        println(studentList)

        println()
    }

    /**
     * 7. 函数式操作：reduce（规约）
     * 类似fold，但没有初始值，使用第一个元素作为初始值
     */
    fun demonstrateReduce() {
        println("=== 7. Reduce操作（规约） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5)

        // 计算总和
        val sum = numbers.reduce { acc, value ->
            acc + value
        }
        println("数字列表: $numbers")
        println("总和: $sum")

        // 找出最大值
        val max = numbers.reduce { acc, value ->
            if (value > acc) value else acc
        }
        println("最大值: $max")

        // 找出最小值
        val min = numbers.reduce { acc, value ->
            if (value < acc) value else acc
        }
        println("最小值: $min")

        println()
    }

    /**
     * 8. 函数式操作：groupBy（分组）
     * 根据条件将List中的元素分组
     */
    fun demonstrateGroupBy() {
        println("=== 8. GroupBy操作（元素分组） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // 按奇偶性分组
        val groupedByParity = numbers.groupBy { if (it % 2 == 0) "偶数" else "奇数" }
        println("按奇偶性分组: $groupedByParity")

        // 对学生按专业分组
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机"),
            Student(5, "孙七", 21, 95.5, "数学")
        )

        val groupedByMajor = students.groupBy { it.major }
        println("按专业分组:")
        groupedByMajor.forEach { (major, studentList) ->
            println("  $major: ${studentList.map { it.name }}")
        }

        // 按成绩等级分组
        val groupedByGrade = students.groupBy { student ->
            when {
                student.score >= 90 -> "A"
                student.score >= 80 -> "B"
                student.score >= 70 -> "C"
                else -> "D"
            }
        }
        println("按成绩等级分组:")
        groupedByGrade.forEach { (grade, studentList) ->
            println("  $grade: ${studentList.map { it.name }}")
        }

        println()
    }

    /**
     * 9. 函数式操作：flatMap（扁平映射）
     * 先map后flatten，用于处理嵌套结构
     */
    fun demonstrateFlatMap() {
        println("=== 9. FlatMap操作（扁平映射） ===\n")

        // 场景1：将每个数字转换为包含该数字及其倍数的List
        val numbers = listOf(1, 2, 3)
        val flatMapped = numbers.flatMap { num ->
            listOf(num, num * 2, num * 3)
        }
        println("原始List: $numbers")
        println("FlatMap结果: $flatMapped")

        // 场景2：处理嵌套的学生课程关系
        data class StudentCourse(val studentName: String, val courses: List<String>)

        val studentCourses = listOf(
            StudentCourse("张三", listOf("数学", "物理", "化学")),
            StudentCourse("李四", listOf("英语", "历史")),
            StudentCourse("王五", listOf("数学", "英语", "生物"))
        )

        // 获取所有学生选修的课程（去重）
        val allCourses = studentCourses
            .flatMap { it.courses }
            .distinct()
        println("所有学生选修的课程: $allCourses")

        // 获取选修数学的学生
        val mathStudents = studentCourses
            .filter { it.courses.contains("数学") }
            .map { it.studentName }
        println("选修数学的学生: $mathStudents")

        println()
    }

    /**
     * 10. 函数式操作：any、all、none
     * 用于判断List中是否存在满足条件的元素
     */
    fun demonstratePredicates() {
        println("=== 10. 谓词操作（any、all、none） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // any：是否存在满足条件的元素
        val hasEven = numbers.any { it % 2 == 0 }
        println("是否存在偶数: $hasEven")

        val hasGreaterThan20 = numbers.any { it > 20 }
        println("是否存在大于20的数: $hasGreaterThan20")

        // all：是否所有元素都满足条件
        val allPositive = numbers.all { it > 0 }
        println("是否所有数都是正数: $allPositive")

        val allLessThan100 = numbers.all { it < 100 }
        println("是否所有数都小于100: $allLessThan100")

        // none：是否没有元素满足条件
        val noNegative = numbers.none { it < 0 }
        println("是否没有负数: $noNegative")

        val noGreaterThan20 = numbers.none { it > 20 }
        println("是否没有大于20的数: $noGreaterThan20")

        // 对学生List的谓词操作
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理")
        )

        val hasExcellent = students.any { it.score >= 90 }
        println("是否有成绩优秀的学生: $hasExcellent")

        val allAdult = students.all { it.age >= 18 }
        println("是否所有学生都成年: $allAdult")

        println()
    }

    /**
     * 11. 函数式操作：find、findLast、first、last
     * 用于查找List中的特定元素
     */
    fun demonstrateFindOperations() {
        println("=== 11. 查找操作（find、first、last） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // find：找到第一个满足条件的元素
        val firstEven = numbers.find { it % 2 == 0 }
        println("第一个偶数: $firstEven")

        // findLast：找到最后一个满足条件的元素
        val lastEven = numbers.findLast { it % 2 == 0 }
        println("最后一个偶数: $lastEven")

        // first：获取第一个元素（可带条件）
        val first = numbers.first()
        println("第一个元素: $first")

        val firstGreaterThan5 = numbers.first { it > 5 }
        println("第一个大于5的元素: $firstGreaterThan5")

        // last：获取最后一个元素（可带条件）
        val last = numbers.last()
        println("最后一个元素: $last")

        // 对学生List的查找操作
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理")
        )

        val topStudent = students.maxByOrNull { it.score }
        println("成绩最高的学生: ${topStudent?.name}(${topStudent?.score})")

        val lowestStudent = students.minByOrNull { it.score }
        println("成绩最低的学生: ${lowestStudent?.name}(${lowestStudent?.score})")

        println()
    }

    /**
     * 12. 函数式操作：distinct、sorted、reversed
     * 用于对List进行去重、排序、反转等操作
     */
    fun demonstrateTransformations() {
        println("=== 12. 转换操作（distinct、sorted、reversed） ===\n")

        val numbers = listOf(3, 1, 4, 1, 5, 9, 2, 6, 5, 3)

        // distinct：去重
        val unique = numbers.distinct()
        println("原始List: $numbers")
        println("去重后: $unique")

        // sorted：排序（升序）
        val sorted = numbers.sorted()
        println("升序排序: $sorted")

        // sortedDescending：降序排序
        val sortedDesc = numbers.sortedDescending()
        println("降序排序: $sortedDesc")

        // reversed：反转
        val reversed = numbers.reversed()
        println("反转: $reversed")

        // 对学生List的排序操作
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机")
        )

        // 按成绩降序排序
        val sortedByScore = students.sortedByDescending { it.score }
        println("按成绩降序排序:")
        sortedByScore.forEach { println("  ${it.name}: ${it.score}") }

        // 按年龄升序，再按成绩降序
        val sortedByAgeAndScore = students.sortedWith(
            compareBy<Student> { it.age }
                .thenByDescending { it.score }
        )
        println("按年龄升序、成绩降序排序:")
        sortedByAgeAndScore.forEach { println("  ${it.name}(${it.age}岁): ${it.score}") }

        println()
    }

    /**
     * 13. 函数式操作：take、drop、slice
     * 用于获取List的子集
     */
    fun demonstrateSubsetOperations() {
        println("=== 13. 子集操作（take、drop、slice） ===\n")

        val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // take：获取前n个元素
        val first3 = numbers.take(3)
        println("原始List: $numbers")
        println("前3个元素: $first3")

        // takeLast：获取最后n个元素
        val last3 = numbers.takeLast(3)
        println("最后3个元素: $last3")

        // drop：跳过前n个元素
        val dropFirst3 = numbers.drop(3)
        println("跳过前3个元素: $dropFirst3")

        // dropLast：跳过最后n个元素
        val dropLast3 = numbers.dropLast(3)
        println("跳过最后3个元素: $dropLast3")

        // slice：获取指定范围的元素
        val sliced = numbers.slice(2..5)
        println("获取索引2到5的元素: $sliced")

        // 实际应用：分页
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机"),
            Student(5, "孙七", 21, 95.5, "数学")
        )

        val pageSize = 2
        val page1 = students.take(pageSize)
        val page2 = students.drop(pageSize).take(pageSize)
        println("分页示例（每页2条）:")
        println("  第1页: ${page1.map { it.name }}")
        println("  第2页: ${page2.map { it.name }}")

        println()
    }

    /**
     * 14. 函数式操作：zip、associate
     * 用于组合多个List或创建映射关系
     */
    fun demonstrateZipAndAssociate() {
        println("=== 14. 组合操作（zip、associate） ===\n")

        val names = listOf("张三", "李四", "王五")
        val scores = listOf(85.5, 92.0, 78.5)

        // zip：将两个List组合成Pair的List
        val zipped = names.zip(scores)
        println("姓名: $names")
        println("成绩: $scores")
        println("组合结果: $zipped")

        // 使用zip的结果
        val studentInfo = zipped.map { (name, score) ->
            "$name: $score"
        }
        println("学生信息: $studentInfo")

        // associate：创建Map，key和value都由lambda生成
        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理")
        )

        val studentMap = students.associate { it.id to it.name }
        println("学生ID到姓名的映射: $studentMap")

        val scoreMap = students.associate { it.name to it.score }
        println("学生姓名到成绩的映射: $scoreMap")

        println()
    }

    /**
     * 15. 综合实战：复杂的数据处理流程
     * 展示如何组合多个函数式操作解决实际问题
     */
    fun demonstrateComplexOperations() {
        println("=== 15. 综合实战：复杂数据处理 ===\n")

        val students = listOf(
            Student(1, "张三", 20, 85.5, "计算机"),
            Student(2, "李四", 21, 92.0, "数学"),
            Student(3, "王五", 20, 78.5, "物理"),
            Student(4, "赵六", 22, 88.0, "计算机"),
            Student(5, "孙七", 21, 95.5, "数学"),
            Student(6, "周八", 20, 72.0, "物理")
        )

        // 场景1：获取计算机专业成绩优秀（>=85）的学生，按成绩降序排列
        println("场景1：计算机专业优秀学生（成绩>=85）")
        val excellentCsStudents = students
            .filter { it.major == "计算机" }
            .filter { it.score >= 85 }
            .sortedByDescending { it.score }
            .map { "${it.name}(${it.score})" }
        excellentCsStudents.forEach { println("  $it") }

        // 场景2：计算各专业的平均成绩
        println("\n场景2：各专业平均成绩")
        val majorAverages = students
            .groupBy { it.major }
            .mapValues { (_, studentList) ->
                studentList.map { it.score }.average()
            }
        majorAverages.forEach { (major, avg) ->
            println("  $major: ${"%.2f".format(avg)}")
        }

        // 场景3：找出每个专业成绩最高的学生
        println("\n场景3：各专业成绩最高的学生")
        val topStudentPerMajor = students
            .groupBy { it.major }
            .mapValues { (_, studentList) ->
                studentList.maxByOrNull { it.score }
            }
        topStudentPerMajor.forEach { (major, student) ->
            println("  $major: ${student?.name}(${student?.score})")
        }

        // 场景4：统计成绩分布
        println("\n场景4：成绩分布统计")
        val gradeDistribution = students
            .groupBy { student ->
                when {
                    student.score >= 90 -> "A(90-100)"
                    student.score >= 80 -> "B(80-89)"
                    student.score >= 70 -> "C(70-79)"
                    else -> "D(0-69)"
                }
            }
            .mapValues { (_, studentList) -> studentList.size }
        gradeDistribution.forEach { (grade, count) ->
            println("  $grade: $count 人")
        }

        // 场景5：生成学生成绩报告
        println("\n场景5：学生成绩报告")
        val report = students
            .sortedByDescending { it.score }
            .mapIndexed { index, student ->
                val rank = index + 1
                val grade = when {
                    student.score >= 90 -> "A"
                    student.score >= 80 -> "B"
                    student.score >= 70 -> "C"
                    else -> "D"
                }
                val rankStr = rank.toString()
                "第$rankStr 名: ${student.name}(${student.major}) - ${student.score} [$grade]"
            }
        report.forEach { println("  $it") }

        println()
    }
}

/**
 * 程序入口点
 * 依次演示List集合的各种操作
 */
fun main() {
    println("╔════════════════════════════════════════════════════════════╗")
    println("║         Kotlin List 集合完整示例 - 函数式编程              ║")
    println("╚════════════════════════════════════════════════════════════╝\n")

    // 依次执行各个演示函数
    ListOperations.apply {
        demonstrateListCreation()
        demonstrateBasicAccess()
        demonstrateMap()
        demonstrateFilter()
        demonstrateMapAndFilter()
        demonstrateFold()
        demonstrateReduce()
        demonstrateGroupBy()
        demonstrateFlatMap()
        demonstratePredicates()
        demonstrateFindOperations()
        demonstrateTransformations()
        demonstrateSubsetOperations()
        demonstrateZipAndAssociate()
        demonstrateComplexOperations()
    }

    println("╔════════════════════════════════════════════════════════════╗")
    println("║                    演示完成！                              ║")
    println("╚════════════════════════════════════════════════════════════╝")
}

/**
 * 使用说明和总结
 *
 * 本示例展示了Kotlin List集合的15个核心操作：
 *
 * 1. 创建方式：listOf、mutableListOf、List构造函数、emptyList、范围转换
 * 2. 基础访问：索引访问、first/last、size、contains、indexOf
 * 3. Map操作：元素转换，支持链式调用
 * 4. Filter操作：条件过滤，支持复杂条件
 * 5. Map+Filter：链式调用实现复杂数据处理
 * 6. Fold操作：聚合所有元素为单个值，需要初始值
 * 7. Reduce操作：聚合操作，使用第一个元素作为初始值
 * 8. GroupBy操作：按条件分组，返回Map<K, List<V>>
 * 9. FlatMap操作：扁平映射，处理嵌套结构
 * 10. 谓词操作：any、all、none用于条件判断
 * 11. 查找操作：find、first、last、maxByOrNull、minByOrNull
 * 12. 转换操作：distinct、sorted、sortedDescending、reversed
 * 13. 子集操作：take、drop、slice用于获取子集
 * 14. 组合操作：zip组合两个List，associate创建映射
 * 15. 综合实战：展示实际应用场景的复杂数据处理
 *
 * 函数式编程的核心特点：
 * - 不可变性：使用val和data class定义不可变数据
 * - 纯函数：函数没有副作用，相同输入产生相同输出
 * - 链式调用：多个操作可以链接在一起，形成数据处理流程
 * - 高阶函数：接受lambda作为参数，实现灵活的数据转换
 * - 函数组合：将多个小函数组合成复杂的操作
 *
 * 最佳实践：
 * 1. 优先使用不可变的List而不是mutableList
 * 2. 使用函数式操作而不是循环，代码更简洁易读
 * 3. 链式调用时，每个操作应该是独立的、可测试的
 * 4. 对于复杂的转换，可以分解为多个简单的操作
 * 5. 使用data class定义数据模型，支持解构和copy
 * 6. 充分利用Kotlin的类型推断，减少类型声明
 * 7. 使用when表达式替代if-else，代码更清晰
 */