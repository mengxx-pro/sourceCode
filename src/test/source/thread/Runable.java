package source.thread;

import java.util.Date;

/**
 * @author: mengxiangxing
 * @description: 多线程测试类
 * @create: 2021-09-16 18:00
 **/
public class Runable implements Runnable {

  private String command;

  public Runable(String s) {
    this.command = s;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
    processCommand();
    System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
  }

  private void processCommand() {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return this.command;
  }

}


