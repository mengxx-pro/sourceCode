package source.javaCollection;

import org.junit.Test;

public class StringTest {


    @Test
    public void stringTest() {
        String a = "a";
        String b = "b";
        //int b = 1;
        a.equals(b.intern());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        Integer c =new Integer(1);
        Integer d =new Integer(2);
        c.equals(c);
    }
}
