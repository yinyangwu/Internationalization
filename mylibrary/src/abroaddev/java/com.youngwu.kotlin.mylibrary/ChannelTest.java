package com.youngwu.kotlin.mylibrary;

import android.content.Context;

/**
 * @author yinyangwu
 * @date 2020/7/7 10:08
 * description:
 */
public class ChannelTest {

    public static String getTestContent(Context context) {
        return "ChannelTest：" + context.getString(R.string.channel_name);
    }
}
