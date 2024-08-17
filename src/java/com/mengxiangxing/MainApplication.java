package com.mengxiangxing;

import com.mengxiangxing.main.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.mengxiangxing.main.*")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.err.println("启动结束");

        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = new Singleton();
        System.out.println(singleton.toString());
        System.out.println(singleton2.toString());
    }


}

