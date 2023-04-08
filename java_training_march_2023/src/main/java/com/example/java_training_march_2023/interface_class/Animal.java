package com.example.java_training_march_2023.interface_class;

public interface Animal {
    int noOfParent = 2;
    void eat();
    void move();

    default void sleep(){
        System.out.println("Animal is sleeping");
    }
}

interface Dog extends Animal{
    default void run(){
        System.out.println("Dog is running");
    }
    void bark();
}

interface Cat extends Animal{
    default void run(){
        System.out.println("Cat is running");
    }
    void meau();
}
