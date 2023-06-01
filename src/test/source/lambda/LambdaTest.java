package source.lambda;

import source.common.Person;

import java.util.*;
import java.util.stream.Collectors;


public class LambdaTest {

    public static void main(String[] args) {

        //1.list转map

        // 假设有一个Person对象的List，其中包含id和name属性
        List<Person> personList = new ArrayList();
        personList = Arrays.asList(new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie"));

        Map<Integer,String> personMap =personList.stream().collect(Collectors.toMap(Person::getId,Person::getName));
        personMap.forEach((id,name) -> System.out.println(id + " ===  "+name));


        //2.map转list
        // 假设有一个Map，其中包含id和name的键值对
        Map<Integer, String> perMap = new HashMap<>();
        perMap.put(1, "Alice");
        perMap.put(2, "Bob");
        perMap.put(3, "Charlie");

        List<Person> perList = new ArrayList();
        perMap.forEach((id,name)->perList.add(new Person(id,name)));
        personList.forEach(person -> System.out.println("ID: " + person.getId() + ", Name: " + person.getName()));

    }

}

