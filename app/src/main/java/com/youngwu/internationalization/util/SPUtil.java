package com.youngwu.internationalization.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

public class SPUtil {
    private static final String TAG_LANGUAGE = "language_select";
    private static volatile SPUtil instance;
    private final SharedPreferences mSharedPreferences;
    private Locale systemCurrentLocal = Locale.ENGLISH;

    public SPUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences("language_setting", Context.MODE_PRIVATE);
    }

    public static SPUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (SPUtil.class) {
                if (instance == null) {
                    instance = new SPUtil(context);
                }
            }
        }
        return instance;
    }

    public void saveLanguage(int select) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putInt(TAG_LANGUAGE, select);
        edit.apply();
    }

    public int getSelectLanguage() {
        return mSharedPreferences.getInt(TAG_LANGUAGE, 0);
    }

    public Locale getSystemCurrentLocal() {
        return systemCurrentLocal;
    }

    public void setSystemCurrentLocal(Locale local) {
        systemCurrentLocal = local;
    }

}
