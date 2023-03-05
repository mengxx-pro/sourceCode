package source.thread;

import org.junit.Test;

/**
 * ThreadLocal测试类
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> integerThreadLocal =new ThreadLocal<>();

    public ThreadLocalTest(){
        integerThreadLocal.set(0);
    }

    @Test
    public void threadLoaclTest() {
        new Thread(() -> {
            integerThreadLocal.set(1);
            System.out.println("线程"+Thread.currentThread()+"输出ThreadLocal值："+integerThreadLocal.get());
        }).start();
        new Thread(() -> {
            integerThreadLocal.set(2);
            integerThreadLocal.remove();
            System.out.println("线程"+Thread.currentThread()+"输出ThreadLocal值："+integerThreadLocal.get());
        }).start();
        System.out.println("线程"+Thread.currentThread()+"输出ThreadLocal值："+integerThreadLocal.get());
    }

}
