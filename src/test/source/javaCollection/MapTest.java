package source.javaCollection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java集合中Map接口
 */
public class MapTest {

    //循环一个map
    @Test
    public void hashMapTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");

        //迭代器
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //转成list
        List<String> aList = map.keySet().stream().collect(Collectors.toList());
        List<String> bList = map.values().stream().collect(Collectors.toList());

        //map.forEach( p -> System.out.println(p));


        //循环keySet
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        //循环values
        for (String key : map.values()) {
            System.out.println(key);
        }

        //使用entrySet遍历
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + " and value=" + entry.getValue());
        }
    }


}
