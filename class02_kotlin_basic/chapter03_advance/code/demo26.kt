/**
 * Kotlin 数组常用操作详细演示
 *
 * 本文件专门演示Kotlin中数组的常用操作方法
 * 包括：
 * 1. 数组遍历（for循环、forEach、forEachIndexed等）
 * 2. 数组查找（find、findIndex、contains等）
 * 3. 数组过滤（filter、filterNot、filterIndexed等）
 * 4. 数组映射（map、mapIndexed、flatMap等）
 * 5. 数组排序（sort、sortBy、sortDescending等）
 * 6. 数组切片（slice、take、drop等）
 *
 * 每个示例都是独立的方法，结构清晰，适合零基础学习者
 * 大白话说明：数组操作就是对数组中的元素进行各种处理
 */

/**
 * 演示1: 数组遍历 - 基础遍历方法
 *
 * 遍历就是逐个访问数组中的每个元素
 * Kotlin提供了多种遍历方法，选择最方便的就行
 */
fun demonstrateArrayTraversal() {
    println("【演示1】数组遍历 - 基础遍历方法")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(10, 20, 30, 40, 50)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 for 循环 + indices
    println("方法1 - 使用 for 循环 + indices（获取索引）:")
    println("  代码: for (i in numbers.indices) { ... }")
    println("  遍历结果:")
    for (i in numbers.indices) {
        println("    索引$i: ${numbers[i]}")
    }
    println()

    // 方法2: 使用 for-in 循环
    println("方法2 - 使用 for-in 循环（最简洁）:")
    println("  代码: for (value in numbers) { ... }")
    println("  遍历结果:")
    for (value in numbers) {
        println("    值: $value")
    }
    println()

    // 方法3: 使用 forEach
    println("方法3 - 使用 forEach（函数式风格）:")
    println("  代码: numbers.forEach { value -> ... }")
    println("  遍历结果:")
    numbers.forEach { value ->
        println("    值: $value")
    }
    println()

    // 方法4: 使用 forEachIndexed（同时获取索引和值）
    println("方法4 - 使用 forEachIndexed（获取索引和值）:")
    println("  代码: numbers.forEachIndexed { index, value -> ... }")
    println("  遍历结果:")
    numbers.forEachIndexed { index, value ->
        println("    索引$index: $value")
    }
    println()

    // 方法5: 使用 withIndex
    println("方法5 - 使用 withIndex（另一种获取索引的方式）:")
    println("  代码: numbers.withIndex().forEach { (index, value) -> ... }")
    println("  遍历结果:")
    numbers.withIndex().forEach { (index, value) ->
        println("    索引$index: $value")
    }
    println()
}

/**
 * 演示2: 数组查找 - 查找元素
 *
 * 查找就是在数组中寻找满足条件的元素
 * 可以查找第一个、最后一个，或者检查是否存在
 */
fun demonstrateArrayFind() {
    println("【演示2】数组查找 - 查找元素")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 contains 检查是否存在
    println("方法1 - 使用 contains 检查是否存在:")
    println("  代码: numbers.contains(30)")
    val hasThirty = numbers.contains(30)
    println("  结果: $hasThirty（数组中是否包含30）")
    println()

    // 方法2: 使用 in 操作符
    println("方法2 - 使用 in 操作符:")
    println("  代码: 50 in numbers")
    val hasFifty = 50 in numbers
    println("  结果: $hasFifty（数组中是否包含50）")
    println()

    // 方法3: 使用 find 查找第一个满足条件的元素
    println("方法3 - 使用 find 查找第一个满足条件的元素:")
    println("  代码: numbers.find { it > 35 }")
    val firstGreaterThan35 = numbers.find { it > 35 }
    println("  结果: $firstGreaterThan35（第一个大于35的元素）")
    println()

    // 方法4: 使用 findLast 查找最后一个满足条件的元素
    println("方法4 - 使用 findLast 查找最后一个满足条件的元素:")
    println("  代码: numbers.findLast { it < 60 }")
    val lastLessThan60 = numbers.findLast { it < 60 }
    println("  结果: $lastLessThan60（最后一个小于60的元素）")
    println()

    // 方法5: 使用 findIndex 查找第一个满足条件的元素的索引
    println("方法5 - 使用 findIndex 查找第一个满足条件的元素的索引:")
    println("  代码: numbers.indexOfFirst { it > 35 }")
    val indexOfFirstGreater = numbers.indexOfFirst { it > 35 }
    println("  结果: $indexOfFirstGreater（第一个大于35的元素的索引）")
    println()

    // 方法6: 使用 indexOf 查找元素的索引
    println("方法6 - 使用 indexOf 查找元素的索引:")
    println("  代码: numbers.indexOf(50)")
    val indexOfFifty = numbers.indexOf(50)
    println("  结果: $indexOfFifty（元素50的索引）")
    println()

    // 方法7: 使用 any 检查是否存在满足条件的元素
    println("方法7 - 使用 any 检查是否存在满足条件的元素:")
    println("  代码: numbers.any { it > 70 }")
    val hasGreaterThan70 = numbers.any { it > 70 }
    println("  结果: $hasGreaterThan70（是否存在大于70的元素）")
    println()

    // 方法8: 使用 all 检查是否所有元素都满足条件
    println("方法8 - 使用 all 检查是否所有元素都满足条件:")
    println("  代码: numbers.all { it > 0 }")
    val allPositive = numbers.all { it > 0 }
    println("  结果: $allPositive（是否所有元素都大于0）")
    println()
}

/**
 * 演示3: 数组过滤 - 筛选元素
 *
 * 过滤就是根据条件筛选出符合要求的元素
 * 返回一个新的数组，不修改原数组
 */
fun demonstrateArrayFilter() {
    println("【演示3】数组过滤 - 筛选元素")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(10, 15, 20, 25, 30, 35, 40, 45, 50)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 filter 筛选满足条件的元素
    println("方法1 - 使用 filter 筛选满足条件的元素:")
    println("  代码: numbers.filter { it > 25 }")
    val greaterThan25 = numbers.filter { it > 25 }
    println("  结果: $greaterThan25（所有大于25的元素）")
    println()

    // 方法2: 使用 filterNot 筛选不满足条件的元素
    println("方法2 - 使用 filterNot 筛选不满足条件的元素:")
    println("  代码: numbers.filterNot { it > 30 }")
    val notGreaterThan30 = numbers.filterNot { it > 30 }
    println("  结果: $notGreaterThan30（所有不大于30的元素）")
    println()

    // 方法3: 使用 filterIndexed 根据索引和值过滤
    println("方法3 - 使用 filterIndexed 根据索引和值过滤:")
    println("  代码: numbers.filterIndexed { index, value -> index % 2 == 0 }")
    val evenIndices = numbers.filterIndexed { index, _ -> index % 2 == 0 }
    println("  结果: $evenIndices（索引为偶数的元素）")
    println()

    // 方法4: 使用 take 获取前N个元素
    println("方法4 - 使用 take 获取前N个元素:")
    println("  代码: numbers.take(3)")
    val firstThree = numbers.take(3)
    println("  结果: $firstThree（前3个元素）")
    println()

    // 方法5: 使用 takeLast 获取最后N个元素
    println("方法5 - 使用 takeLast 获取最后N个元素:")
    println("  代码: numbers.takeLast(3)")
    val lastThree = numbers.takeLast(3)
    println("  结果: $lastThree（最后3个元素）")
    println()

    // 方法6: 使用 takeWhile 获取满足条件的前缀元素
    println("方法6 - 使用 takeWhile 获取满足条件的前缀元素:")
    println("  代码: numbers.takeWhile { it < 30 }")
    val takeWhileResult = numbers.takeWhile { it < 30 }
    println("  结果: $takeWhileResult（从开始获取所有小于30的元素）")
    println()

    // 方法7: 使用 drop 跳过前N个元素
    println("方法7 - 使用 drop 跳过前N个元素:")
    println("  代码: numbers.drop(3)")
    val skipFirst = numbers.drop(3)
    println("  结果: $skipFirst（跳过前3个元素）")
    println()

    // 方法8: 使用 dropLast 跳过最后N个元素
    println("方法8 - 使用 dropLast 跳过最后N个元素:")
    println("  代码: numbers.dropLast(2)")
    val skipLast = numbers.dropLast(2)
    println("  结果: $skipLast（跳过最后2个元素）")
    println()
}

/**
 * 演示4: 数组映射 - 转换元素
 *
 * 映射就是对数组中的每个元素进行转换
 * 返回一个新的数组，每个元素都经过转换函数处理
 */
fun demonstrateArrayMap() {
    println("【演示4】数组映射 - 转换元素")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 map 转换每个元素
    println("方法1 - 使用 map 转换每个元素:")
    println("  代码: numbers.map { it * 2 }")
    val doubled = numbers.map { it * 2 }
    println("  结果: $doubled（每个元素乘以2）")
    println()

    // 方法2: 使用 map 转换为其他类型
    println("方法2 - 使用 map 转换为其他类型:")
    println("  代码: numbers.map { it.toString() }")
    val asStrings = numbers.map { it.toString() }
    println("  结果: $asStrings（转换为字符串）")
    println()

    // 方法3: 使用 mapIndexed 根据索引和值转换
    println("方法3 - 使用 mapIndexed 根据索引和值转换:")
    println("  代码: numbers.mapIndexed { index, value -> index + value }")
    val indexPlusValue = numbers.mapIndexed { index, value -> index + value }
    println("  结果: $indexPlusValue（索引加上值）")
    println()

    // 方法4: 使用 flatMap 扁平化映射
    println("方法4 - 使用 flatMap 扁平化映射:")
    println("  代码: numbers.flatMap { listOf(it, it * 2) }")
    val flatMapped = numbers.flatMap { listOf(it, it * 2) }
    println("  结果: $flatMapped（每个元素映射为两个值）")
    println()

    // 方法5: 使用 associate 创建键值对
    println("方法5 - 使用 associate 创建键值对:")
    println("  代码: numbers.associate { it to it * it }")
    val squared = numbers.associate { it to it * it }
    println("  结果: $squared（创建数字到其平方的映射）")
    println()

    // 方法6: 使用 groupBy 分组
    println("方法6 - 使用 groupBy 分组:")
    println("  代码: numbers.groupBy { it % 2 }")
    val grouped = numbers.groupBy { it % 2 }
    println("  结果: $grouped（按奇偶性分组）")
    println()

    // 方法7: 使用 partition 分割
    println("方法7 - 使用 partition 分割:")
    println("  代码: numbers.partition { it > 2 }")
    val (greater, lessOrEqual) = numbers.partition { it > 2 }
    println("  结果: 大于2的=$greater, 小于等于2的=$lessOrEqual")
    println()
}

/**
 * 演示5: 数组排序 - 排列元素
 *
 * 排序就是按照某种规则重新排列数组中的元素
 * 可以升序、降序，也可以按照自定义规则排序
 */
fun demonstrateArraySort() {
    println("【演示5】数组排序 - 排列元素")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(50, 20, 80, 10, 40, 30, 70, 60)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 sorted 升序排序（返回新列表）
    println("方法1 - 使用 sorted 升序排序:")
    println("  代码: numbers.sorted()")
    val ascending = numbers.sorted()
    println("  结果: $ascending（升序排列）")
    println()

    // 方法2: 使用 sortedDescending 降序排序
    println("方法2 - 使用 sortedDescending 降序排序:")
    println("  代码: numbers.sortedDescending()")
    val descending = numbers.sortedDescending()
    println("  结果: $descending（降序排列）")
    println()

    // 方法3: 使用 sortBy 按照自定义规则排序
    println("方法3 - 使用 sortBy 按照自定义规则排序:")
    println("  代码: numbers.toList().sortBy { it % 10 }（按个位数排序）")
    val sortByMod = numbers.toList().sortBy { it % 10 }
    println("  结果: $sortByMod")
    println()

    // 方法4: 使用 sortByDescending 按照自定义规则降序排序
    println("方法4 - 使用 sortByDescending 按照自定义规则降序排序:")
    println("  代码: numbers.toList().sortByDescending { it / 10 }（按十位数降序）")
    val sortByDescMod = numbers.toList().sortByDescending { it / 10 }
    println("  结果: $sortByDescMod")
    println()

    // 方法5: 使用 sortWith 自定义比较器
    println("方法5 - 使用 sortWith 自定义比较器:")
    println("  代码: numbers.toList().sortedWith(compareBy { it % 2 })（偶数在前）")
    val sortWithComparator = numbers.toList().sortedWith(compareBy { it % 2 })
    println("  结果: $sortWithComparator")
    println()

    // 方法6: 使用 reversed 反转数组
    println("方法6 - 使用 reversed 反转数组:")
    val original = intArrayOf(1, 2, 3, 4, 5)
    println("  原始数组: ${original.contentToString()}")
    println("  代码: original.reversed()")
    val reversed = original.reversed()
    println("  结果: $reversed（反转后）")
    println()

    // 方法7: 使用 distinct 去重
    println("方法7 - 使用 distinct 去重:")
    val withDuplicates = intArrayOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
    println("  原始数组: ${withDuplicates.contentToString()}")
    println("  代码: withDuplicates.distinct()")
    val unique = withDuplicates.distinct()
    println("  结果: $unique（去重后）")
    println()
}

/**
 * 演示6: 数组切片 - 提取子数组
 *
 * 切片就是从数组中提取一部分元素
 * 可以按索引范围、按条件等方式切片
 */
fun demonstrateArraySlice() {
    println("【演示6】数组切片 - 提取子数组")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 slice 按索引范围切片
    println("方法1 - 使用 slice 按索引范围切片:")
    println("  代码: numbers.slice(2..5)")
    val sliced1 = numbers.slice(2..5)
    println("  结果: $sliced1（索引2到5的元素）")
    println()

    // 方法2: 使用 slice 按索引列表切片
    println("方法2 - 使用 slice 按索引列表切片:")
    println("  代码: numbers.slice(listOf(0, 2, 4, 6))")
    val sliced2 = numbers.slice(listOf(0, 2, 4, 6))
    println("  结果: $sliced2（指定索引的元素）")
    println()

    // 方法3: 使用 subArray 获取子数组
    println("方法3 - 使用 subArray 获取子数组:")
    println("  代码: numbers.sliceArray(1..4)")
    val subArray = numbers.sliceArray(1..4)
    println("  结果: ${subArray.contentToString()}（索引1到4的元素）")
    println()

    // 方法4: 使用 take 获取前N个元素
    println("方法4 - 使用 take 获取前N个元素:")
    println("  代码: numbers.take(4)")
    val firstFour = numbers.take(4)
    println("  结果: $firstFour（前4个元素）")
    println()

    // 方法5: 使用 takeLast 获取最后N个元素
    println("方法5 - 使用 takeLast 获取最后N个元素:")
    println("  代码: numbers.takeLast(3)")
    val lastThree = numbers.takeLast(3)
    println("  结果: $lastThree（最后3个元素）")
    println()

    // 方法6: 使用 drop 跳过前N个元素
    println("方法6 - 使用 drop 跳过前N个元素:")
    println("  代码: numbers.drop(3)")
    val skipFirst = numbers.drop(3)
    println("  结果: $skipFirst（跳过前3个元素）")
    println()

    // 方法7: 使用 dropLast 跳过最后N个元素
    println("方法7 - 使用 dropLast 跳过最后N个元素:")
    println("  代码: numbers.dropLast(2)")
    val skipLast = numbers.dropLast(2)
    println("  结果: $skipLast（跳过最后2个元素）")
    println()

    // 方法8: 使用 chunked 分块
    println("方法8 - 使用 chunked 分块:")
    println("  代码: numbers.toList().chunked(3)")
    val chunks = numbers.toList().chunked(3)
    println("  结果: $chunks（每3个元素分为一块）")
    println()
}

/**
 * 演示7: 数组聚合 - 合并和统计
 *
 * 聚合就是对数组中的所有元素进行某种合并或统计操作
 * 比如求和、求平均值、求最大值等
 */
fun demonstrateArrayAggregate() {
    println("【演示7】数组聚合 - 合并和统计")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(10, 20, 30, 40, 50)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 方法1: 使用 sum 求和
    println("方法1 - 使用 sum 求和:")
    println("  代码: numbers.sum()")
    val total = numbers.sum()
    println("  结果: $total（所有元素的和）")
    println()

    // 方法2: 使用 average 求平均值
    println("方法2 - 使用 average 求平均值:")
    println("  代码: numbers.average()")
    val avg = numbers.average()
    println("  结果: $avg（所有元素的平均值）")
    println()

    // 方法3: 使用 maxOrNull 求最大值
    println("方法3 - 使用 maxOrNull 求最大值:")
    println("  代码: numbers.maxOrNull()")
    val max = numbers.maxOrNull()
    println("  结果: $max（最大值）")
    println()

    // 方法4: 使用 minOrNull 求最小值
    println("方法4 - 使用 minOrNull 求最小值:")
    println("  代码: numbers.minOrNull()")
    val min = numbers.minOrNull()
    println("  结果: $min（最小值）")
    println()

    // 方法5: 使用 count 计数
    println("方法5 - 使用 count 计数:")
    println("  代码: numbers.count { it > 25 }")
    val count = numbers.count { it > 25 }
    println("  结果: $count（大于25的元素个数）")
    println()

    // 方法6: 使用 fold 折叠
    println("方法6 - 使用 fold 折叠:")
    println("  代码: numbers.fold(0) { acc, value -> acc + value }")
    val folded = numbers.fold(0) { acc, value -> acc + value }
    println("  结果: $folded（从0开始累加所有元素）")
    println()

    // 方法7: 使用 reduce 规约
    println("方法7 - 使用 reduce 规约:")
    println("  代码: numbers.reduce { acc, value -> acc + value }")
    val reduced = numbers.reduce { acc, value -> acc + value }
    println("  结果: $reduced（从第一个元素开始累加）")
    println()

    // 方法8: 使用 joinToString 转换为字符串
    println("方法8 - 使用 joinToString 转换为字符串:")
    println("  代码: numbers.joinToString(\", \")")
    val joined = numbers.joinToString(", ")
    println("  结果: $joined（用逗号分隔的字符串）")
    println()
}

/**
 * 演示8: 综合示例 - 链式操作
 *
 * 链式操作就是将多个数组操作连接在一起
 * 形成一个处理流程，最后得到最终结果
 */
fun demonstrateChainedOperations() {
    println("【演示8】综合示例 - 链式操作")
    println("-".repeat(60))

    // 创建一个整数数组
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("原始数组: ${numbers.contentToString()}")
    println()

    // 示例1: 过滤 -> 映射 -> 排序
    println("示例1 - 过滤 -> 映射 -> 排序:")
    println("  代码: numbers.filter { it % 2 == 0 }.map { it * it }.sortedDescending()")
    println("  说明: 1.筛选偶数 2.平方 3.降序排列")
    val result1 = numbers.filter { it % 2 == 0 }
        .map { it * it }
        .sortedDescending()
    println("  结果: $result1")
    println()

    // 示例2: 过滤 -> 求和
    println("示例2 - 过滤 -> 求和:")
    println("  代码: numbers.filter { it > 5 }.sum()")
    println("  说明: 1.筛选大于5的数 2.求和")
    val result2 = numbers.filter { it > 5 }.sum()
    println("  结果: $result2")
    println()

    // 示例3: 映射 -> 过滤 -> 计数
    println("示例3 - 映射 -> 过滤 -> 计数:")
    println("  代码: numbers.map { it * 2 }.filter { it > 10 }.count()")
    println("  说明: 1.每个数乘以2 2.筛选大于10的数 3.计数")
    val result3 = numbers.map { it * 2 }.filter { it > 10 }.count()
    println("  结果: $result3")
    println()

    // 示例4: 分组 -> 统计
    println("示例4 - 分组 -> 统计:")
    println("  代码: numbers.groupBy { it % 3 }.mapValues { it.value.size }")
    println("  说明: 1.按模3分组 2.统计每组的大小")
    val result4 = numbers.groupBy { it % 3 }.mapValues { it.value.size }
    println("  结果: $result4")
    println()

    // 示例5: 复杂链式操作
    println("示例5 - 复杂链式操作:")
    println("  代码: numbers.filter { it > 2 }")
    println("        .map { it * 10 }")
    println("        .filter { it < 80 }")
    println("        .sorted()")
    println("        .take(3)")
    println("  说明: 1.筛选>2 2.乘以10 3.筛选<80 4.排序 5.取前3个")
    val result5 = numbers.filter { it > 2 }
        .map { it * 10 }
        .filter { it < 80 }
        .sorted()
        .take(3)
    println("  结果: $result5")
    println()
}

/**
 * 演示9: 字符串数组操作
 *
 * 字符串数组的操作和整数数组类似
 * 但可以进行字符串特定的操作，比如大小写转换、字符串连接等
 */
fun demonstrateStringArrayOperations() {
    println("【演示9】字符串数组操作")
    println("-".repeat(60))

    // 创建一个字符串数组
    val words = arrayOf("apple", "banana", "cherry", "date", "elderberry")
    println("原始数组: ${words.contentToString()}")
    println()

    // 方法1: 转换为大写
    println("方法1 - 转换为大写:")
    println("  代码: words.map { it.uppercase() }")
    val uppercase = words.map { it.uppercase() }
    println("  结果: $uppercase")
    println()

    // 方法2: 转换为小写
    println("方法2 - 转换为小写:")
    println("  代码: words.map { it.lowercase() }")
    val lowercase = words.map { it.lowercase() }
    println("  结果: $lowercase")
    println()

    // 方法3: 按长度排序
    println("方法3 - 按长度排序:")
    println("  代码: words.sortBy { it.length }")
    val sortedByLength = words.sortBy { it.length }
    println("  结果: $sortedByLength")
    println()

    // 方法4: 过滤长度大于5的单词
    println("方法4 - 过滤长度大于5的单词:")
    println("  代码: words.filter { it.length > 5 }")
    val longWords = words.filter { it.length > 5 }
    println("  结果: $longWords")
    println()

    // 方法5: 获取首字母
    println("方法5 - 获取首字母:")
    println("  代码: words.map { it.first() }")
    val firstLetters = words.map { it.first() }
    println("  结果: $firstLetters")
    println()

    // 方法6: 用逗号连接字符串
    println("方法6 - 用逗号连接字符串:")
    println("  代码: words.joinToString(\", \")")
    val joined = words.joinToString(", ")
    println("  结果: $joined")
    println()

    // 方法7: 用箭头连接并添加前缀后缀
    println("方法7 - 用箭头连接并添加前缀后缀:")
    println("  代码: words.joinToString(\" -> \", \"[\", \"]\")")
    val joinedWithPrefix = words.joinToString(" -> ", "[", "]")
    println("  结果: $joinedWithPrefix")
    println()

    // 方法8: 检查是否存在某个单词
    println("方法8 - 检查是否存在某个单词:")
    println("  代码: words.any { it == \"cherry\" }")
    val hasCherry = words.any { it == "cherry" }
    println("  结果: $hasCherry（是否包含cherry）")
    println()
}

/**
 * 演示10: 实际应用示例 - 数据处理
 *
 * 展示如何使用数组操作处理实际数据
 * 比如学生成绩、商品价格等
 */
fun demonstrateRealWorldExample() {
    println("【演示10】实际应用示例 - 数据处理")
    println("-".repeat(60))

    // 学生成绩数据
    val scores = intArrayOf(85, 92, 78, 95, 88, 76, 91, 87, 93, 82)
    println("学生成绩: ${scores.contentToString()}")
    println()

    // 需求1: 计算平均分
    println("需求1 - 计算平均分:")
    println("  代码: scores.average()")
    val average = scores.average()
    println("  结果: $average")
    println()

    // 需求2: 找出及格的学生（>=60分）
    println("需求2 - 找出及格的学生（>=60分）:")
    println("  代码: scores.filter { it >= 60 }")
    val passed = scores.filter { it >= 60 }
    println("  结果: $passed（共${passed.size}个学生及格）")
    println()

    // 需求3: 找出优秀的学生（>=90分）
    println("需求3 - 找出优秀的学生（>=90分）:")
    println("  代码: scores.filter { it >= 90 }")
    val excellent = scores.filter { it >= 90 }
    println("  结果: $excellent（共${excellent.size}个学生优秀）")
    println()

    // 需求4: 统计各分数段的学生数
    println("需求4 - 统计各分数段的学生数:")
    println("  代码: scores.groupBy { when { it >= 90 -> \"优秀\" it >= 80 -> \"良好\" it >= 70 -> \"及格\" else -> \"不及格\" } }")
    val gradeDistribution = scores.groupBy {
        when {
            it >= 90 -> "优秀"
            it >= 80 -> "良好"
            it >= 70 -> "及格"
            else -> "不及格"
        }
    }
    println("  结果:")
    gradeDistribution.forEach { (grade, students) ->
        println("    $grade: ${students.size}个学生")
    }
    println()

    // 需求5: 找出最高分和最低分
    println("需求5 - 找出最高分和最低分:")
    println("  代码: scores.maxOrNull() 和 scores.minOrNull()")
    val maxScore = scores.maxOrNull()
    val minScore = scores.minOrNull()
    println("  结果: 最高分=$maxScore, 最低分=$minScore")
    println()

    // 需求6: 按分数从高到低排序
    println("需求6 - 按分数从高到低排序:")
    println("  代码: scores.sortedDescending()")
    val sorted = scores.sortedDescending()
    println("  结果: $sorted")
    println()

    // 需求7: 计算总分
    println("需求7 - 计算总分:")
    println("  代码: scores.sum()")
    val total = scores.sum()
    println("  结果: $total")
    println()

    // 需求8: 将分数提高10分（模拟加分）
    println("需求8 - 将分数提高10分（模拟加分）:")
    println("  代码: scores.map { it + 10 }")
    val boosted = scores.map { it + 10 }
    println("  结果: $boosted")
    println()
}

fun main() {
    println("========== Kotlin 数组常用操作完整演示 ==========\n")

    // 调用各个演示方法
    demonstrateArrayTraversal()
    demonstrateArrayFind()
    demonstrateArrayFilter()
    demonstrateArrayMap()
    demonstrateArraySort()
    demonstrateArraySlice()
    demonstrateArrayAggregate()
    demonstrateChainedOperations()
    demonstrateStringArrayOperations()
    demonstrateRealWorldExample()

    println("\n========== 演示结束 ==========")
}