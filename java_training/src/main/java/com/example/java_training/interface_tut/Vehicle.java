package com.example.java_training.interface_tut;

public interface Vehicle {
//    int minNoOfTyres = 2;
    void run();
    void start();

    default void stop(){
        System.out.println("Break is applying");
    }
}


interface Car extends Vehicle{
//    int minNoOfTyres = 4;

    void move(int speed);

    void autoGear();



}

interface Truck extends Vehicle{
//    int minNoOfTyres = 4;

    void powerfulEngine();

    void move(int speed);

}

interface SuperCar extends Car, Truck{

    @Override
    default void stop() {
        Car.super.stop();
    }
}

class BMW implements Truck, Car{
    int minNoOfTyres = 4;

    @Override
    public void run() {

    }

    @Override
    public void start() {

    }

    @Override
    public void powerfulEngine() {

    }

    @Override
    public void move(int speed) {

    }


    @Override
    public void autoGear() {

    }

    @Override
    public void stop() {
        System.out.println("Hard break is applying...");
    }
}

