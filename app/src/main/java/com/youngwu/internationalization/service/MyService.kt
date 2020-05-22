package com.youngwu.internationalization.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.youngwu.internationalization.R

/**
 * @author yinyangwu
 * @date 2020/5/22 10:19
 * description:
 */
class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, getString(R.string.service_create), Toast.LENGTH_SHORT)
            .show()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}