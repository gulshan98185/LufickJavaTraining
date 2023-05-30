package com.example.java_training.access_modifier;

public class Main {
    int a = 5;
    private String b = "xyz";
    public float c = 5.0f;
    protected long d = 5000;

    public int getA(){
        return a;
    }
    public String getB(){
        return b;
    }

    public float getC() {
        return c;
    }

    public long getD() {
        return d;
    }

    public void setA(int a){
        if(a<=0 || a>=1000){
            return;
        }
        this.a = a;
    }
}

class ChildInner extends Main{
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
