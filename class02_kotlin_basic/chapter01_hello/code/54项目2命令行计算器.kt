import kotlin.also
import kotlin.let
import kotlin.takeIf
import kotlin.text.toDoubleOrNull
import kotlin.text.trim

// ------------ 输入校验 ------------
fun readDouble(prompt: String): Double {
    while (true) {
        kotlin.io.print(prompt)
        kotlin.io.readlnOrNull()?.toDoubleOrNull()?.let { return it }
        kotlin.io.println("❌ 非法数字，请重新输入！")
    }
}

// ------------ 读取运算符 ------------
fun readOperator(): String {
    while (true) {
        kotlin.io.print("选择运算（+ - * /）：")
        kotlin.io.readlnOrNull()?.trim()?.
        takeIf { it in kotlin.collections.setOf("+", "-", "*", "/") }?.
        let { return it }
        kotlin.io.println("❌ 请输入 +、-、* 或 / 中的一个！")
    }
}

// ------------ 运算分发 ------------
fun calculate(a: Double, b: Double, op: String): Double? = when (op) {
    "+" -> a + b
    "-" -> a - b
    "*" -> a * b
    "/" -> if (b.isZero()) null else a / b
    else -> null
}

// ------------ 除零保护 ------------
fun Double.isZero() = kotlin.math.abs(this) < 1e-10

// ------------ 主流程 ------------
fun main() {
    kotlin.io.println("*** 控制台计算器 ***")
    val a = readDouble("请输入第一个数字：")
    val b = readDouble("请输入第二个数字：")
    val op = readOperator()
    calculate(a, b, op)?.also { result ->
        kotlin.io.println("结果：$result")
    } ?: kotlin.run {
        kotlin.io.println("❌ 运算失败：除数不能为零 / 未知运算符")
    }
}
