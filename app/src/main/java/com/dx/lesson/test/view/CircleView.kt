package com.dx.lesson.test.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_UP
import android.view.View
import com.dx.baselib.utils.extend.dp

/**
 *Created By dx on 2022/1/11 16 52
 */
class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS: Float = 100.dp
    private val PADDING: Float = 100.dp

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = (PADDING + RADIUS) * 2


        /**
         * 这部分代码就是resolveSize方法做的事 -修正size
        var specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        var specWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        var width = when (specWidthMode) {
        MeasureSpec.EXACTLY -> specWidthSize // 死要求就按要求
        MeasureSpec.AT_MOST -> if (size > specWidthSize) specWidthSize else size  //有上限，比上限大就用上限
        MeasureSpec.UNSPECIFIED -> size  //未指定 ，用自己的
        else -> size
        }
         **/
        val width = resolveSize(size.toInt(), widthMeasureSpec)
        val height = resolveSize(size.toInt(), heightMeasureSpec)
        setMeasuredDimension(width, height)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }


    //触摸事件测试
    override fun onTouchEvent(event: MotionEvent): Boolean {
        /**
        MotionEvent.ACTION_UP
        MotionEvent.ACTION_DOWN
        MotionEvent.ACTION_CANCEL
        MotionEvent.ACTION_MOVE

        MotionEvent.ACTION_POINTER_DOWN //非第一根手指按下
        MotionEvent.ACTION_POINTER_UP   //非第最有一根手指抬起
         */

        //actionMasked是单独的信息 更准确 不用event.action来判断
//        if (event.actionMasked == ACTION_UP) {
//            performClick()
//        }
//        return true
//        parent.requestDisallowInterceptTouchEvent()// 在事件序列过程中禁止父布局抢占事件
        //TODO true/false 是一个所有权标记！，只在down事件宣告所有权 在down以外的类型返回true/false无效果 表示我要消费这个事件及其后的事件序列！ 不会向下传递了
        //down要了就要了 不要的话这个事件序列就永远不要了
        return  super.onTouchEvent(event)
    }


}