package com.cv.lib.enumTut;

public class EnumExample {
    interface  Work{
        void doWork();
    }
    enum Car{

    }

    class ABC{

    }

    static class Constant{
        public static final int a = 876;
        public static final int b = 876;
        public static final int c = 876;
        public static final int d = 876;
        public static final int e = 876;
        public static final int f = 876;
        public static final int g = 876;
    }

    enum Vehicle implements Work{
        CAR("car", 100), BUS("best", 1000),
        GHODA_GADI("tanga", 100), CYCLE("atlus", 5),
        SCOOTER("tvs", 70);
        String name;
        int price;
//        Work work;
        Vehicle(String name, int price/*, Work work*/){
            this.name = name;
            this.price = price;
//            this.work = work;
        }
        @Override
        public void doWork() {
            System.out.println("Work is doing");
        }
    }

    static class Vehical{
        public static final Vehical CAR = new Vehical();
        public static final Vehical BUS = new Vehical();
        public static final Vehical CYCLE = new Vehical();
        public static final Vehical SCOOTER = new Vehical();
        public static final Vehical GHODA_GADI = new Vehical();
    }

    static Vehicle getVehicle(int price){
        for (Vehicle v: Vehicle.values()) {
            if (v.price==price){
                return v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Vehicle vehicle = Vehicle.GHODA_GADI;
        System.out.println(vehicle.price);
        System.out.println(Vehicle.BUS.price);
        System.out.println(Vehicle.CYCLE.name);

        Vehicle.BUS.doWork();
        String name = vehicle.toString();

        String name1 = vehicle.name();
        int a = vehicle.compareTo(Vehicle.BUS);
        int o = vehicle.ordinal();

        System.out.println(a);
        System.out.println(o);
//        System.out.println(Vehicle.valueOf("bus".toUpperCase()));

        switch (vehicle){
            case BUS:
                System.out.println("Bus");
                break;
            case CAR:
                System.out.println("Car");
                break;
            case CYCLE:
                System.out.println("Cycle");
                break;
            case GHODA_GADI:
                System.out.println("Ghoda Gadi");
                break;
            case SCOOTER:
                System.out.println("Scooter");
                break;
        }

        /*int x = 2;
        switch (x){
            case 1:
                System.out.println("Bus");
                break;
            case 2:
                System.out.println("Car");
                break;
            case 3:
                System.out.println("Cycle");
                break;
            case 4:
                System.out.println("Ghoda Gadi");
                break;
            case 5:
                System.out.println("Scooter");
                break;
        }*/


        Vehicle vehicle1 = getVehicle(10000);
        System.out.println(vehicle1);
        String bus = Vehicle.BUS.toString();
        int priceBus = Vehicle.BUS.price;

        if (Vehicle.BUS==Vehicle.valueOf(bus)){
            System.out.println(bus);
        }

        switch (getVehicle(priceBus)){
            case BUS:
                System.out.println("Bus");
                break;
            case CAR:
                System.out.println("Car");
                break;
            case CYCLE:
                System.out.println("Cycle");
                break;
            case GHODA_GADI:
                System.out.println("Ghoda Gadi");
                break;
            case SCOOTER:
                System.out.println("Scooter");
                break;
        }
    }
}
