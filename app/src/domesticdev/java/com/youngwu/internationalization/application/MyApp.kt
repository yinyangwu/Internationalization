package com.youngwu.internationalization.application

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import com.github.jokar.multilanguages.library.LanguageLocalListener
import com.youngwu.internationalization.R
import com.youngwu.internationalization.util.LocaleManageUtil
import com.youngwu.kotlin.mylibrary.ChannelTest
import com.youngwu.kotlin.mylibrary.MyTest

/**
 * @author yinyangwu
 * @date 2020/5/21 11:11
 * description:
 */
class MyApp : Application() {

    companion object {
        lateinit var application: Application

        fun getContext(): Application {
            return application
        }
    }

    override fun attachBaseContext(base: Context) {
        LocaleManageUtil.saveSystemCurrentLanguage(base)
        LocaleManageUtil.init(listener = LanguageLocalListener {
            LocaleManageUtil.getSelectLanguageLocale(
                it
            )
        })
        super.attachBaseContext(LocaleManageUtil.setLocal(base))
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        LocaleManageUtil.setApplicationLanguage(this)
        Toast.makeText(
            this,
            "3 " + getString(R.string.test_name) + " " + MyTest.getTestContent() + " " +
                    ChannelTest.getTestContent(this),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManageUtil.saveSystemCurrentLanguage(newConfig)
        LocaleManageUtil.onConfigurationChanged(applicationContext)
    }
}