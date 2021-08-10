import org.junit.Test;
import sun.security.provider.Sun;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: mengxiangxing
 * @description: ConcurrentHashMap
 * @create: 2021-07-25 15:12
 **/
public class ConcurrentHashMapTest {

   private Integer i = 0;

  static sun.misc.Unsafe UNSAFE = null;

  static {
    UNSAFE = sun.misc.Unsafe.getUnsafe();
  }


  public static void main(String[] args) {
    Hashtable hashtable = new Hashtable();
    hashtable.put("", "");

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    concurrentHashMap.put("", "");
  }


  @Test
  public void UnsafeTest() throws InterruptedException {
    ConcurrentHashMapTest concurrentHashMapTest = new ConcurrentHashMapTest();
    //2个线程同时对i++会产生并发问题，
    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          concurrentHashMapTest.i++;
          System.out.println("线程1 i的值是"+concurrentHashMapTest.i);
          try {
            Thread.sleep(5);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          concurrentHashMapTest.i++;
          System.out.println("线程2 i的值是"+concurrentHashMapTest.i);
          try {
            Thread.sleep(5);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();

  }
}
