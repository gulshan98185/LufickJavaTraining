package com.lufick.java_lib.interface_example;

public class Example {
    public static void main(String[] args) {
        Dog dog = new PetAnimal();
        dog.bark();
        dog.eat();
        dog.breathe();
        dog.wander();
        //dog.meaw();


        /*Dog.ABC.drink();
        Dog.ABC abc = new Dog.ABC();
        abc.eat();*/

        //We can access variable defined in interface but cannot assign or change value
        //System.out.println(dog.a);
        //dog.a = 15;

        //dog.fire();
    }
}

class PetAnimal implements Zumba{

    @Override
    public void eat() {
        System.out.println("Eating....");
    }

    @Override
    public void breathe() {
        System.out.println("Breathing....");
    }

    @Override
    public void bark() {
        System.out.println("Barking....");
    }

    @Override
    public void guard(int hrs) {
        System.out.println("Guarding "+hrs+" hrs.....");
    }

    @Override
    public void guard(String min) {
        System.out.println("Guarding "+ min + " min.....");
    }

    //    @Override
//    public void guard() {
//        System.out.println("Guarding....");
//    }

    @Override
    public void meaw() {
        System.out.println("Meawing.....");
    }

    @Override
    public void fire() {
        System.out.println("Firing.....");
    }
}
