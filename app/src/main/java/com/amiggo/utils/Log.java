package com.amiggo.utils;

import com.amiggo.BuildConfig;

public class Log {

    public static final boolean SHOW_LOG = BuildConfig.showLog;

    public static void v(String key, String value) {
        if (SHOW_LOG) {
            android.util.Log.v(key, value);
        }
    }
}
