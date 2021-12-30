package com.dx.baselib.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue

/**
 *Created By dx on 2021/12/29 17 06
 */
public class UiUitl {
    val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
    }

}