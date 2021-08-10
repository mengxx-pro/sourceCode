import java.util.HashMap;

/**
 * @author: mengxiangxing
 * @description: HaspMap
 * @create: 2021-07-25 15:12
 **/
public class HashMapTest {

  public static void main(String[] args) {
    System.out.println(1<<30);

    HashMap<Integer,Integer> hashMap =new HashMap<Integer,Integer>(17);
    hashMap.put(1, 1);
    Integer result =  hashMap.put(1, 2);
    hashMap.get(1);
    System.out.println("100".hashCode());
  }
}
