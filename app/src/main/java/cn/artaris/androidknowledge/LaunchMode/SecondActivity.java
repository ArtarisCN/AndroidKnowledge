package cn.artaris.androidknowledge.LaunchMode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.LaunchMode
 * AndroidKnowledge
 * 2019.05.08  17:59
 *
 * @author : artairs
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        getSupportActionBar().setTitle(getClass().getSimpleName());
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
            }
        });
    }
}
