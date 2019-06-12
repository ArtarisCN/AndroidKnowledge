package cn.artaris.androidknowledge.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * cn.artaris.androidknowledge.Service
 * AndroidKnowledge
 * 2019.05.14  11:40
 *
 * @author : artairs
 */
public class DemoService extends Service {

    private DemoBinder mBinder;

    public DemoService() {
        Log.d("DemoService", "Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mBinder = new DemoBinder();
        Log.d("DemoService", "onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("DemoService", "onStartCommand");
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("DemoService", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("DemoService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("DemoService", "onDestroy");
    }

    public static void start(Context context, String name) {
        Intent intent = new Intent(context, DemoService.class);
        intent.putExtra("key",name);
        context.startService(intent);
    }

    private class DemoBinder extends Binder {



    }



}
