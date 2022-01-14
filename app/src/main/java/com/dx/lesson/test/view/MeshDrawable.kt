package drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.core.graphics.toColorInt
import com.dx.baselib.utils.extend.dp


/**
 *Created By dx on 2022/1/10 17 39
 */
class MeshDrawable : Drawable() {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val DASH_SPACING = 50f.dp

    init {
//        paint.color = "#F9A825".toColorInt() ?为何
        paint.color = Color.parseColor("#F9A825")
    }

    override fun draw(canvas: Canvas) {
        var x = bounds.left.toFloat()
        while (x <= bounds.right) {
            canvas.drawLine(
                x,
                bounds.top.toFloat(),
                x,
                bounds.bottom.toFloat(), paint
            )
            x += DASH_SPACING
        }

        var y = bounds.top.toFloat()
        while (x <= bounds.bottom) {
            canvas.drawLine(
                x,
                y,
                x,
                y, paint
            )
            y += DASH_SPACING
        }

    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0 -> PixelFormat.TRANSPARENT
            0xff -> PixelFormat.OPAQUE
            else -> PixelFormat.TRANSLUCENT

        }
    }
}