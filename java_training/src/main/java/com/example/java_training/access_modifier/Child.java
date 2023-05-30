package com.example.java_training.access_modifier;

public class Child extends Main{
    public int getA(){
        return a;
    }
//    public String getB(){
//        return b; // not allowed private variable
//    }
    public float getC(){
        return c;
    }
    public long getD(){
        return d;
    }

    public void setValue(){
        a = 5;
//        b = "x"; // not allowed private variable
        c = 3.0f;
        d = 3000;
    }
}
