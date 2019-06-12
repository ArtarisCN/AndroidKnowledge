package cn.artaris.androidknowledge.TouchEvent.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * cn.artaris.androidknowledge.TouchEvent.test
 * AndroidKnowledge
 * 2019.05.11  15:57
 *
 * @author : artairs
 */
public class ViewB extends View {

    public ViewB(Context context) {
        super(context);
    }

    public ViewB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","View B  onTouchEvent " + event.getActionMasked());
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(25);
        canvas.drawText("ViewB",0,100,mPaint);
        canvas.drawColor(Color.parseColor("#666666"));
    }
}
