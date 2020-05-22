package com.youngwu.internationalization.util

import android.content.Context
import android.content.SharedPreferences
import java.util.*

class SPUtil(context: Context) {
    private val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences("language_setting", Context.MODE_PRIVATE)
    var systemCurrentLocal: Locale = Locale.ENGLISH
    val selectLanguage: Int
        get() = mSharedPreferences.getInt(TAG_LANGUAGE, 0)

    companion object {
        private const val TAG_LANGUAGE = "language_select"

        @Volatile
        private var instance: SPUtil? = null

        fun getInstance(context: Context): SPUtil? {
            if (instance == null) {
                synchronized(SPUtil::class.java) {
                    if (instance == null) {
                        instance = SPUtil(context)
                    }
                }
            }
            return instance
        }
    }

    fun saveLanguage(select: Int) {
        val edit = mSharedPreferences.edit()
        edit.putInt(TAG_LANGUAGE, select)
        edit.apply()
    }
}