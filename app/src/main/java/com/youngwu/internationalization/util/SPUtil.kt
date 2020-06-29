package com.youngwu.internationalization.util

import android.content.Context
import android.content.SharedPreferences

object SPUtil {
    private const val SP_NAME = "language_setting"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    fun putInt(context: Context, param: String, value: Int) {
        getSharedPreferences(context).edit().putInt(param, value).apply()
    }

    fun getInt(context: Context, param: String, default: Int): Int {
        return getSharedPreferences(context).getInt(param, default)
    }

    fun putBoolean(context: Context, param: String, value: Boolean) {
        getSharedPreferences(context).edit().putBoolean(param, value).apply()
    }

    fun getBoolean(context: Context, param: String, default: Boolean): Boolean {
        return getSharedPreferences(context).getBoolean(param, default)
    }

}