package com.example.java_training_march_2023.interface_class;

public class Human implements Dog, Cat {
    @Override
    public void eat() {
        System.out.println("Human is eating");
    }

    @Override
    public void move() {
        System.out.println("Human is moving");
    }


    @Override
    public void run() {
        Cat.super.run();
        Dog.super.run();
    }

    @Override
    public void bark() {
        System.out.println("Human is barking");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping");
    }

    @Override
    public void meau() {
        System.out.println("Human is meauing");
    }
}
