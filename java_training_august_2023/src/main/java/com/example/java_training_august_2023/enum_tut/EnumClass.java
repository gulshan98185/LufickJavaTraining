package com.example.java_training_august_2023.enum_tut;

import jdk.vm.ci.meta.Constant;

public class EnumClass {
    int x;
    static class Constant {
        static final int a = 80;
        static final int b = 81;
        static final int c = 82;
        static final int d = 83;
        static final int e = 84;
        static final int f = 85;
        static final int g = 86;
    }

    class Home{
        void doSomeThing(){
            doWhat(Vehicle.BUS);
        }

        void doWhat(Vehicle vehicle){
            System.out.println(vehicle.price);
        }
    }

    enum Road{

    }

    interface Work{
        void  doWork();
    }

    interface Garage{
        void  repair();
    }

    enum Vehicle implements Work, Garage{
        CAR(1000, "TATA"),
        BUS(1500, "TATA"),
        BIKE(50, "HERO"),
        TRUCK(2500, "EICHER");
        int price;
        String names;

        Vehicle(int price, String names){
            this.price = price;
            this.names = names;
        }

        @Override
        public void doWork() {
            System.out.println("Work is in progress");
        }

        @Override
        public void repair() {

        }
    }

    static Vehicle getVehicle(String name){
        for (Vehicle vehicle : Vehicle.values()){

            if(vehicle.toString()==name){
                return vehicle;
            }
        }
        return Vehicle.BIKE;
    }

    public static void main(String[] args) {
        /*int value = Constant.e;
        switch (value) {
            case 80:
                System.out.println("80");
                break;
            case 81:
                System.out.println("81");
                break;
            case 82:
                System.out.println("82");
                break;
            case 83:
                System.out.println("83");
                break;
            case 84:
                System.out.println("84");
                break;
            case 85:
                System.out.println("85");
                break;
            case 86:
                System.out.println("86");
                break;


        }*/
        String name = "TATA";
        int values = 88;
        Vehicle value = Vehicle.CAR;


//        value.doWork();
        switch (getVehicle("BIKE")) {
            case CAR:
                System.out.println(value.price);
                break;
            case BUS:
                System.out.println(value.names);
                break;
            case BIKE:
                System.out.println("82");
                break;
            case TRUCK:
                System.out.println("83");
                break;
        }
        Vehicle.BUS.repair();
    }
}
