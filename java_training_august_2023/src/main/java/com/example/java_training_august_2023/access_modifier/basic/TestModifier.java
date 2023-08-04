package com.example.java_training_august_2023.access_modifier.basic;

public class TestModifier {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.modifierOne);
        System.out.println(book.modifierTwo);
//        System.out.println(book.modifierThree); // can't access private modifier in same package
        book.modifierFour = 29;
        System.out.println(book.modifierFour);
    }
}
