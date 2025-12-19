fun send(
    to: String,
    subject: String = "Hi",
    body: String = "",
    cc: List<String> = emptyList()
) {
    println("Sending email to $to")
    println("Subject: $subject")
    println("Body: $body")
    println("Cc: $cc")
}

fun main() {
    // 只给变化的命名
    send("bob@x.com", subject = "Hello", body = "Kotlin")
}