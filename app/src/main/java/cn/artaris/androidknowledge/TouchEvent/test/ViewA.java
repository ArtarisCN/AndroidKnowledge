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
 * 2019.05.15  18:32
 *
 * @author : artairs
 */
public class ViewA extends View {
    public ViewA(Context context) {
        super(context);
    }

    public ViewA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            Log.d("Touch", "x = " + ev.getX() + " y = " + ev.getY());
        }
        return true;
    }


    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(25);
        canvas.drawText("ViewA",0,100,mPaint);
        canvas.drawColor(Color.parseColor("#333333"));
    }
}
