package com.example.java_training_august_2023.generics_tut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GenericsClass {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

//        list.add("String");
        list.add(14);
        list.add(141);
        list.add(15);

        int num = list.get(0);
//        String str = (String) list.get(0);
//        System.out.println(num);

        Calculate<Float> calculate = new Calculate<>(1.2F);
        calculate.setT(1.5f);
        System.out.println(calculate.add(1.2f, 1.1f, 1.4f));
//        System.out.println(calculate.getT());
//        calculate.doCalculation(1.3f, 1.2f, 2.2f);


        Generics<Integer, String, Integer> generics = new Generics<>(1, "Str", 11, 12);
//        System.out.println(generics.getA());
//        System.out.println(generics.getB());
//        System.out.println(generics.getC());
//        System.out.println(generics.getD());


        Generics<ABC, CDE, EFG> generics1 = new Generics<>(new ABC(), new CDE(), new EFG(), 12);
//        System.out.println(generics1.getA());
//        System.out.println(generics1.getB());
//        System.out.println(generics1.getC());
//        System.out.println(generics1.getD());

    }


    static class Calculate<T>{
        T t;

        public Calculate(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        void doCalculation(T a, T b, T c){
            System.out.println("First value is "+a+" Second value is "+b+" Third value is "+c);
        }

        String add(T a, T b, T c){
            return "" +a + b + c;
        }
    }

    static class Generics<A, B, C>{
        A a;
        B b;
        C c;

        int d;

        public Generics(A a, B b, C c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public A getA() {
            return a;
        }

        public B getB() {
            return b;
        }

        public C getC() {
            return c;
        }

        public int getD() {
            return d;
        }

    }


    static class ABC{
        @Override
        public String toString() {
            return "ABC";
        }
    }

    static class CDE{

    }

    static class EFG{

    }

}
