package com.youngwu.kotlin.application

import android.app.Application
import android.content.Context

/**
 * @author yinyangwu
 * @date 2020/5/21 11:11
 * description:
 */
class KotlinApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }
}