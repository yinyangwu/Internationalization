package com.youngwu.internationalization.application

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.github.jokar.multilanguages.library.MultiLanguage
import com.youngwu.internationalization.util.LocaleManageUtil
import com.youngwu.internationalization.util.SPUtil

/**
 * @author yinyangwu
 * @date 2020/5/21 11:11
 * description:
 */
class KotlinApplication : Application() {

    override fun attachBaseContext(base: Context) {
        LocaleManageUtil.saveSystemCurrentLanguage(base)
        super.attachBaseContext(MultiLanguage.setLocal(base))
    }

    override fun onCreate() {
        super.onCreate()
        SPUtil.init(this)
        MultiLanguage.init { LocaleManageUtil.getSelectLanguageLocale(it) }
        MultiLanguage.setApplicationLanguage(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManageUtil.saveSystemCurrentLanguage(newConfig)
        MultiLanguage.onConfigurationChanged(applicationContext)
    }
}