fun main() {
    // 定义圆的半径，默认就是Double类型
    val radius = 2.5
    // 求圆的面积
    val area = java.lang.Math.PI * radius * radius
    // 面积 ≈ 19.634954084936208
    kotlin.io.println("半径=$radius, 面积=$area")
}