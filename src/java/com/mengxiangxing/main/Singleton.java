package com.mengxiangxing.main;

import java.util.Arrays;

/**
 * 单例模式
 */
public class Singleton {
    //懒汉模式
    private static Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public Singleton() {
        System.out.println("构造方法私有化!!!");
    }


    //饿汉模式
 /*   private static final Singleton singleton = new Singleton();

    public static  Singleton getInstance() {
        *//*System.out.println("原来："+singleton.toString());
        singleton =new Singleton();
        System.out.println("现在："+singleton.toString());*//*
        return singleton;
    }*/

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2};
        int key = 3;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i ; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == key) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
