package com.example.java_training_august_2023.interface_tut;

public class VehicleFactory {
    Car vehicle;
    public VehicleFactory(Car vehicle){
        this.vehicle = vehicle;
        int wheels = this.vehicle.noOfWheels;
    }
}
