package com.example.java_training.interface_tut;

public class TestInterface {
    public static void main(String[] args) {
        BMW car = new BMW();
        car.stop();
//        car.minNoOfTyres = 4;
        System.out.println(car.minNoOfTyres);
    }
}
