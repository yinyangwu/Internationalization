package com.youngwu.kotlin.demo

/**
 * @author yinyangwu
 * @date 2020/5/9 10:25
 * description:
 */
 class SevenKotlin {
    open fun f() {}
}

abstract class Desired  {
    open fun f(){}
}

class NineKotlin : Desired(){
    override fun f() {
        super.f()
    }
}