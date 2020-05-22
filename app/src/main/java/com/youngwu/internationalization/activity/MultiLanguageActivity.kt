package com.youngwu.internationalization.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.internationalization.R
import kotlinx.android.synthetic.main.activity_multi_language.*

/**
 * @author yinyangwu
 * @date 2020/5/22 10:22
 * description:多语言
 */
class MultiLanguageActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_language)
        title = getString(R.string.multi_language)

        btn_finish.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) {
            return
        }
        when (v.id) {
            R.id.btn_finish -> {
                finish()
            }
        }
    }

}