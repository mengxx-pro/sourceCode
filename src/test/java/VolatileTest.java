import org.junit.Test;

/**
 * @author: mengxiangxing
 * @description: volatile关键字测试
 * @create: 2021-09-15 14:29
 **/
public class VolatileTest {

  //volatile用于多线程时变量的可见行，不然1线程修改了a的变量后2线程没有看见会出现a=1,b=3的情况
  volatile int a = 1, b = 2;

  //原子性测试
  volatile int i = 0;

  //volatile 可以禁止 JVM 的指令重排

  public static void main(String[] args) {
    while (true) {
      //TODO 不用final就会出出现a=1,b=3的问题？？
      final VolatileTest test = new VolatileTest();
      new Thread(() -> {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        test.change();
      }).start();

      new Thread(() -> {
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        test.print();
      }).start();
    }
  }

  private void change() {
    a = 3;
    b = a;
  }

  private void print() {
    System.out.println("a=" + a + "  b=" + b);
  }

  @Test
  public void atomTest() throws InterruptedException {
    for (int i = 0; i < 1000; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          addI();
        }
      }).start();
    }
    Thread.sleep(10000);
    System.out.println("i=" + i);
  }

  private synchronized void addI() {
    //原子性只能对单次操作起作用，i++有三步：
    //读取i的值
    //对i+1
    //将i的值写回内存
    //所以i++用在多线程中用volatile不能保证原子性
    //用synchronized来解决原子问题可以
    i++;
  }
}
