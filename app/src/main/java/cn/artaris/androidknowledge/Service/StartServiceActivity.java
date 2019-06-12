package cn.artaris.androidknowledge.Service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import cn.artaris.androidknowledge.BaseActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.Service
 * AndroidKnowledge
 * 2019.05.14  11:52
 *
 * @author : artairs
 */
public class StartServiceActivity extends BaseActivity {

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("StartServiceActivity","onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("StartServiceActivity","onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServiceActivity.this,DemoService.class);
                startService(intent);
            }
        });

        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServiceActivity.this,DemoService.class);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(mServiceConnection);
            }
        });

        findViewById(R.id.foreground_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServiceActivity.this,DemoForegroundService.class);
                startService(intent);
//                Intent intent = new Intent(StartServiceActivity.this,DemoForegroundService.class);
//                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });



    }

    @Override
    protected void onClick(View view) {

    }
}
