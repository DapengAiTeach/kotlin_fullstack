// 顶层函数
fun greet(name: String = "World") = "Hello, $name!"

fun main() {
    println(greet())        // Hello, World!
    println(greet("Kotlin")) // Hello, Kotlin!
}