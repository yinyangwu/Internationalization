package com.youngwu.internationalization.util

import android.content.Context
import android.content.res.Configuration
import com.github.jokar.multilanguages.library.MultiLanguage
import com.youngwu.internationalization.R
import com.youngwu.internationalization.util.SPUtil.Companion.getInstance
import java.util.*

object LocaleManageUtil {
    /**
     * 获取系统的locale
     *
     * @return Locale对象
     */
    fun getSystemLocale(context: Context?): Locale {
        return getInstance(context!!)!!.systemCurrentLocal
    }

    fun getSelectLanguage(context: Context): String {
        return when (getInstance(context)!!.selectLanguage) {
            0 -> context.getString(R.string.auto)
            1 -> context.getString(R.string.Chinese_simple)
            2 -> context.getString(R.string.Chinese_traditional)
            3 -> context.getString(R.string.English)
            else -> context.getString(R.string.English)
        }
    }

    /**
     * 获取选择的语言设置
     *
     * @param context
     * @return
     */
    fun getSetLanguageLocale(context: Context?): Locale {
        return when (getInstance(context!!)!!.selectLanguage) {
            0 -> getSystemLocale(context)
            1 -> Locale.CHINA
            2 -> Locale.TAIWAN
            3 -> Locale.ENGLISH
            else -> Locale.ENGLISH
        }
    }

    fun saveSystemCurrentLanguage(context: Context?) {
        getInstance(context!!)!!.systemCurrentLocal = MultiLanguage.getSystemLocal(context)
    }

    /**
     * 保存系统语言
     *
     * @param context
     * @param newConfig
     */
    fun saveSystemCurrentLanguage(context: Context?, newConfig: Configuration?) {
        getInstance(context!!)!!.systemCurrentLocal = MultiLanguage.getSystemLocal(newConfig)
    }

    fun saveSelectLanguage(context: Context?, select: Int) {
        getInstance(context!!)!!.saveLanguage(select)
        MultiLanguage.setApplicationLanguage(context)
    }
}