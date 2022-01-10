package com.dx.lesson.test.view

import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.dx.baselib.utils.extend.dp

/**
 *Created By dx on 2022/1/10 15 09
 */
var provinces = listOf(
    "A",
    "AB",
    "ABCABC",
    "A",
    "AAABCA",
    "BBB",
    "CCABC",
    "DDD",
    "CCC",
    "XXX",
    "DJALWKDJWL",
    "WKADJLWA",
    "ABC"
)

class ProvinceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 80f.dp
        textAlign = Paint.Align.CENTER
    }

    var province = "A"
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(province, width / 2f, height / 2f, paint)
    }

    class ProvinceEvaluator : TypeEvaluator<String> {
        override fun evaluate(fraction: Float, startValue: String?, endValue: String?): String {
            val startIndex = provinces.indexOf(startValue)
            val endIndex = provinces.indexOf(endValue)
            return provinces[(startIndex + (endIndex - startIndex) * fraction).toInt()]
        }
    }
}

