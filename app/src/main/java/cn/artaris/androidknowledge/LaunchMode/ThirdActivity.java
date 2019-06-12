package cn.artaris.androidknowledge.LaunchMode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.LaunchMode
 * AndroidKnowledge
 * 2019.05.08  18:00
 *
 * @author : artairs
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
        getSupportActionBar().setTitle(getClass().getSimpleName());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
