/**
 * 计算矩形面积。
 *
 * @param width  宽度（必须 > 0）
 * @param height 高度（必须 > 0）
 * @return 面积值
 * @throws IllegalArgumentException 如果宽度或高度 ≤ 0
 */
fun area(width: Double, height: Double): Double {
    kotlin.require(width > 0 && height > 0) { "宽高必须为正数" }
    return width * height
}

fun main() {
    val w = 3
    val h = 2
    val areaResult = area(w.toDouble(), h.toDouble())

    kotlin.io.println("areaResult = $areaResult")   // 输出：max = 6
}