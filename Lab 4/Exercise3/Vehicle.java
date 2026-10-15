public class Vehicle {
    protected String brand;

    public Vehicle(String brand){
        this.brand = brand;
        System.out.println("Vehicle constructor called");
    }

    public static void main(String[] args){
        System.out.println("---Creating an ElectricCar---");
        ElectricCar car1 = new ElectricCar("Tesla", 4, 75);
        car1.displayInfo();
    }
}

class Car extends Vehicle{
    protected int doors;

    public Car(String brand, int doors){
        super(brand);
        this.doors = doors;
        System.out.println("Car constructor called");
    }
}

class ElectricCar extends Car{
    private int batteryKwh;

    public ElectricCar(String brand, int doors, int batteryKwh){
        super(brand, doors);
        this.batteryKwh = batteryKwh;
        System.out.println("ElectricCar constructor called");
    }

    public void displayInfo(){
        System.out.println("\nBrand: " + this.brand +
                "\nDoors: " + this.doors +
                "\nBattery: " + this.batteryKwh + " kWh");
    }
}
