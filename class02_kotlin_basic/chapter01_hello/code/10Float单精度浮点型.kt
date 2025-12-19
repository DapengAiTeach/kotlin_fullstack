fun main() {
    // 单精度浮点数
    val gravity = 9.80665f
    val time = 0.5f
    // 计算速度
    val speed = gravity * time
    kotlin.io.println("0.5 s 后速度=$speed m/s")   // 4.903325
}