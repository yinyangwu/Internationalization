package com.youngwu.internationalization.util

import android.content.Context
import android.content.res.Configuration
import android.util.Log
import com.github.jokar.multilanguages.library.LanguageLocalListener
import com.github.jokar.multilanguages.library.MultiLanguage
import java.util.*

/**
 * @author yinyangwu
 * @date 2020/5/22 14:48
 * description:多语言管理工具类，不要改动方法中的context传参！！！
 */
object LocaleManageUtil {
    private const val TAG = "LocaleManageUtil"
    private const val PARAM_LANGUAGE_INIT = "language_init"
    private const val PARAM_LANGUAGE_SELECT = "language_select"

    private val HONG_KONG = Locale("zh", "HK")
    private val MACAU = Locale("zh", "MO")

    private lateinit var systemCurrentLocal: Locale

    private val LOCALE_TRADITION_CHINESE = Locale.TRADITIONAL_CHINESE
    private val LOCALE_SIMPLE_CHINESE = Locale.SIMPLIFIED_CHINESE
    private val LOCALE_ENGLISH = Locale.ENGLISH
    private var LOCALE_DEFAULT = LOCALE_ENGLISH

    const val LANGUAGE_TRADITION_CHINESE = "中文繁體"
    const val LANGUAGE_SIMPLE_CHINESE = "中文简体"
    const val LANGUAGE_ENGLISH = "English"
    private var LANGUAGE_DEFAULT = LANGUAGE_ENGLISH

    const val TYPE_TRADITION_CHINESE = 0
    const val TYPE_SIMPLE_CHINESE = 1
    const val TYPE_ENGLISH = 2
    var TYPE_DEFAULT = TYPE_ENGLISH

    /**
     * 初始化APP内设置的Locale方案
     */
    @JvmStatic
    fun init(listener: LanguageLocalListener) {
        MultiLanguage.init(listener)
    }

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
        Log.d(TAG, "saveSystemCurrentLanguage1:systemCurrentLocal=$systemCurrentLocal")
    }

    /**
     * 系统设置切换语言后，临时存储系统的Locale方案
     *
     * @param newConfig
     */
    @JvmStatic
    fun saveSystemCurrentLanguage(newConfig: Configuration?) {
        systemCurrentLocal = MultiLanguage.getSystemLocal(newConfig)
        Log.d(TAG, "saveSystemCurrentLanguage2:systemCurrentLocal=$systemCurrentLocal")
    }

    /**
     * 更新语言设置
     */
    @JvmStatic
    fun setLocal(context: Context): Context {
        return MultiLanguage.setLocal(context)
    }

    /**
     * 设置语言类型
     */
    @JvmStatic
    fun setApplicationLanguage(context: Context) {
        MultiLanguage.setApplicationLanguage(context)
    }

    /**
     * 监听系统语言配置方案变化
     */
    @JvmStatic
    fun onConfigurationChanged(context: Context) {
        MultiLanguage.onConfigurationChanged(context)
    }

    /**
     * 是否选择使用了中文繁体Locale配置方案
     */
    @JvmStatic
    fun isTraditionChineseLocaleType(context: Context): Boolean {
        return getSelectLanguageType(context) == TYPE_TRADITION_CHINESE
    }

    /**
     * 是否选择使用了中文简体Locale配置方案
     */
    @JvmStatic
    fun isSimpleChineseLocaleType(context: Context): Boolean {
        return getSelectLanguageType(context) == TYPE_SIMPLE_CHINESE
    }

    /**
     * 是否选择使用了英文Locale配置方案
     */
    @JvmStatic
    fun isEnglishLocaleType(context: Context): Boolean {
        return getSelectLanguageType(context) == TYPE_ENGLISH
    }

    /**
     * 获取用户在APP内选择的语言设置，Int类型
     */
    @JvmStatic
    fun getSelectLanguageType(context: Context): Int {
        return SPUtil.getInt(context, PARAM_LANGUAGE_SELECT, TYPE_DEFAULT)
    }

    /**
     * 获取用户在APP内选择的语言设置，字符串
     */
    @JvmStatic
    fun getSelectLanguageText(context: Context): String {
        saveInitLanguageType(context)
        val selectLanguageType = getSelectLanguageType(context)
        Log.d(TAG, "getSelectLanguageText:getSelectLanguageType=$selectLanguageType")
        return when (selectLanguageType) {
            TYPE_TRADITION_CHINESE -> LANGUAGE_TRADITION_CHINESE
            TYPE_SIMPLE_CHINESE -> LANGUAGE_SIMPLE_CHINESE
            TYPE_ENGLISH -> LANGUAGE_ENGLISH
            else -> LANGUAGE_DEFAULT
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
        val selectLanguageType = getSelectLanguageType(context)
        Log.d(TAG, "getSelectLanguageLocale:getSelectLanguageType=$selectLanguageType")
        return when (selectLanguageType) {
            TYPE_TRADITION_CHINESE -> LOCALE_TRADITION_CHINESE
            TYPE_SIMPLE_CHINESE -> LOCALE_SIMPLE_CHINESE
            TYPE_ENGLISH -> LOCALE_ENGLISH
            else -> LOCALE_DEFAULT
        }
    }

    /**
     * 预置初始化的语言类型，如果是从旧版本升级到多语言版本则继续保持默认语言是繁体，如果是新安装多语言版本则按系统设置的语言方案
     */
    private fun saveInitLanguageType(context: Context) {
        if (!SPUtil.getBoolean(context, PARAM_LANGUAGE_INIT, false)) {
            SPUtil.putBoolean(context, PARAM_LANGUAGE_INIT, true)
            val isFirst: Boolean = SPUtil.getBoolean(context, "isFirst", true)
            if (isFirst) {
                val language: String = systemCurrentLocal.language
                val country: String = systemCurrentLocal.country
                if ((language == LOCALE_TRADITION_CHINESE.language && country == LOCALE_TRADITION_CHINESE.country)
                    || (language == HONG_KONG.language && country == HONG_KONG.country)
                    || (language == MACAU.language && country == MACAU.country)
                ) {
                    saveSelectLanguageType(context, TYPE_TRADITION_CHINESE)
                } else if (language == LOCALE_SIMPLE_CHINESE.language && country == LOCALE_SIMPLE_CHINESE.country) {
                    saveSelectLanguageType(context, TYPE_SIMPLE_CHINESE)
                } else if (language == LOCALE_ENGLISH.language) {
                    saveSelectLanguageType(context, TYPE_ENGLISH)
                } else {
                    TYPE_DEFAULT = TYPE_ENGLISH
                    LOCALE_DEFAULT = LOCALE_ENGLISH
                    LANGUAGE_DEFAULT = LANGUAGE_ENGLISH
                    saveSelectLanguageType(context, TYPE_DEFAULT)
                }
            } else {
                TYPE_DEFAULT = TYPE_TRADITION_CHINESE
                LOCALE_DEFAULT = LOCALE_TRADITION_CHINESE
                LANGUAGE_DEFAULT = LANGUAGE_TRADITION_CHINESE
                saveSelectLanguageType(context, TYPE_DEFAULT)
            }
        }
    }

    /**
     * 将选择的语言类型存储到SharedPreference里面
     */
    @JvmStatic
    fun saveSelectLanguageType(context: Context, select: Int) {
        SPUtil.putInt(context, PARAM_LANGUAGE_SELECT, select)
    }

    /**
     * 用于区分表情包文件夹，获取当前Locale名称
     */
    @JvmStatic
    fun getCurrentLocaleName(context: Context): String {
        return when (SPUtil.getInt(context, PARAM_LANGUAGE_SELECT, TYPE_DEFAULT)) {
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
        return when (SPUtil.getInt(context, PARAM_LANGUAGE_SELECT, TYPE_DEFAULT)) {
            TYPE_TRADITION_CHINESE -> "zh-Hant"
            TYPE_SIMPLE_CHINESE -> "zh-Hans"
            TYPE_ENGLISH -> "en"
            else -> "en"
        }
    }

}