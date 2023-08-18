package com.example.java_training_august_2023.interface_tut;

public interface Car extends Vehicle {
    int noOfWheels = 4;

    void applyGear();

    void applyBreak();

    void move(int speed);

    default void move(){
        System.out.println(minWheel);
    }
}
