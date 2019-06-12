package cn.artaris.androidknowledge.Lock;

/**
 * cn.artaris.androidknowledge.Lock
 * AndroidKnowledge
 * 2019.05.30  09:52
 *
 * @author : artairs
 */
public class SynchronizedTest {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Element().synchronizedFun(Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Element().staticFun(Thread.currentThread().getName());
            }
        }).start();

    }





}

