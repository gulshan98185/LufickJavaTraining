package com.example.java_training_august_2023.interface_tut;

public class TestInterface {
    public static void main(String[] args) {
        UseVehicle useVehicle = new UseVehicle();
//        useVehicle.applyGear();
//        useVehicle.move(50);
//        useVehicle.move();
        useVehicle.run();
//        useVehicle.applyBreak();
//        useVehicle.powerfulEngine();
        useVehicle.start();
        useVehicle.stop();

        VehicleFactory vehicleFactory = new VehicleFactory(useVehicle);
    }
}
