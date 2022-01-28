import org.junit.Test;

import java.util.*;

/**
 * @Author: mengxiangxing
 * @Description: java8 新特性
 * @Date: 2021/9/30 15:23
 */
public class Java8 {

    private static List<StudentScore> studentScoreList = new ArrayList<>();

    public Java8() {

        StudentScore studentScore1 = new StudentScore() {{
            setStuName("张三");
            setSubject("语文");
            setScore(70);
        }};
        StudentScore studentScore2 = new StudentScore() {{
            setStuName("张三");
            setSubject("数学");
            setScore(80);
        }};
        StudentScore studentScore3 = new StudentScore() {{
            setStuName("张三");
            setSubject("英语");
            setScore(65);
        }};
        StudentScore studentScore4 = new StudentScore() {{
            setStuName("李四");
            setSubject("语文");
            setScore(68);
        }};
        StudentScore studentScore5 = new StudentScore() {{
            setStuName("李四");
            setSubject("数学");
            setScore(70);
        }};
        StudentScore studentScore6 = new StudentScore() {{
            setStuName("李四");
            setSubject("英语");
            setScore(90);
        }};
        StudentScore studentScore7 = new StudentScore() {{
            setStuName("王五");
            setSubject("语文");
            setScore(80);
        }};
        StudentScore studentScore8 = new StudentScore() {{
            setStuName("王五");
            setSubject("数学");
            setScore(85);
        }};
        StudentScore studentScore9 = new StudentScore() {{
            setStuName("王五");
            setSubject("英语");
            setScore(70);
        }};

        studentScoreList.add(studentScore1);
        studentScoreList.add(studentScore2);
        studentScoreList.add(studentScore3);
        studentScoreList.add(studentScore4);
        studentScoreList.add(studentScore5);
        studentScoreList.add(studentScore6);
        studentScoreList.add(studentScore7);
        studentScoreList.add(studentScore8);
        studentScoreList.add(studentScore9);
    }

    public static void main1(String[] args) {
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
        Collections.sort(name, (a, b) -> a.compareTo(b));
        System.out.println(name);

        new Java8();
        Map<String, Integer> studentScoreMap2 = new HashMap<>();
        studentScoreList.forEach(studentScore -> studentScoreMap2.merge(
                studentScore.getStuName(),
                studentScore.getScore(),
                Integer::sum));

        System.out.println(studentScoreMap2);
    }

    @Test
    public void orElseTest(){

        //orElse有就用自身值，没有就用orElse后边的
        System.out.println(Optional.ofNullable(null).orElse("扯淡"));
        //orElseGet 可以传入一个Supplier接口，实现花样的逻辑
        System.out.println(Optional.ofNullable(null).orElseGet(()->"自行车"));

        try {
            System.out.println(Optional.ofNullable("有钱").orElseThrow(()->new Exception()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Optional.ofNullable(null).orElseThrow(()->new Exception("没钱异常了")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i=1;
        int j= Optional.ofNullable(i).orElse(i=6);
        System.out.println(j);
        System.out.println(i);
    }

    public static void main(String[] zezeze) {
       /* args = new String[]{"a","b","c"};
        argsVoid(args);
        argsVoid("d","e","f");//传3个参数
        argsVoid("b");//传1个参数*/

        int[] args = new int[]{1,2,3};
        argsVoid(args);
        argsVoid(4,5,6);//传3个参数
        argsVoid(7);//传1个参数
    }

    //String...可变参数
    public static void argsVoid(int... args) {
        Arrays.stream(args).forEach(arg->{
            System.out.println(arg);
        });
    }

}
