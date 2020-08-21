package com.hfad.mymovies.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.Nullable;

public class CustomImageView extends androidx.appcompat.widget.AppCompatImageView {

    private Context mContext;

    public float radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16.0f, getResources().getDisplayMetrics());

    public CustomImageView(Context context) {
        super(context);
        mContext = context;
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        Path path = new Path();
        RectF rectF = new RectF(0, 0, this.getWidth(), this.getHeight());
        path.addRoundRect(rectF, radius, radius, Path.Direction.CW);
        canvas.clipPath(path);

        super.onDraw(canvas);
    }
}
