package com.youngwu.internationalization.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.youngwu.internationalization.R
import com.youngwu.internationalization.application.MyApp
import com.youngwu.internationalization.util.DensityUtil
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

        val info = StringBuilder()
        info.append("dip2px:50dip=${DensityUtil.dip2px(MyApp.getContext(), 50f)}px")
        info.append("\n")
        info.append("px2dip:50px=${DensityUtil.px2dip(MyApp.getContext(), 50f)}dip")
        info.append("\n")
        info.append("px2sp:50px=${DensityUtil.px2sp(MyApp.getContext(), 50f)}sp")
        info.append("\n")
        info.append("sp2px:50sp=${DensityUtil.sp2px(MyApp.getContext(), 50f)}px")
        info.append("\n")
        info.append("getDisplayHeight=${DensityUtil.getDisplayHeight(MyApp.getContext())}px")
        info.append("\n")
        info.append("getDisplayWidth=${DensityUtil.getDisplayWidth(MyApp.getContext())}px")
        tv_info.text = info.toString()

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