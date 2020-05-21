package com.youngwu.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @author yinyangwu
 * @date 2020/5/13 14:27
 * description:
 */
class SplashActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        btnGoToMainActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}