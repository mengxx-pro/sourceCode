package source.javaCollection;


import org.junit.Test;

import java.util.HashSet;

import java.util.Set;

/**
 * java集合中Collection接口类
 */
public class CollectionTest {

    @Test
    public void setTest(){
        Set set =new HashSet();
        set.add(1);
        set.add(1);
        System.out.println(set);
    }

}
