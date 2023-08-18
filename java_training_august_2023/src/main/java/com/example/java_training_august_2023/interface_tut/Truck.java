package com.example.java_training_august_2023.interface_tut;

public interface Truck extends Vehicle{
    int noOfWheels = 6;

    void powerfulEngine();

    void move();

    void move(int speed);
}
