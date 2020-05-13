package com.youngwu.kotlin.demo

/**
 * @author yinyangwu
 * @date 2020/5/7 10:23
 * description:
 */

fun main(args: Array<String>) {
    val firstKotlin = FirstKotlin()
    firstKotlin.vars(1, 2, 3, 4)

    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))

    val a: Int = 1
    val b = 1
    val c: Int
    c = 1

    var d: Int = 1;
    var x = 1
    x += 2

    var y = 1
    val s1 = "y is $y"

    y = 2
    val s2 = "${s1.replace("is", "was")}, but now is $y"

    var age: String? = "23"
    val ages = age!!.toInt()
    val age1 = age?.toInt()
    val age2 = age?.toInt() ?: -1

    if (args.size < 2) {
        println("Two integers expected")
        return
    }
    val f1 = firstKotlin.parseInt(args[0])
    val f2 = firstKotlin.parseInt(args[1])

    if (f1 != null && f2 != null) {
        println(f1 * f2)
    }

    FirstKotlin.sum(1, 2)
}

class FirstKotlin {

    companion object {
        fun sum(a: Int, b: Int): Int {
            return a + b
        }
    }

    fun sum1(a: Int, b: Int): Int {
        return a + b;
    }

    fun sum2(a: Int, b: Int) = a + b

    public fun sum3(a: Int, b: Int): Int = a + b

    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

    public fun printSum1(a: Int, b: Int) {
        print(a + b)
    }

    fun vars(vararg v: Int) {
        for (vt in v) {
            print(vt)
        }
    }

    fun parseInt(str: String): Int? {
        return str.toInt()
    }

    fun getStringLength1(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) {
            return null
        }
        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

    fun test() {
        for (i in 1..4) {
            print(i)
        }

        for (i in 1..4) print(i)

        for (i in 1 downTo 2) print(i)

        for (i in 1 until 5) print(i)

        for (i in 1..4 step 2) print(i)
    }

}