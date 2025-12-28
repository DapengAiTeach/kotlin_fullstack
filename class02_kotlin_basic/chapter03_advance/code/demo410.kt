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
    // 准备学生集合
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
}