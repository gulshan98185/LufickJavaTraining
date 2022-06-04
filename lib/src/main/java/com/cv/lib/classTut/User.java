package com.cv.lib.classTut;

public class User {
    public static int a;
    public static int b;
    int ab = 0;
    boolean abc = false;
    float f = 0.0f;
    int[] arrays = {};
    double d = 0d;
    long l = 0L;
    String string = null;
    Integer integer = null;

    User(){
        a = 10;
        b = 5;
    }


    public static int doCalculation(int a, int b){
        return a+b;
    }

    public static void doSomeThing(){
        System.out.println("I am doing something");
    }

    public static class Student{
        int a;
        int b;
    }
}
