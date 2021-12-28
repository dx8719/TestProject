package com.dx.baselib.utils

import android.util.Log

import com.dx.baselib.BuildConfig

/**
 * @Description: UIBase日志打印工具类
 * @Author: wanglyGithub
 * @CreateDate: 2020/9/2 14:15
 * @Version: 2.0
 */
object UILogUtil {

    @JvmStatic
    fun d(tag: String = "UILogUtil", message: String) {
        if (BuildConfig.enableLog) {
            Log.d(tag, message)
        }
    }

    @JvmStatic
    fun i(tag: String = "UILogUtil", message: String) {
        if (BuildConfig.enableLog) {
            Log.i(tag, message)
        }
    }

    @JvmStatic
    fun e(tag: String = "UILogUtil", message: String) {
        if (BuildConfig.enableLog) {
            Log.e(tag, message)
        }
    }
}
