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
 * 2019.05.11  16:00
 *
 * @author : artairs
 */
public class ViewC extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ViewC(Context context) {
        super(context);
    }

    public ViewC(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","View C  onTouchEvent " + event.getActionMasked());
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(25);
        canvas.drawText("ViewC",0,100,mPaint);
        canvas.drawColor(Color.parseColor("#999999"));
    }
}
