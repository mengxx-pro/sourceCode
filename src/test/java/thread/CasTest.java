package thread;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: mengxiangxing
 * @Description: CAS的测试类
 * @Date: 2021/9/28 17:17
 */
@SpringBootTest
public class CasTest implements Runnable{

    private static AtomicInteger count = new AtomicInteger(0);

    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        CasTest ast = new CasTest();
        Thread thread1 = new Thread(ast);
        Thread thread = new Thread(ast);
        thread1.start();
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("thread:" + Thread.currentThread().getName() + ";flag:" + flag.get());
        if (flag.compareAndSet(true, false)) {
            System.out.println(Thread.currentThread().getName() + "" + flag.get());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag.set(true);
        } else {
            System.out.println("重试机制thread:" + Thread.currentThread().getName() + ";flag:" + flag.get());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }

    }


    //CAS比较并替换
    /* 所谓原子操作类，指的是java.util.concurrent.atomic包下，一系列以Atomic开头的包装类。
    例如AtomicBoolean，AtomicInteger，AtomicLong。它们分别用于Boolean，Integer，Long类型的原子性操作。*/
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
