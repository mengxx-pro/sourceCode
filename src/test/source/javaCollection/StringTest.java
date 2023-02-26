package source.javaCollection;

import org.junit.Test;

public class StringTest {


    @Test
    public void stringTest() {
        String a = "a";
        String b = "b";
        a.equals(b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
