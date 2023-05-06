package com.chris.byteflow.tool

import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
//        assertEquals(4, 2 + 2)
        val numbers = mutableListOf(1, 2, 3).also {
            it.add(4)
            println(it)
        }
        println(numbers) // 输出：[1, 2, 3, 4]
        // 循环遍历 1 到 9 的每个数字
        // 循环遍历 1 到 9 的每个数字
        for (i in 1..9) {
            // 内循环遍历 1 到 i 的每个数字
            for (j in 1..i) {
                // 打印乘法表的每个项
                print("$j * $i = $j" * i + "\t")
            }
            // 每行输出完毕后换行
            println()
        }
    }
}