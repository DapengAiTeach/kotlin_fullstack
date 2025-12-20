import kotlin.let

fun main() {
    kotlin.io.println("请输入内容：")
    // 读取用户输入，readLine()返回可空类型String?
    val input: String? = kotlin.io.readLine()

    // 使用安全调用操作符(?.)配合let函数处理可空值
    val len = input?.let {                      // 仅当input不为null时才会执行let块
        kotlin.io.println("收到输入：$it")                 // it代表当前非空的input值
        it.length                               // let函数返回块中最后一行的值
    } ?: 0                                     // Elvis操作符(?:)处理null情况，提供默认值0

    // 输出最终计算得到的字符数
    kotlin.io.println("字符数=$len")
}
