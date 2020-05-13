package com.youngwu.kotlin.demo

/**
 * @author yinyangwu
 * @date 2020/5/7 15:36
 * description:
 */
fun main() {
    val a = arrayOf(1, 2, 3)
    println(a)
    val b = Array(3) { i -> (i * 2) }
    println(b)

    println(a[0])
    println(b[1])

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]
    println(x[0])

    val str = """122223343
        |2eewewewedwewed
    """.trimMargin()
    println(str)

    val s1 = "12"
    val s2 = "new number is $s1"
    println(s2)

    val t1 = "12"
    val t2 = "new number is ${t1.length}"
    println(t2)

    val price = """
        ${'$'}9.99
    """.trimIndent()
    println(price)

    val v1 = 100
    val v2 = 200
    var max = v1
    if (v1 < v2) {
        max = v2
    }
    println(max)

    var max1: Int
    if (v1 > v2) {
        max1 = v1
    } else {
        max1 = v2
    }
    println(max1)

    var max2 = if (v1 > v2) v1 else v2
    println(max2)

    var max3 = if (v1 > v2) {
        println(v1)
        v1
    } else {
        println(v2)
        v2
    }
    println(max3)

    val p1 = 10
    if (p1 in 1..100) {
        println("p1 is in the range.")
    }

    when(p1){
        1-> println("p1 = 1")
        2-> println("p1 = 2")
        else -> {
            println("p1 != 1 && p1 != 2")
        }
    }

    when(p1){
        1,2 -> println("p1 = 1 or p1 = 2")
        else -> println("otherwise")
    }
}

class ThreeKotlin {
    private val a: Byte = 1
    val b: Int = a.toInt()

    val l = 10L + 1

    fun check(a: Char): Int? {
        if (a == '1') {
            return a.toInt() - '0'.toInt()
        }
        return null
    }
}