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
    val ANGEL = 30f
    val camera: Camera = Camera()

    init {

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //翻折效果
        canvas.save()
        canvas.translate(
            width / 2 + IMG_PADDING,
            height / 2 + IMG_PADDING,
        )
        camera.applyToCanvas(canvas)
        camera.rotateX(ANGEL)
        canvas.translate(
            -(width / 2 + IMG_PADDING),
            -(height / 2 + IMG_PADDING)
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