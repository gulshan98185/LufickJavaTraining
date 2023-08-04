package com.example.java_training_august_2023;

import com.example.java_training_august_2023.access_modifier.basic.Book;

public class MyClass {
    public static void main(String[] args) {
        Book book = new Book();
        book.modifierTwo = 50;
        System.out.println(book.modifierTwo);
//        System.out.println(book.modifierOne);
//        System.out.println(book.modifierThree);
//        System.out.println(book.modifierFour);
    }
}