package source.thread;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author: mengxiangxing
 * @description: 线程测试类
 * @create: 2021-09-14 15:52
 **/
public class ThreadTest {

  private static Object resource1 = new Object();
  private static Object resource2 = new Object();

  private final static int corePoolSize=5;
  private final static int maximumPoolSize=15;
  private final static int capacity=100;
  private final static long keepAliveTime=5000;
  private final static TimeUnit unit=TimeUnit.SECONDS;

  public static void main(String[] args) {
    ThreadPoolExecutor threadPoolExecutor =new ThreadPoolExecutor(corePoolSize,
        maximumPoolSize,
        keepAliveTime,
        unit,
        new ArrayBlockingQueue<>(capacity));

    for(int i=0;i<10;i++){
      Runable runable =new Runable(""+i);
      threadPoolExecutor.execute(runable);
    }

    threadPoolExecutor.shutdown();

    while (!threadPoolExecutor.isTerminated()) {
    }
    System.out.println("Finished all threads");


    //查看main线程里运行多少线程
    // 获取 Java 线程管理 MXBean
    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
    ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
    // 遍历线程信息，仅打印线程 ID 和线程名称信息
    for (ThreadInfo threadInfo : threadInfos) {
      System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
    }

    //线程死锁
    new Thread(() -> {
      synchronized (resource1) {
        System.out.println(Thread.currentThread() + "get resource1");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (resource2) {
          System.out.println(Thread.currentThread() + "get resource2");
        }
      }
    }
    ).start();

    new Thread(() -> {
      synchronized (resource2) {
        System.out.println(Thread.currentThread() + "get resource2");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        synchronized (resource1) {
          System.out.println(Thread.currentThread() + "get resource1");
        }
      }
    }
    ).start();
  }

  @Test
  public void failsafeAndfailfast(){

   /* Map<String,String> map =new HashMap<>();
    map.put("name","Bob");
    map.put("age","20");
    Iterator iterable = map.keySet().iterator();
    while (iterable.hasNext()){
      System.out.println("name is ：" + map.get(iterable.next()));
      map.put("work","no work");
    }*/

    /** ConcurrentModificationException-并发修改异常
     * Fail-fast ： 表示快速失败，在集合遍历过程中，一旦发现容器中的数据被修改了，会立刻抛ConcurrentModificationException 异常，从而导致遍历失败，像这种情况 。
     * 定义一个 Map 集合，使用 Iterator 迭代器进行数据遍历，在遍历过程中，对集合数据 做变更时，就会发生 fail-fast。 java.util 包下的集合类都是快速失败机制的,
     * 常见的的使用 fail-fast 方式遍历的容器有HashMap 和 ArrayList 等。
     */


    Map<String,String> concurrentMap =new ConcurrentHashMap<>();
    concurrentMap.put("name","Bob");
    concurrentMap.put("age","20");
    Iterator newIterable = concurrentMap.keySet().iterator();
    while (newIterable.hasNext()){
      System.out.println("name is ：" + concurrentMap.get(newIterable.next()));
      concurrentMap.put("work","no work");
    }

    /**
     *  Fail-safe，表示失败安全，也就是在这种机制下，出现集合元素的修改，
     * 不会抛出ConcurrentModificationException。 原因是采用安全失败机制的集合容器，在遍历时不是直接在集合内容上访问的，而是先复制原有集合内容，
     * 在拷贝的集合上进行遍历。由于迭代时是对原集合的拷贝进行遍历，所以在遍历过程中 对原集合所作的修改并不能被迭代器检测到比如这种情况 ，
     * 定义了一个 CopyOnWriteArrayList，在对这个集合遍历过程中，对集合元素做修改后，不会抛出异常，但同时也不会打印出增加的元素。java.util.concurrent 包下的容器都是安全失败的,
     * 可以在多线程下并发使用,并发修改。 常见的的使用 fail-safe 方式遍历的容器有 ConcerrentHashMap 和 CopyOnWriteArrayList 等。
     */

  }
}
