package cn.artaris.androidknowledge;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * cn.artaris.androidknowledge
 * AndroidKnowledge
 * 2019.05.14  11:31
 *
 * @author : artairs
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(this.getClass().getSimpleName());
    }

    protected abstract void onClick(View view);

}
