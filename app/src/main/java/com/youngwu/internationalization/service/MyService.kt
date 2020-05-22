package com.youngwu.internationalization.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * @author yinyangwu
 * @date 2020/5/22 10:19
 * description:
 */
class MyService: Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}