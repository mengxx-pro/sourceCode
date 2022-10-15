package source.javaCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mengxiangxing
 * @description: ArrayList和LinkedList区别
 * @create: 2021-07-25 14:24
 **/

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2, 0);
        System.out.println(list.toString());

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(1, 2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        long startTime = System.currentTimeMillis();

        System.out.println("获取ArrayList为" + arrayList.get(4));
        long endTime = System.currentTimeMillis();

        System.out.println("获取ArrayList时间为" + (endTime - startTime));

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        startTime = System.currentTimeMillis();
        System.out.println("获取linkedList为" + linkedList.getFirst());
        endTime = System.currentTimeMillis();
        System.out.println("获取linkedList时间为" + (endTime - startTime));

    }

    @Test
    public void listToArrayTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String[] arrays = list.toArray(new String[0]);
        System.out.println("arrays数组：" + arrays.toString());
    }

    @Test
    public void listForTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        /*for循环时list被移除a的时候不会越界，移除b就会越界了
        因为移除b的时候list的长度变为1了，这是时候进入第三次的for循环判断，程序认为长度最少也应该是2，因为都循环过2次了,
        但是现在长度是1就直接抛出异常了,ConcurrentModificationException并发修改异常*/
//        for(String item : list){
//            if("b".equals(item)){
//                list.remove(item);
//            }
//        }
        System.out.println("for循环移除后的集合：");
        list.forEach(System.out::println);

        //采用迭代器的方式进行移除等操作就不会异常了
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String itemIterator = iterator.next();
            if (itemIterator.equals("b")) {
                iterator.remove();
            }
        }
        System.out.println("迭代器移除后的集合：");
        list.forEach(System.out::println);
    }
}
