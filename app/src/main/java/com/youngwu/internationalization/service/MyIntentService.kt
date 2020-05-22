package com.youngwu.internationalization.service

import android.app.IntentService
import android.content.Intent
import android.widget.Toast
import com.youngwu.internationalization.R

/**
 * @author yinyangwu
 * @date 2020/5/22 10:21
 * description:
 */
class MyIntentService(name: String = "MyIntentService") : IntentService(name) {

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(
            applicationContext,
            getString(R.string.intent_service_create),
            Toast.LENGTH_SHORT
        )
            .show()
    }

    override fun onHandleIntent(intent: Intent?) {

    }
}