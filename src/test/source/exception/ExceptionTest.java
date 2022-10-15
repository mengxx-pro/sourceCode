package source.exception;

import org.junit.Test;

/**
 * @author: mengxiangxing
 * @description: 异常测试
 * @create: 2021-09-08 13:32
 **/
public class ExceptionTest implements AutoCloseable {

    public static int returnInt() {
        int a = 1;
        try {
            return a;
        } finally {
            a = 3;
            System.out.println("returnInt里的值是" + a);
        }
    }

    @Test
    public void ExceptionTest(){
        Integer i = null;
        try {
            if(i==1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String a = "123552232";
        int x = a.charAt(0) - '0';
        System.out.println(x);
        /*当try和finally中也有return时，会最后执行finally里的并覆盖try中的返回值
         *finally 块： 无论是否捕获或处理异常，finally 块里的语句都会被执行。
         *  当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行。
         */

        //System.out.println(ExceptionTest.returnInt());


        /**
         * 需要关闭资源的不要手动close直接用try-with-resources来自动关闭
         * 适用范围（资源的定义）： 任何实现 java.lang.AutoCloseable或者 java.io.Closeable 的对象
         * 关闭资源和 finally 块的执行顺序： 在 try-with-resources 语句中，任何 catch 或 finally 块在声明的资源关闭后运行
         */
   /* ExceptionTest exceptionTest =new ExceptionTest();
    try {
      exceptionTest.doIt();
    } catch (Exception e) {
      e.printStackTrace();
    }finally {
      exceptionTest.close();
    }*/
  /*  try(ExceptionTest exceptionTest =new ExceptionTest()){
      exceptionTest.doIt();
      //自动调用了close方法
    }catch (Exception e){
      e.printStackTrace();
    }*/
    }

    @Override
    public void close() {
        System.out.println("closed.....");
    }

    public static void doIt() throws Exception {
        System.out.println("doIt.....");
    }
}
