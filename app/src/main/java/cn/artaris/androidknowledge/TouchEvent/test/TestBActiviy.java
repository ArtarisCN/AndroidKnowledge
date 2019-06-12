package cn.artaris.androidknowledge.TouchEvent.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.artaris.androidknowledge.BaseActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.TouchEvent.test
 * AndroidKnowledge
 * 2019.05.15  18:25
 *
 * @author : artairs
 */
public class TestBActiviy extends BaseActivity {

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_touch_test);

        view = findViewById(R.id.view);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setTranslationX(300);
            }
        });
    }

    @Override
    protected void onClick(View view) {

    }
}
