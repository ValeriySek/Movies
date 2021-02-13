package com.hfad.mymovies.core.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView : AppCompatImageView {
    private var mContext: Context
    var radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16.0f, resources.displayMetrics)

    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
    }

    override fun onDraw(canvas: Canvas) {
        val path = Path()
        val rectF = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())
        path.addRoundRect(rectF, radius, radius, Path.Direction.CW)
        canvas.clipPath(path)
        super.onDraw(canvas)
    }
}