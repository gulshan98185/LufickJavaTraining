package com.example.java_training_august_2023.access_modifier.medium;

import com.example.java_training_august_2023.access_modifier.basic.Book;

public class TestModifierOne {
    public static void main(String[] args) {
        Book book = new Book();
        System.out.println(book.modifierTwo);
//        System.out.println(book.modifierOne); // can't access default modifier in another package
//        System.out.println(book.modifierThree); // can't access private modifier in another package
//        System.out.println(book.modifierFour); // can't access protected modifier in another package
        System.out.println(book.getModifierOne()); // can't access default modifier in another package
        System.out.println(book.getModifierThree()); // can't access private modifier in another package
        System.out.println(book.getModifierFour()); // can't access protected modifier in another package
    }
}
