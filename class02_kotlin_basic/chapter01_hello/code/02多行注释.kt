/*
  文件名: Main.kt
  功能: 演示多行注释
  日期: 2025-12-18
*/

fun main() {
    val n1 = 7
    val n2 = 9

    /* 以下两行被临时屏蔽，用于调试
    println("n1 = $n1")
    println("n2 = $n2")
    */

    val max = if (n1 > n2) n1 else n2
    kotlin.io.println("max = $max")   // 输出：max = 9
}