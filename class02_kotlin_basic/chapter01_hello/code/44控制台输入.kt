fun main() {
    print("请输入整数：")
    val n = readln().toIntOrNull() ?: 0
    println("你输入的是 $n")
}