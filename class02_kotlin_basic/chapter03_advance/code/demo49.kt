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
    // 准备一个简单的集合
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
}