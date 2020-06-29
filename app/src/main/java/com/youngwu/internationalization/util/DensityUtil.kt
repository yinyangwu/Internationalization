package com.youngwu.internationalization.util

import android.content.Context

/**
 * @author yinyangwu
 * @date 2020/6/29 11:21
 * description:
 */
object DensityUtil {

    fun dip2px(context: Context, dpValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    fun getDisplayHeight(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    fun getDisplayWidth(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }
}