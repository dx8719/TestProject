package com.dx.lesson.test.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.core.view.children
import androidx.core.view.forEachIndexed

/**
 *Created By dx on 2022/1/11 17 27
 * 自定义layout
 */
class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    val childrenBonds = listOf<Rect>()

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for ((index, child) in children.withIndex()) {


            if (indexOfChild(child) == 0) {
                child.layout(0, 0, (r - l) / 2, (b - t) / 2)
            } else {
                child.layout((r - l) / 2, (b - t) / 2, r - l, b - t)
            }

        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        var widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        for ((index, child) in children.withIndex()) {
            var layoutParam = child.layoutParams //开发者的意见
            val childBonds = childrenBonds.get(index)
            child.layout(childBonds.left, childBonds.top, childBonds.right, childBonds.bottom)
        }

    }
}