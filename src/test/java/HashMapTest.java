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
    hashMap.put(null, null);
    Integer result =  hashMap.put(null, 3);
    hashMap.get(1);
    hashMap.remove(1);
    System.out.println("100".hashCode());
  }
}


