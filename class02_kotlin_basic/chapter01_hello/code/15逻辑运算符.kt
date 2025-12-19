fun main() {
    val age = 20
    val hasId = true

    // 短路与：左 false 右不再算
    if (age >= 18 && hasId) {
        kotlin.io.println("允许进入")
    }

    // 短路或：左 true 右不再算
    val isVip = false
    val isFreeDay = true
    if (isVip || isFreeDay) {
        kotlin.io.println("免费停车")
    }

    // 非
    val closed = false
    if (!closed) kotlin.io.println("营业中")
}