package com.example.java_training.access_modifier;

public class Parent {
    public void printValue(){
        Main main = new Main();
        main.a = 5;
//        main.b = "x";//not allowed private variable
        main.c = 3.0f;
        main.d = 4000;
        System.out.println(main.a);
//        System.out.println(main.b);//not allowed private variable
        System.out.println(main.c);
        System.out.println(main.d);
    }
}
