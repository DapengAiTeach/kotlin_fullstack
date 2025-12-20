fun main() {
    // 创建一个StringBuilder实例，用于构建字符串
    val sb = kotlin.text.StringBuilder()

    // 使用with函数对sb进行操作
    // with函数特点：接收一个对象，在该对象的上下文中执行代码块，返回代码块的最后一行
    val len = kotlin.with(sb) {
        // 在sb的作用域内直接调用其方法，无需使用sb.前缀
        // 相当于sb.append("Hello, ")
        java.lang.StringBuilder.append("Hello, ")
        // 相当于sb.append("Kotlin")
        java.lang.StringBuilder.append("Kotlin")
        // 返回StringBuilder的length属性值（最后一行作为返回值）
        length
    }

    // 输出最终结果，len的值为13（"Hello, Kotlin"的长度）
    // 实际输出：结果=13
    kotlin.io.println("结果=$len")
}
