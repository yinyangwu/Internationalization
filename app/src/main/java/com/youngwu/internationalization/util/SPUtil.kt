package com.youngwu.internationalization.util

import android.content.Context
import android.content.SharedPreferences

object SPUtil {
    private const val SP_NAME = "language_setting"
    private lateinit var context: Context
    private lateinit var mSharedPreferences: SharedPreferences

    fun init(context: Context) {
        this.context = context
        mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    fun putInt(param: String, value: Int) {
        mSharedPreferences.edit().putInt(param, value).apply()
    }

    fun getInt(param: String, default: Int): Int? {
        return mSharedPreferences.getInt(param, default)
    }

    fun putBoolean(param: String, value: Boolean) {
        mSharedPreferences.edit().putBoolean(param, value).apply()
    }

    fun getBoolean(param: String, default: Boolean): Boolean? {
        return mSharedPreferences.getBoolean(param, default)
    }

}