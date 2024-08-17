package com.mengxiangxing.main;

/**
 * 单例模式
 */
public class Singleton {
    //懒汉模式
    private static Singleton singleton;

    public static Singleton getInstance(){
        if(singleton==null){
            synchronized(Singleton.class){
                if(singleton==null){
                    singleton =new Singleton();
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
        int array[] = new int[]{10, 2, -11, 1, 5};
        //连续的子数组，相加之和的最大值
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
               /* i
                j*/
        }

    }


}
