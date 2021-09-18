package thread;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: mengxiangxing
 * @description: aqs cas等锁
 * @create: 2021-09-17 17:05
 **/
public class Lock {

  /*AbstractQueuedSynchronizer;*/

  private static final ReentrantLock reentrantLock = new ReentrantLock();


  public static void main(String[] args) {


    new Thread(new Runnable() {
      @Override
      public void run() {
        reentrantLock.lock();
        System.out.println("加锁1"+new Date());
        try {
          System.out.println("try1"+new Date());
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          reentrantLock.unlock();
          System.out.println("解锁1"+new Date());
        }
      }
    }).start();


    new Thread(new Runnable() {
      @Override
      public void run() {
        reentrantLock.lock();
        System.out.println("加锁2"+new Date());
        try {
          System.out.println("try2"+new Date());
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          reentrantLock.unlock();
          System.out.println("解锁2"+new Date());
        }
      }
    }).start();


  }
}
