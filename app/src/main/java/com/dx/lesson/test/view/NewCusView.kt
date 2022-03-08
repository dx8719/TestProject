package com.dx.lesson.test.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.withSave
import com.dx.baselib.utils.extend.dp
import com.dx.lesson.R

/**
 *Created By dx on 2022/1/14 16 22
 */
class NewCusView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val IMG_WIDTH = 200.dp
    val IMG_PADDING = 50.dp
    val bitmap = getAvatar(IMG_WIDTH.toInt())
    val camera: Camera = Camera()
    var ANGEL = 0f
        set(value) {
            field = value
            invalidate()
        }

    init {
        camera.setLocation(0f,0f,-6*resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //翻折效果:上半部分
        canvas.save()
        canvas.translate(
            IMG_WIDTH / 2 + IMG_PADDING,
            IMG_WIDTH / 2 + IMG_PADDING,
        )
        canvas.translate(
            -(IMG_WIDTH / 2 + IMG_PADDING),
            -(IMG_WIDTH / 2 + IMG_PADDING)
        )

        canvas.clipRect(
            IMG_PADDING,
            IMG_PADDING,
            IMG_PADDING + IMG_WIDTH,
            IMG_PADDING + IMG_WIDTH / 2
        )

        canvas.drawBitmap(
            bitmap,
            IMG_PADDING,
            IMG_PADDING,
            paint
        )
        canvas.restore()


        //翻折效果:下半部分
        canvas.save()
        canvas.translate(
            IMG_WIDTH / 2 + IMG_PADDING,
            IMG_WIDTH / 2 + IMG_PADDING,
        )
        camera.save()
        camera.rotateX(ANGEL)
        camera.applyToCanvas(canvas)
        camera.restore()

        canvas.translate(
            -(IMG_WIDTH / 2 + IMG_PADDING),
            -(IMG_WIDTH / 2 + IMG_PADDING)
        )

        canvas.clipRect(
            IMG_PADDING,
            IMG_PADDING + IMG_WIDTH / 2,
            IMG_PADDING + IMG_WIDTH,
            IMG_PADDING + IMG_WIDTH
        )

        canvas.drawBitmap(
            bitmap,
            IMG_PADDING,
            IMG_PADDING,
            paint
        )
        canvas.restore()

    }

    //优化的获取bitmap方式
    private fun getAvatar(width: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.mipmap.avatar, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.mipmap.avatar, options)
    }
}