package com.dx.lesson.test.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.dx.baselib.utils.extend.dp
import com.dx.lesson.R

/**
 *Created By dx on 2022/1/11 11 13
 */
class MaterialEditText(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val TEXT_SIZE = 12.dp
    private val TEXT_MARGIN = 8.dp
    private val HORIZONTAIL_OFFSET = 5.dp
    private val VERTICAL_OFFSET = 23.dp
    private val EXTRA_VERTICAL_OFFSET = 16.dp
    private var floatingLabelShown = false

    private val animator by lazy { ObjectAnimator.ofFloat(this, "floatingLabelFraction", 1f) }

    var useFloatingLabel = false
        set(value) {
            if (field != value) {
                field = value
                if (field) {
                    setPadding(
                        paddingLeft,
                        (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom
                    )
                } else {
                    setPadding(
                        paddingLeft,
                        (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom
                    )
                }
            }


        }

    var floatingLabelFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.apply {
            textSize = TEXT_SIZE
        }

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText)
        useFloatingLabel =
            typedArray.getBoolean(R.styleable.MaterialEditText_userFloatingLabel, true)
        typedArray.recycle()
//        if (useFloatingLabel) {
//            setPadding(
//                paddingLeft,
//                (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom
//            )
//        } else {
//            setPadding(
//                paddingLeft,
//                (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight, paddingBottom
//            )
//        }
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (floatingLabelShown && text.isNullOrEmpty()) {
            floatingLabelShown = false
            animator.reverse() //反向播放
        } else if (!floatingLabelShown && !text.isNullOrEmpty()) {
            floatingLabelShown = true
            animator.start()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue =
            VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1 - floatingLabelFraction)
        canvas.drawText(hint as String, HORIZONTAIL_OFFSET, currentVerticalValue, paint)

    }


}