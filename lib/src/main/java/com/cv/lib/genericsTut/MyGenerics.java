package com.cv.lib.genericsTut;

public class MyGenerics {

    public static void main(String[] args) {

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Hii");
//        arrayList.add("20");
//        arrayList.add("false");
//        arrayList.add("1.0f");
//        String a = arrayList.get(2);
//        System.out.println(a);

        ABC abc = new ABC(2);
        CDE cde = new CDE(3);
        Generics<ABC, CDE, ABC> generics = new Generics<>(abc, cde, abc, 20);

//        Generics<CDE> generics2 = new Generics<>(cde, 20);
//        CDE abc1 = generics2.getT();

        ABC abc2 = generics.getT();
        CDE cde1 = generics.getB();
        ABC abc1 = generics.getC();

        Float f = 1.0F;
        Calculate<Float> calculate = new Calculate<>(f);
        calculate.doCalculation(1.0f, 2.0f, 3.0f);


        Calculate<Integer> calculate1  = new Calculate<>(2);
        calculate1.doCalculation(1, 3, 4);
    }
}


class ABC{
    int a;
    ABC(int a){
        this.a = a;
    }
}

class CDE{
    int a;
    CDE(int a){
        this.a = a;
    }
}

class Calculate<T>{
    T t;

    public Calculate(T t) {
        this.t = t;
    }

    void doCalculation(T a, T b, T c){
        System.out.println("First thing is "+a + " Second thing is "+b + " Third thing is "+c);
    }

    public T getT() {
        return t;
    }
}

class Generics<A, B, C>{
    A t;
    B b;
    C c;
    int a;
    Generics(A t, B b, C c, int a){
        this.t = t;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    A getT(){
        return t;
    }

    B getB(){
        return b;
    }
    C getC(){
        return c;
    }
}