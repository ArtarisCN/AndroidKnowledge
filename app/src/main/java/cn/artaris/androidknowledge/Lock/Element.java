package cn.artaris.androidknowledge.Lock;

/**
 * cn.artaris.androidknowledge.Lock
 * AndroidKnowledge
 * 2019.05.30  09:52
 *
 * @author : artairs
 */
public class Element {

    public synchronized void synchronizedFun(String threadName) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This thread is " + threadName);
        }
    }


    public void blockFun(String threadName) {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("This thread is " + threadName);
            }
        }
    }


    public static synchronized void staticFun(String threadName) {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This thread is " + threadName);
        }

    }

}
