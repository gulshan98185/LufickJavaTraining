package com.example.java_training_august_2023.access_modifier.basic;

public class Comics extends Book{

    void printAccessibleValues(){
        System.out.println(modifierOne);
        System.out.println(modifierTwo);
//        System.out.println(modifierThree); // can't access private modifier in child class
        modifierFour = 29;
        System.out.println(modifierFour);
    }
}
