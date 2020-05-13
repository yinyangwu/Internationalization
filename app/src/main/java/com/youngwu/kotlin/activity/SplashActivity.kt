package com.youngwu.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.kotlin.demo.R

/**
 * @author yinyangwu
 * @date 2020/5/13 14:27
 * description:
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}