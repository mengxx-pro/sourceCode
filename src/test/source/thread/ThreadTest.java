package source.thread;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
}
