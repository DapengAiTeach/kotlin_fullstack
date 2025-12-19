fun log(level: String = "INFO", msg: String, vararg tags: String) {
    println("[$level] ${tags.joinToString(",")} - $msg")
}

fun main() {
    log(msg = "App start")  // 仅必填+命名
    log("ERROR", "Crash", "core", "network") // 按位传
}