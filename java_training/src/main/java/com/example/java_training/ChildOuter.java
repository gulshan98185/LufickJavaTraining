package com.example.java_training;

import com.example.java_training.access_modifier.Main;

public class ChildOuter extends Main {
//    public int getA(){
//        return a; // not allowed (not public) variable out of package
//    }

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
//        a = 5; // not allowed (not public) variable out of package
//        b = "x"; // not allowed private variable
        c = 3.0f;
        d = 3000;
    }
}
