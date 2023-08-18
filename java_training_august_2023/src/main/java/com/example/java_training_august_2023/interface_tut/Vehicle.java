package com.example.java_training_august_2023.interface_tut;

public interface Vehicle {
    int minWheel = 2;
    void start();

    void run();

    default void stop(){
        System.out.println("Stopping the vehicle");
    }
}
