fun main() {
    for (i in 1..9) {           // 外层：被乘数
        for (j in 1..i) {       // 内层：乘数，依赖 i
            print("$j*$i=${i*j}\t")
        }
        println()
    }
}