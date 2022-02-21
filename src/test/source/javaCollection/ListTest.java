package source.javaCollection;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: mengxiangxing
 * @description: ArrayList和LinkedList区别
 * @create: 2021-07-25 14:24
 **/

public class ListTest {

  public static void main(String[] args) {
    ArrayList arrayList =new ArrayList();
    arrayList.add(1);
    arrayList.add(1,2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    long startTime =System.currentTimeMillis();

    System.out.println("获取ArrayList为"+arrayList.get(4));
    long endTime =System.currentTimeMillis();

    System.out.println("获取ArrayList时间为"+(endTime-startTime));

    LinkedList linkedList =new LinkedList();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.add(5);

    startTime =System.currentTimeMillis();
    System.out.println("获取linkedList为"+linkedList.getFirst());
    endTime =System.currentTimeMillis();
    System.out.println("获取linkedList时间为"+(endTime-startTime));

  }
}
