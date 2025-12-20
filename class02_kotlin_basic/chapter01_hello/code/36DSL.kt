import kotlin.apply

/**
 * Coffee 数据类用于表示一杯咖啡
 *
 * @property sugar 糖的数量，默认为0
 * @property milk 是否添加牛奶，默认为false（不添加）
 */
data class Coffee(var sugar: Int = 0, var milk: Boolean = false)

/**
 * coffee 函数是一个构建器函数，用于创建并配置Coffee对象
 * 使用DSL风格的语法来设置Coffee的各种属性
 *
 * @param block 一个扩展函数类型的lambda表达式，用于配置Coffee对象
 * @return 配置完成的Coffee对象
 */
fun coffee(block: Coffee.() -> Unit): Coffee =
    Coffee().apply(block)

/**
 * 程序的主入口函数
 * 演示如何使用coffee DSL构建器创建并配置Coffee对象
 * 
 * 这里的代码展示了Kotlin DSL的核心特点：
 * 1. 流畅的API设计，读起来像自然语言
 * 2. 使用lambda表达式配置对象属性
 * 3. 不需要重复的对象引用，直接访问属性
 */
fun main() {
    // 使用coffee DSL构建器创建一个Coffee对象
    // 这种语法风格类似于Gradle、HTML DSL等Kotlin DSL
    val c = coffee {
        sugar = 2      // 直接设置糖的数量为2，无需前缀
        milk = true    // 直接设置添加牛奶
    }
    
    // 打印Coffee对象的信息
    // 由于Coffee是数据类，会自动打印所有属性的值
    kotlin.io.println(c) // 输出: Coffee(sugar=2, milk=true)
}