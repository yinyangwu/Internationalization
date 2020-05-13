package com.youngwu.kotlin.demo

/**
 * @author yinyangwu
 * @date 2020/5/7 15:37
 * description:
 */
fun main(args: Array<String>) {
    val a: Int = 10000
    println(a === a)

    val b: Int? = a
    val c: Int? = a

    println(b === a)
    println(c === a)
    println(b === c)
    println(b == c)
}