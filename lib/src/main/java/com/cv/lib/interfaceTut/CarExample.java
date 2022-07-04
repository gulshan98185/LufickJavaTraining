package com.cv.lib.interfaceTut;

public class CarExample {
    public static void main(String[] args) {
        Vehicle useVehicle = new UseVehicle();
        useVehicle.start();
        useVehicle.stop();
//        useVehicle.move();
//        useVehicle.autoGear();
//        useVehicle.powerfulEngine();
        useVehicle.run();
    }
}
