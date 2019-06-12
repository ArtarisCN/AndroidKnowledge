package cn.artaris.androidknowledge.IntentService;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import cn.artaris.androidknowledge.BaseActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.IntentService
 * AndroidKnowledge
 * 2019.05.06  17:38
 *
 * @author : artairs
 */
public class IntentServiceActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArtarisIntentService.start(this," 1 ");
    }


    public void onClick(View view){
        startActivity(new Intent(this,IntentServiceActivity2.class));
    }
}
