package com.example.java_training_march_2023.interface_class;

public class UseHuman {
    Animal animal;
    Dog dog;
    Cat cat;

    public UseHuman(Animal animal) {
        this.animal = animal;
    }

    public UseHuman(Dog dog) {
        this.dog = dog;
    }

    public UseHuman(Cat cat) {
        this.cat = cat;
    }

    void implementAnimal(){
        this.animal.eat();
    }

    void implementDog(){
        this.dog.bark();
    }
    void implementCat(){
        this.cat.meau();
    }
}
