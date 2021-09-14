import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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
    stringBuilder.append("");//不安全，快
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("");//安全，慢
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

  @Test
  public void numberTest(){
    //BigDecimal精度问题
    BigDecimal bigDecimal = new BigDecimal(0.1);//丢失
    BigDecimal bigDecimal2 = new BigDecimal("0.1");//正常
    BigDecimal bigDecimal3 = BigDecimal.valueOf(0.1);//正常
    System.out.println();
  }

  @Test
  public void collectionTest(){
    /**
     * 判断所有集合内部的元素是否为空，使用 isEmpty() 方法，而不是 size()==0 的方式。
     *
     * 这是因为 isEmpty() 方法的可读性更好，并且时间复杂度为 O(1)。
     *
     * 绝大部分我们使用的集合的 size() 方法的时间复杂度也是 O(1)，不过，
     * 也有很多复杂度不是 O(1) 的，比如 java.util.concurrent 包下的某些集合（ConcurrentLinkedQueue 、ConcurrentHashMap...）
     */
    ConcurrentHashMap concurrentHashMap =new ConcurrentHashMap();
    System.out.println("==集合是否为空+"+concurrentHashMap.isEmpty());
    System.out.println(concurrentHashMap.size()==0);

    List transList = Arrays.asList(1,2,3);
    /**
     * 运行时报错：UnsupportedOperationException
     * Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,
     * 这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
     * AbstractList类中直接throw new UnsupportedOperationException();
     */
    System.out.println(transList.getClass());
    transList.add(4);

  }
}
