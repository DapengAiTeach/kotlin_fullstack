fun main() {
    // 普通 continue
    for (i in 1..5) {
        if (i == 3) continue
        print(i)      // 1245（跳过 3）
    }
    println()

    // 标签跳过外层当前次
    loop@ for (row in 0..2) {
        for (col in 0..2) {
            if (col == 1) continue@loop
            print("($row,$col) ")
        }
    }
    // 输出 (0,0) (1,0) (2,0)
}