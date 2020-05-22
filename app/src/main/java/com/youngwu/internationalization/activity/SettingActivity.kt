package com.youngwu.internationalization.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.internationalization.R
import com.youngwu.internationalization.util.LocaleManageUtil
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * @author yinyangwu
 * @date 2020/5/13 14:23
 * description:设置
 */
class SettingActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        title = getString(R.string.setting)

        btn_auto.setOnClickListener(this)
        btn_Chinese_simple.setOnClickListener(this)
        btn_Chinese_traditional.setOnClickListener(this)
        btn_English.setOnClickListener(this)
        btn_finish.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) {
            return
        }
        when (v.id) {
            R.id.btn_auto -> {
                selectLanguage(0)
            }
            R.id.btn_Chinese_simple -> {
                selectLanguage(1)
            }
            R.id.btn_Chinese_traditional -> {
                selectLanguage(2)
            }
            R.id.btn_English -> {
                selectLanguage(3)
            }
            R.id.btn_finish -> {
                finish()
            }
        }
    }

    private fun selectLanguage(select: Int) {
        LocaleManageUtil.saveSelectLanguage(this, select)
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}