package cn.artaris.androidknowledge.HandlerThread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.HandlerThread
 * AndroidKnowledge
 * 2019.05.09  10:17
 *
 * @author : artairs
 */
public class HandleThreadActivity extends AppCompatActivity {

    private HandlerThread mHandlerThread;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(HandleThreadActivity.this.getClass().getSimpleName(), Thread.currentThread().toString());
                    }
                });
            }
        });

        mHandlerThread = new HandlerThread("HandlerThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());


    }
}

