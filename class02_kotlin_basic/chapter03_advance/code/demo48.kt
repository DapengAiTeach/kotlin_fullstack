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

fun main() {
    // 准备数字集合
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
}