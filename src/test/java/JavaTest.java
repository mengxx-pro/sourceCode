import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: mengxiangxing
 * @description: 基本java知识测试代码
 * @create: 2021-09-07 16:17
 **/
@SpringBootTest
public class JavaTest {

  @Test
  public void StringTest() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("");
    String.valueOf("");
  }

  @Test
  public void equalsTest(){
    // Integer i1=40 这一行代码会发生装箱，也就是说这行代码等价于 Integer i1=Integer.valueOf(40) 。
    // 因此，i1 直接使用的是常量池中的对象。而Integer i1 = new Integer(40) 会直接创建新的对象。
    /**
     * Integer中有个静态内部类IntegerCache，里面有个cache[],也就是Integer常量池，常量池的大小为一个字节（-128~127）
     * 当在这个范围的时候不会new Integer 而是直接使用常量池中的对象,所以可以用==比较，超出这个范围的就需要用equals
     */
    Integer i1 = 130;
    //Integer i1 = Integer.valueOf(40);
    //Integer i2 = new Integer(40);
    Integer i2 = 130;
    System.out.println(i1 == i2);
  }
}
