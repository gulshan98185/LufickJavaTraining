package com.lufick.java_lib;

import java.util.Locale;

public class CollectionJava {
    public static void main(String args[]) {
        /*Animal animal = new Animal("abc");
        Animal animal2 = new Animal("abc");
        animal.name = "abc";
        animal.setName("abc");*/

        Animal animal = Animal.getSingleObject();
        Animal anima2 = Animal.getSingleObject();
        Animal animal3 = Animal.getSingleObject();

        /*Animal animal = new Animal();
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();*/
        //System.out.println(animal.animal);;
    }
}
class Animal {
    private int age; //0
    private static Animal animal = null; //null

    private Animal(){

    }

    public static Animal getSingleObject(){
        if(animal == null){
            animal = new Animal();
        }
        return animal;
    }
}
