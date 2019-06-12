package cn.artaris.androidknowledge.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import cn.artaris.androidknowledge.MainActivity;
import cn.artaris.androidknowledge.R;

/**
 * cn.artaris.androidknowledge.Service
 * AndroidKnowledge
 * 2019.05.14  12:09
 *
 * @author : artairs
 */
public class DemoForegroundService extends Service {

    Notification.Builder builder;
    Notification notification;

    public DemoForegroundService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DemoForegroundService", "onCreate");
        showNotification();
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return super.startForegroundService(service);
    }

    private void showNotification() {

        builder = new Notification.Builder(this.getApplicationContext()); //获取一个Notification构造器
        Intent nfIntent = new Intent(this, MainActivity.class);

        builder // 设置PendingIntent
                .setContentTitle("下拉列表中的Title") // 设置下拉列表里的标题
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("要显示的内容") // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(nfIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        //设置跳转Intent到通知中       
        builder.setContentIntent(pendingIntent);
        //     //获取通知服务       
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);//构建通知   
        Notification notification = builder.build();//显示通知       



        notification = builder.build(); // 获取构建好的Notification
        notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音\

        nm.notify(0, notification);
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("DemoForegroundService", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
