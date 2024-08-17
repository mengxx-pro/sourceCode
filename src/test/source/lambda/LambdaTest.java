package source.lambda;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import source.common.Person;

import java.util.*;
import java.util.stream.Collectors;


@SpringBootTest
public class LambdaTest {

    List<String> res = new ArrayList<>();


    public static void main(String[] args) {

        //1.list转map
        // 假设有一个Person对象的List，其中包含id和name属性
        List<Person> personList = new ArrayList();
        personList = Arrays.asList(new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie"));

        Map<Integer, String> personMap = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        personMap.forEach((id, name) -> System.out.println(id + " ===  " + name));


        //2.map转list
        // 假设有一个Map，其中包含id和name的键值对
        Map<Integer, String> perMap = new HashMap<>();
        perMap.put(1, "Alice");
        perMap.put(2, "Bob");
        perMap.put(3, "Charlie");

        List<Person> perList = new ArrayList();
        perMap.forEach((id, name) -> perList.add(new Person(id, name)));
        personList.forEach(person -> System.out.println("ID: " + person.getId() + ", Name: " + person.getName()));

    }


    @Test
    public void reduceTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer numLast = list.stream().reduce(1, (a, b) -> (a * b));
        System.out.println(numLast);

        Integer min = list.stream().filter(x -> x >= 3).findFirst().orElse(null);
        System.out.println(min);
    }

    @Test
    public void reduceaaTest() {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * 3], 0, combinations);
        System.out.println(combinations);
    }


    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    @Test
    public void zzTest() {
        int n = 3;
        getParenthesis("", n, n);
        System.out.println(res);
    }


        public void getParenthesis(String str, int left, int right) {
            if (left == 0 && right == 0) {
                res.add(str);
                return;
            }
            if (left == right) {
                //剩余左右括号数相等，下一个只能用左括号
                getParenthesis(str + "(", left - 1, right);
            } else if (left < right) {
                //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
                if (left > 0) {
                    getParenthesis(str + "(", left - 1, right);
                }
                getParenthesis(str + ")", left, right - 1);
            }
        }


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}

    class Solution {

        Map<Node,Node> cachedNode =new HashMap<>();

        Node node1 =new Node(7);
        Node node2 =new Node(13);

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            if (!cachedNode.containsKey(head)) {
                Node headNew = new Node(head.val);
                cachedNode.put(head, headNew);
                headNew.next = copyRandomList(head.next);
                headNew.random = copyRandomList(head.random);
            }
            return cachedNode.get(head);

        }
    }


}

