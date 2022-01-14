package com.dx.lesson.test.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import com.dx.baselib.utils.extend.dp

/**
 *Created By dx on 2022/1/10 17 27
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val drawable = ColorDrawable(Color.RED)
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        drawable.setBounds(50f.dp.toInt(), 50f.dp.toInt(), width, height)
        drawable.draw(canvas)
    }
}