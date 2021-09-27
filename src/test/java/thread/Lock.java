package thread;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: mengxiangxing
 * @description: aqs cas等锁
 * @create: 2021-09-17 17:05
 **/
public class Lock {

    /*AbstractQueuedSynchronizer;*/

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    private static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("加锁1" + new Date());
                try {
                    System.out.println("try1" + new Date());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("解锁1" + new Date());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("加锁2" + new Date());
                try {
                    System.out.println("try2" + new Date());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println("解锁2" + new Date());
                }
            }
        }).start();

    }

    //CAS比较并替换
    @Test
    public void casTest() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //每个线程让count自增100次
                    for (int i = 0; i < 100; i++) {
                        count.incrementAndGet();
                        // count.compareAndSet(0,2);
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
