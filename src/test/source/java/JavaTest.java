package source.java;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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

        String a = "ab";//放在常量池中
        String b = "ab";// 从常量池中查找
        System.out.println(a == b);// true

        String aa = new String("ab");
        String bb = new String("ab");
        System.out.println(aa == bb);// false
    }

    @Test
    public void equalsTest() {
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

        //当Integer的值为-128~127之间的值的时候，Integer直接把这些值放进常量池里面，这个时候，用 == 是可以比较的。
        //但是当赋给Integer值超过这个范围的时候，Integer就会创建对象，值就不放在常量池里面了，这个时候再用 == 就不可以比较了，因为存放的位置都不一样了，数一样还是会返回false
        //所以Integer的话强烈建议用 equals() 这个方法！
        Integer jzBindBankcardStatus = 122;
        Integer jzBindBankcardStatusCopy = 122;;
        System.out.println(jzBindBankcardStatus==jzBindBankcardStatusCopy);
    }

    @Test
    public void numberTest() {
        //BigDecimal精度问题
        BigDecimal bigDecimal = new BigDecimal(0.1);//丢失
        BigDecimal bigDecimal2 = new BigDecimal("0.1");//正常
        BigDecimal bigDecimal3 = BigDecimal.valueOf(0.1);//正常
        System.out.println();
    }

    @Test
    public void collectionTest() {
        /**
         * 判断所有集合内部的元素是否为空，使用 isEmpty() 方法，而不是 size()==0 的方式。
         *
         * 这是因为 isEmpty() 方法的可读性更好，并且时间复杂度为 O(1)。
         *
         * 绝大部分我们使用的集合的 size() 方法的时间复杂度也是 O(1)，不过，
         * 也有很多复杂度不是 O(1) 的，比如 java.util.concurrent 包下的某些集合（ConcurrentLinkedQueue 、ConcurrentHashMap...）
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        System.out.println("==集合是否为空+" + concurrentHashMap.isEmpty());
        System.out.println(concurrentHashMap.size() == 0);

        List transList = Arrays.asList(1, 2, 3);
        /**
         * 运行时报错：UnsupportedOperationException
         * Arrays.asList() 方法返回的并不是 java.util.ArrayList ，而是 java.util.Arrays 的一个内部类,
         * 这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。
         * AbstractList类中直接throw new UnsupportedOperationException();
         */
        System.out.println(transList.getClass());
        transList.add(4);

    }

    @Test
    public void addSubTest() {
        //++a 和 a++的区别在于，++a是先自增后赋值
        //a++是先赋值再自增，符号在前就先加减，符号在后就后加减”
        int a = 0;
        int b = a++;
        //int b =++a;
        System.out.println(b);
        String c = "121";
        c.equals("12121111");
        long jk = 3999778787878721L;
        long jk1 = 311111111111111233L;
    }

    /**
     * 泛型测试类
     * 常用的通配符为：
     * T，E，K，V，？
     *  ？ 表示不确定的 Java 类型 T (type) 表示具体的一个 Java 类型   K V (key value) 分别代表 Java 键值中的 Key Value   E (element) 代表 Element
     */
    @Test
    public void genericsTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加是可以的
        //这就说明在运行期间所有的泛型信息都会被擦掉
        add.invoke(list, "kl");
        System.out.println(list);

    }
}
