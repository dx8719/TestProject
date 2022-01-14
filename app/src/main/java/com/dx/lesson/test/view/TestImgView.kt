package com.dx.lesson.test.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import com.dx.baselib.utils.extend.dp

/**
 *Created By dx on 2022/1/11 16 33
 */
class TestImgView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs) {

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, (l + 100.dp).toInt(), (t + 100.dp).toInt())
    }

}