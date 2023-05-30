package com.example.java_training;

import com.example.java_training.access_modifier.Main;

public class MyClass {
    public static void main(String[] args) {
//        System.out.println("Hello World");
        Main main = new Main();//        System.out.println(main.a);
//        System.out.println(main.b);
        System.out.println(main.c);
//        System.out.println(main.d);// not allowed protected variable

//        main.a = 5;
//        b = "x"; // not allowed private variable
        main.c = 3.0f;
//        main.d = 3000;// not allowed protected variable
    }
}