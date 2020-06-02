package com.youngwu.internationalization.util

import android.content.Context
import android.content.res.Configuration
import com.github.jokar.multilanguages.library.MultiLanguage
import com.youngwu.internationalization.R
import java.util.*

object LocaleManageUtil {
    private const val PARAM_LANGUAGE_INIT = "language_init"
    private const val PARAM_LANGUAGE_SELECT = "language_select"

    private var systemCurrentLocal: Locale = Locale.ENGLISH
    private val LOCALE_TRADITION_CHINESE = Locale.TAIWAN
    private val LOCALE_SIMPLE_CHINESE = Locale.CHINA
    private val LOCALE_ENGLISH = Locale.ENGLISH

    private val HONG_KONG = Locale("zh", "HK")
    private val MACAU = Locale("zh", "MO")

    const val TYPE_TRADITION_CHINESE = 1
    const val TYPE_SIMPLE_CHINESE = 2
    const val TYPE_ENGLISH = 3

    /**
     * 获取系统的Locale
     *
     * @return Locale对象
     */
    @JvmStatic
    fun getSystemLocale(): Locale {
        return systemCurrentLocal
    }

    /**
     * APP初始化时获取后，临时存储系统的Locale方案
     */
    @JvmStatic
    fun saveSystemCurrentLanguage(context: Context) {
        systemCurrentLocal = MultiLanguage.getSystemLocal(context)
    }

    /**
     * 系统设置切换语言后，临时存储系统的Locale方案
     *
     * @param newConfig
     */
    @JvmStatic
    fun saveSystemCurrentLanguage(newConfig: Configuration) {
        systemCurrentLocal = MultiLanguage.getSystemLocal(newConfig)
    }

    /**
     * 是否用于选择使用了中文繁体Locale配置方案
     */
    @JvmStatic
    fun isTraditionChineseLocaleType(): Boolean {
        return getSelectLanguageType() == TYPE_TRADITION_CHINESE
    }

    /**
     * 是否用于选择使用了中文简体Locale配置方案
     */
    @JvmStatic
    fun isSimpleChineseLocaleType(): Boolean {
        return getSelectLanguageType() == TYPE_SIMPLE_CHINESE
    }

    /**
     * 是否用于选择使用了英文Locale配置方案
     */
    @JvmStatic
    fun isEnglishLocaleType(): Boolean {
        return getSelectLanguageType() == TYPE_ENGLISH
    }

    /**
     * 获取用户在APP内选择的语言设置，Int类型
     */
    @JvmStatic
    fun getSelectLanguageType(): Int? {
        return SPUtil.getInt(PARAM_LANGUAGE_SELECT, TYPE_ENGLISH)
    }

    /**
     * 获取用户在APP内选择的语言设置，字符串
     */
    @JvmStatic
    fun getSelectLanguageText(context: Context): String {
        saveInitLanguageType(context)
        return when (getSelectLanguageType()) {
            TYPE_TRADITION_CHINESE -> context.getString(R.string.Chinese_traditional)
            TYPE_SIMPLE_CHINESE -> context.getString(R.string.Chinese_simple)
            TYPE_ENGLISH -> context.getString(R.string.English)
            else -> context.getString(R.string.English)
        }
    }

    /**
     * 获取用户在APP内选择的语言设置，Locale对象
     *
     * @return
     */
    @JvmStatic
    fun getSelectLanguageLocale(context: Context): Locale {
        saveInitLanguageType(context)
        return when (getSelectLanguageType()) {
            TYPE_TRADITION_CHINESE -> LOCALE_TRADITION_CHINESE
            TYPE_SIMPLE_CHINESE -> LOCALE_SIMPLE_CHINESE
            TYPE_ENGLISH -> LOCALE_ENGLISH
            else -> LOCALE_ENGLISH
        }
    }

    /**
     * 预置初始化的语言类型
     */
    private fun saveInitLanguageType(context: Context) {
        if (!SPUtil.getBoolean(PARAM_LANGUAGE_INIT, false)!!) {
            SPUtil.putBoolean(PARAM_LANGUAGE_INIT, true)
            when (systemCurrentLocal) {
                LOCALE_TRADITION_CHINESE, HONG_KONG, MACAU -> {
                    saveSelectLanguageType(context, TYPE_TRADITION_CHINESE)
                }
                LOCALE_SIMPLE_CHINESE -> {
                    saveSelectLanguageType(context, TYPE_SIMPLE_CHINESE)
                }
                LOCALE_ENGLISH -> {
                    saveSelectLanguageType(context, TYPE_ENGLISH)
                }
                else -> {
                    systemCurrentLocal = LOCALE_ENGLISH
                    saveSelectLanguageType(context, TYPE_ENGLISH)
                }
            }
        }
    }

    /**
     * 将选择的语言类型存储到SharedPreference里面
     */
    @JvmStatic
    fun saveSelectLanguageType(context: Context, select: Int) {
        SPUtil.putInt(PARAM_LANGUAGE_SELECT, select)
        MultiLanguage.setApplicationLanguage(context)
    }

    /**
     * 用于区分表情包文件夹，获取当前Locale名称
     */
    @JvmStatic
    fun getCurrentLocaleName(context: Context): String {
        return when (SPUtil.getInt(PARAM_LANGUAGE_SELECT, TYPE_ENGLISH)) {
            TYPE_TRADITION_CHINESE -> "zh-rTW"
            TYPE_SIMPLE_CHINESE -> "zh-rCN"
            TYPE_ENGLISH -> "en"
            else -> "en"
        }
    }

    /**
     * 用于传递给服务器端，获取当前Locale代码
     */
    @JvmStatic
    fun getCurrentLocaleCode(context: Context): String {
        return when (SPUtil.getInt(PARAM_LANGUAGE_SELECT, TYPE_ENGLISH)) {
            TYPE_TRADITION_CHINESE -> "zh-Hant"
            TYPE_SIMPLE_CHINESE -> "zh-Hans"
            TYPE_ENGLISH -> "en"
            else -> "en"
        }
    }

}