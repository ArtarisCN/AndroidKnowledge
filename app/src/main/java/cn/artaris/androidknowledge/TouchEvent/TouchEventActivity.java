package cn.artaris.androidknowledge.TouchEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge
 * AndroidKnowledge
 * 2019.05.09  21:39
 *
 * @author : artairs
 */
public class TouchEventActivity  extends AppCompatActivity {

    TouchViewGroup mTouchViewGroup ;
    View mTouchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

//        TransitionManager.beginDelayedTransition(findViewById(android.R.id.root));

//        mTouchViewGroup = findViewById(R.id.view_group);
        mTouchView = findViewById(R.id.view);
//        mTouchView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(TouchEventActivity.this,"On View Touched",Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });
//        mTouchView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TouchEventActivity.this,"On View Touched",Toast.LENGTH_LONG).show();
//            }
//        });


    }
}
