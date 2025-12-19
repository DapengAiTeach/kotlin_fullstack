fun main() {
    // 给循环起个名字，叫做 search
    search@ for (row in 0..9) {
        for (col in 0..9) {
            if (row * col == 42) {
                println("Found at ($row,$col)")
                // 跳出命名循环
                break@search
            }
        }
    }
}