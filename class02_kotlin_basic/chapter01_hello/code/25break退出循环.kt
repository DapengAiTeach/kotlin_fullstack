fun main() {
    // 普通 break
    for (i in 1..10) {
        if (i == 5) break
        print(i)      // 1234
    }
    println()

    // 标签跳出外层
    loop@ for (row in 0..2) {
        for (col in 0..2) {
            if (row == 1 && col == 1) break@loop
            print("($row,$col) ")
        }
    }
    // 输出 (0,0) (0,1) (0,2) (1,0)
}