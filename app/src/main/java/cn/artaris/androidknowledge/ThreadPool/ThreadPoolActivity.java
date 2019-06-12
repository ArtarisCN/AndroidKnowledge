package cn.artaris.androidknowledge.ThreadPool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cn.artaris.androidknowledge.BaseActivity;

/**
 * cn.artaris.androidknowledge.ThreadPool
 * AndroidKnowledge
 * 2019.05.20  11:43
 *
 * @author : artairs
 */
public class ThreadPoolActivity extends BaseActivity {

    private ExecutorService mScheduler;
    Thread mThread;
    private BlockingQueue<Runnable> mQueue = new ArrayBlockingQueue<>(4);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Executors.newCachedThreadPool();
        mScheduler = new ThreadPoolExecutor(3,
                5,
                1,
                TimeUnit.SECONDS,
                mQueue,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                });
    }

    @Override
    protected void onClick(View view) {

    }
}
