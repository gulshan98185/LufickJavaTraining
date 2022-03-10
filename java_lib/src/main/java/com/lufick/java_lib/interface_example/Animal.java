package com.lufick.java_lib.interface_example;

public interface Animal {
    void eat();
    void breathe();
}

interface Dog extends Animal{
    void bark();
    void guard(int hrs);
    default void wander(){
        System.out.println("Wandering...");
    }

    class ABC implements Dog{
        static void drink(){
            System.out.println("Drinking....");
        }

        @Override
        public void eat() {
            System.out.println("ABC is Eating.....");
        }

        @Override
        public void breathe() {

        }

        @Override
        public void bark() {

        }

        @Override
        public void guard(int hrs) {

        }
    }

}

interface Cat extends Animal{
    int a = 10;
    void meaw();
    void guard(String min);
}


interface Zumba extends Dog, Cat{
    void fire();
}