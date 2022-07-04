package com.cv.lib.interfaceTut;

public interface Vehicle {
    int a = 40;
    void start();
    void run();
    default void stop(){
        System.out.println("vehicle is stopping");
    }
}

interface Car extends Vehicle{
    int noOfWheel = 4;
    void autoGear();
    void move();
    void move(int a);
}

interface Truck extends Vehicle{
    void powerfulEngine();
    void move();
    void move(String name);
}

interface SuperCar extends Truck, Car{

}

class UseVehicle implements SuperCar{
    @Override
    public void start() {
        System.out.println("Vehicle is starting ");
    }

    @Override
    public void run() {
        System.out.println("Vehicle is running");
    }

//    @Override
//    public void stop() {
//        System.out.println("Vehicle is stopping");
//    }

    @Override
    public void autoGear() {
        System.out.println("Vehicle shifting auto gear");
    }

    @Override
    public void powerfulEngine() {
        System.out.println("Vehicle using powerful enging");
    }

    @Override
    public void move() {
        System.out.println("Vehicle is moving");
    }

    @Override
    public void move(String name) {

    }

    @Override
    public void move(int a) {

    }
}


