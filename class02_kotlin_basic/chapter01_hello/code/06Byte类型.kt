import kotlin.collections.joinToString
import kotlin.text.format

fun main() {
    // 显式转 Byte
    val header: Byte = Int.toByte()
    // 声明要给数组
    val data = byteArrayOf(header, 0x50, 0x4E, 0x47)
    // 直接打印是Byte数组： -119 80 78 71
    kotlin.io.println(data.joinToString(" "))
    // 显式转 String，把十进制的数转换为十六进制 89 50 4E 47
    kotlin.io.println(data.joinToString(" ") { "%02X".format(it) })
}