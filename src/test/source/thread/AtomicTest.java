package source.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: mengxiangxing
 * @Description: Atomic 原子类
 * @Date: 2021/9/30 14:14
 */
public class AtomicTest {

     //使用AtomicInteger之后，不需要加锁，也可以实现线程安全。

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        System.out.println("获取当前i的值为：" + i.get());
        i.getAndSet(2);//获取当前的值，并设置新的值
        System.out.println("获取当前i的值为：" + i.get());
        i.getAndIncrement();//获取当前的值，并自增
        System.out.println("获取当前i的值为：" + i.get());
        i.compareAndSet(4, 8);//如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
        System.out.println("获取当前i的值为：" + i.get());
    }

    public AtomicTest(String a){

    }
}
