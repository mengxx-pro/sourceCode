package thread;

import java.util.*;

/**
 * @Author: mengxiangxing
 * @Description: java8 新特性
 * @Date: 2021/9/30 15:23
 */
public class Java8 {

    public static void main(String[] args) {
        //1排序
        List<String> name = Arrays.asList("tom", "bob", "six", "exe");
        //常规排序
        /*Collections.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        //java8排序
        //Collections.sort(name);
        /*Collections.sort(name,(a,b)->{
            return a.compareTo(b);
        });*/
        Collections.sort(name,(a,b)->a.compareTo(b));
        System.out.println(name);
    }
}
