package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: mengxiangxing
 * @Description: Atomic 原子类
 * @Date: 2021/9/30 14:14
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger i =new AtomicInteger(1);
        System.out.println("获取当前i的值为："+i.get());
        i.getAndSet(2);
        System.out.println("获取当前i的值为："+i.get());
        i.getAndIncrement();
        System.out.println("获取当前i的值为："+i.get());
        i.compareAndSet(4,8);
        System.out.println("获取当前i的值为："+i.get());
    }
}
