package cn.artaris.androidknowledge.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * cn.artaris.androidknowledge.Handle
 * AndroidKnowledge
 * 2019.05.08  10:02
 *
 * @author : artairs
 */
public class HandleActivity extends AppCompatActivity {

    ThreadLocal<Integer> mIntegerThreadLocal;
    public TextView mTextView;

    private Handler mHandler = new Handler(new Handler.Callback() {



        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

    private static class StaticHandle extends Handler{
        WeakReference<HandleActivity> mActivityReference;

        public StaticHandle(HandleActivity activity) {
            mActivityReference= new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            HandleActivity activity = mActivityReference.get();
            if(activity != null){
                activity.mTextView.setText((String)msg.obj);
            }
        }
    }

    private Handler mHandler2 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private synchronized void test(){

        notify();
    }

//    private boolean searchTree(Node root,int target){
//        if(root ==null){
//            return  false;
//        }
//
//        if(root.val == target){
//            return true;
//        } else if(root.val < target){
//            searchTree(root.right,target);
//        } else {
//            searchTree(root.left,target);
//        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.obtainMessage(0).sendToTarget();
        Message s = mHandler.obtainMessage();
        mHandler.sendMessage(s);

        Message.obtain(mHandler, new Runnable() {
            @Override
            public void run() {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                mIntegerThreadLocal.get();
            }
        }).start();
    }
}
