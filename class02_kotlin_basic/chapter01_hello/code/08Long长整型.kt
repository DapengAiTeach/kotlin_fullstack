fun main() {
    // 当前毫秒时间戳
    val now: Long = java.lang.System.currentTimeMillis()
    // 3.5 GB > Int 上限
    val fileSize = 3_500_000_000L
    kotlin.io.println("时间戳=$now, 文件大小=$fileSize bytes")
}