import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: mengxiangxing
 * @description: ConcurrentHashMap
 * @create: 2021-07-25 15:12
 **/
public class ConcurrentHashMapTest {

   private Integer i = 0;

/*  static sun.misc.Unsafe UNSAFE = null;

  static {
    UNSAFE = sun.misc.Unsafe.getUnsafe();
  }*/


  public static void main(String[] args) {

    Hashtable hashtable = new Hashtable();
    hashtable.put(null, null);
    System.out.println("=====");
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(9);
    for(int i = 0;i<=10000;i++){
      concurrentHashMap.put(i,i);
      concurrentHashMap.remove(1);
      concurrentHashMap.get(1);
      System.out.println("++++");
    }
    int a[][] =new int[][]{};
    Arrays.sort(a, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]==o2[0]){
          return o1[1]-o2[1];
        }
        return o1[0]-o2[0];
      }
    });
    Arrays.fill(a,1);
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
