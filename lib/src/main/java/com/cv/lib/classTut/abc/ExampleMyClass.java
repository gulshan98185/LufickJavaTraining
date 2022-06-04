package com.cv.lib.classTut.abc;

import com.cv.lib.classTut.Principal;
import com.cv.lib.classTut.User;

public class ExampleMyClass {
    public static void main(String[] args) {
//        User.doSomeThing();
//        User.Student student = new User.Student();
//        int a = User.doCalculation(1, 2);
//        System.out.println(a);


//        Principal principal  = new Principal();
//        Principal principal2  = new Principal();
//        Principal principal3  = new Principal();
//        Principal principal4  = new Principal();
//        Principal principal5  = new Principal();
//        Principal principal6  = new Principal();

        //singleton class has only one object
//        System.out.println(Principal.getInstance());
//        System.out.println(Principal.getInstance());
//        System.out.println(Principal.getInstance());
//        System.out.println(Principal.getInstance());
//        System.out.println(Principal.getInstance());
//        System.out.println(Principal.getInstance());

        Principal principal = Principal.getInstance();
        principal.a = 20;
        principal.doMyCal();


    }
}
