package com.youngwu.internationalization.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.internationalization.R
import com.youngwu.internationalization.application.KotlinApplication
import com.youngwu.internationalization.service.MyIntentService
import com.youngwu.internationalization.service.MyService
import com.youngwu.internationalization.util.LocaleManageUtil
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author yinyangwu
 * @date 2020/5/13 14:27
 * description:首页
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.home_index)

        initData()
        setListener()
    }

    private fun initData() {
        tv_system_language.text = getString(
            R.string.system_language,
            LocaleManageUtil.getSystemLocale().toLanguageTag()
        )
        tv_user_select_language.text = getString(
            R.string.user_select_language,
            LocaleManageUtil.getSelectLanguageLocale(this).toLanguageTag()
        )
        tv_set_text_by_code1.text = getString(R.string.set_text_by_code)
        tv_set_text_by_code2.text = applicationContext.getString(R.string.set_text_by_code)
        tv_set_text_by_code3.text = KotlinApplication.application.getString(R.string.set_text_by_code)
        tv_set_text_by_code4.text = KotlinApplication.application.applicationContext.getString(R.string.set_text_by_code)
    }

    private fun setListener() {
        btn_multi_language.setOnClickListener(this)
        btn_start_service.setOnClickListener(this)
        btn_start_intent_service.setOnClickListener(this)
        btn_show_dialog.setOnClickListener(this)
        btn_setting.setOnClickListener(this)
        btn_finish.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == null) {
            return
        }
        when (v.id) {
            R.id.btn_multi_language -> {
                val intent = Intent(this, MultiLanguageActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_start_service -> {
                val intent = Intent(this, MyService::class.java)
                startService(intent)
            }
            R.id.btn_start_intent_service -> {
                val intent = Intent(this, MyIntentService::class.java)
                startService(intent)
            }
            R.id.btn_show_dialog -> {
                val builder = AlertDialog.Builder(this)
                builder.setPositiveButton(
                    getString(R.string.ok),
                    object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            dialog?.dismiss()
                        }
                    })
                builder.setNegativeButton(
                    R.string.cancel,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            dialog?.dismiss()
                        }
                    })
                builder.create().show()
            }
            R.id.btn_setting -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_finish -> {
                finish()
            }
        }
    }

}