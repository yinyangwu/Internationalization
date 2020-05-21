package com.youngwu.kotlin.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.kotlin.demo.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author yinyangwu
 * @date 2020/5/13 14:23
 * description:
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFinish.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        finish()
    }
}