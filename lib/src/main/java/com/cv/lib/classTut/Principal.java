package com.cv.lib.classTut;

public class Principal {
    private static Principal instance;
    public int a;
    private Principal(){
        a = 50;
    }
    public void doMyCal(){
        System.out.println(a*2);
    }
    public static Principal getInstance(){
        if (instance==null) {
            instance =  new Principal();
        }
        return instance;
    }
}
