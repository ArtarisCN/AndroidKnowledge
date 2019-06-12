package cn.artaris.androidknowledge.IntentService;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * cn.artaris.androidknowledge
 * AndroidKnowledge
 * 2019.05.06  17:37
 *
 * @author : artairs
 */
public class ArtarisIntentService extends IntentService {

    private static final String ACTION_INIT = "initApplication";

    public ArtarisIntentService() {
        super("ArtarisIntentService");
    }

    public ArtarisIntentService(String name) {
        super(name);
        Log.d("ArtarisIntentService", "Constructor");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ArtarisIntentService", "onCreate");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("ArtarisIntentService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ArtarisIntentService", "onBind");
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        assert intent != null;
        String name = intent.getStringExtra("key");
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("ArtarisIntentService--",  i + " - onHandleIntent - "+name + Thread.currentThread().getName());
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("ArtarisIntentService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ArtarisIntentService", "onDestroy");
    }

    public static void start(Context context, String name) {
        Intent intent = new Intent(context, ArtarisIntentService.class);
        intent.setAction(ACTION_INIT);
        intent.putExtra("key",name);
        context.startService(intent);
    }

}
