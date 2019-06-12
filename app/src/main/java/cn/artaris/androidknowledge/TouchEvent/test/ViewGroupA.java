package cn.artaris.androidknowledge.TouchEvent.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * cn.artaris.androidknowledge.TouchEvent.test
 * AndroidKnowledge
 * 2019.05.11  15:55
 *
 * @author : artairs
 */
public class ViewGroupA extends FrameLayout {

    public ViewGroupA(Context context) {
        super(context);
    }

    public ViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("Touch","ViewGroup A dispatchTouchEvent " + ev.getActionMasked());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("Touch","ViewGroup A onInterceptTouchEvent " + ev.getActionMasked());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("Touch","ViewGroup A onTouchEvent " + event.getActionMasked());
        return super.onTouchEvent(event);
    }
}
