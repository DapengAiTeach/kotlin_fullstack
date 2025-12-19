import kotlin.text.firstOrNull

fun main() {
    // 输入一个字符，判断是否是数字字符
    kotlin.io.println("请输入一个字符：")
    val ch = kotlin.io.readln().firstOrNull() ?: ' '
    if (ch in '0'..'9') kotlin.io.println("是数字字符")
}