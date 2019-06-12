package cn.artaris.androidknowledge.IntentService;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.artaris.androidknowledge.BaseActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.IntentService
 * AndroidKnowledge
 * 2019.05.14  10:46
 *
 * @author : artairs
 */
public class IntentServiceActivity2 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArtarisIntentService.start(this," 2 ");
    }

    @Override
    protected void onClick(View view) {

    }
}