package com.example.java_training_march_2023.interface_class;

public class InterfaceImpl {
    public static void main(String[] args) {
        Human human = new Human();
//        human.eat();
//        human.sleep();
//        human.run();
        System.out.println("Human has "+ human.noOfParent + " parents");

        UseHuman useHuman = new UseHuman((Animal) human);
        useHuman.implementAnimal();
    }
}
