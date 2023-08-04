package com.example.java_training_august_2023.access_modifier.medium;

import com.example.java_training_august_2023.access_modifier.basic.Book;

public class Magazine extends Book {
    void printAccessibleValues(){
//        System.out.println(modifierOne); // can't access default modifier in child class and in another package
        System.out.println(modifierTwo);
//        System.out.println(modifierThree); // can't access private modifier in child class and in another package
        System.out.println(modifierFour);
    }
}
