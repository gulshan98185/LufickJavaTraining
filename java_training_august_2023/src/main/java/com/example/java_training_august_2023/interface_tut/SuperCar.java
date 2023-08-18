package com.example.java_training_august_2023.interface_tut;

public interface SuperCar extends Car, Truck{

    @Override
    default void move() {
        System.out.println(Truck.noOfWheels);
    }

}
