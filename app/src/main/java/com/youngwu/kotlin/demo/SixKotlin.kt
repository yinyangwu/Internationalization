package com.youngwu.kotlin.demo

import java.util.*

/**
 * @author yinyangwu
 * @date 2020/5/9 09:48
 * description:
 */
class SixKotlin {
    var lastName: String = "zhang"
        get() = field.toUpperCase(Locale.getDefault())
        set

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
    var height: Float = 154.4f
        private set
}

fun main() {
    var sixKotlin:SixKotlin= SixKotlin()

    sixKotlin.lastName="wang"

    println("lastName:${sixKotlin.lastName}")

    sixKotlin.no=9
    println("no:${sixKotlin.no}")

    sixKotlin.no=20
    println("no:${sixKotlin.no}")

}