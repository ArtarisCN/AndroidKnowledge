package cn.artaris.androidknowledge.Lock;

/**
 * cn.artaris.androidknowledge.Lock
 * AndroidKnowledge
 * 2019.05.27  09:31
 *
 * @author : artairs
 */
public class LockDemo {

    private int value;
    private final Object mLock = new Object();
    private final Object mLock1 = new Object();

    private int x;
    private int y;

    private void addOne() {
        synchronized (mLock) {
            value += 1;
        }
    }

    private synchronized void count(int newValue) {
        x = newValue;
        y = newValue;
        if (x != y) {
            System.out.println("x= " + x + ", y = " + y);
        }
    }


    private static volatile long count = 0;

    private static void addCount(long i) {
        count = i;
    }

    private static long readCount() {
        return count;
    }

    public static void main(String[] args) {

//        ExecutorService executor = Executors.newCachedThreadPool();
//
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    LockDemo.addCount(i);
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(LockDemo.readCount());
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        });
//
//        executor.shutdown();
    }
}
