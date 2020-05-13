package com.youngwu.kotlin.demo

/**
 * @author yinyangwu
 * @date 2020/5/7 15:52
 * description:
 */
class Test {
    var v = "成员属性"

    fun setTestInterface(test: TestInterface) {
        test.test()
    }
}

interface TestInterface {
    fun test()
}

fun main() {
    val test: Test = Test();

    test.setTestInterface(object : TestInterface {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}