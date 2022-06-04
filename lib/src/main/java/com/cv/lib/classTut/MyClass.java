package com.cv.lib.classTut;

public class MyClass {
    public static void main(String[] args) {
        System.out.println(User.a);
        User user = new User();
        User.doSomeThing();
        User.Student student = new User.Student();
        student.a = 50;
        student.b = 10;
        //System.out.println(user.b);
    }
}
