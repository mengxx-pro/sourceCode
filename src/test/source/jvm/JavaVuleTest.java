package source.jvm;

import org.junit.Test;

public class JavaVuleTest {

    public static void main(String[] args) {
        String str1 = "str";
        String str2 = "ing";
        String str3 = "str" + "ing";//常量池中的对象
        String str4 = str1 + str2; //在堆上创建的新的对象
        String str5 = "string";//常量池中的对象
        System.out.println(str3 == str4);//false
        System.out.println(str3 == str5);//true
        System.out.println(str4 == str5);//false

        final String str10 = "str";
        final String str20 = "ing";
        // 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str10 + str20; // 常量池中的对象
        System.out.println(c == d);// true
    }

    @Test
    public void StringTest() {
        String str1 = "abcd";
        String str2 = new String("abcd");
        String str3 = new String("abcd");
        System.out.println(str1==str2);
        System.out.println(str2==str3);
    }
}
