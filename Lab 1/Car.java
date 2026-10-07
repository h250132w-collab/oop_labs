public class Car {
    protected String brand;
    protected int year;
    protected int mileage;

    public Car(String brand, int year, int mileage){
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public void displayInfo(){
        System.out.println("Brand of car: " + brand +
                "\nYear of manufacture: " + year +
                "\nMileage of car: " + mileage + "\n");
    }

    public boolean isAntique(){
        if ((2025 - this.year) <= 25){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args){
        Car car1 = new Car("Toyota", 1998, 222000);
        car1.displayInfo();
        Car car2 = new Car("Mazda", 2004, 120000);
        car2.displayInfo();
        Car car3 = new Car("Nissan", 2000, 50000);
        car3.displayInfo();

        System.out.println("Is car1 older than 25 years?: " + car1.isAntique());
        System.out.println("Is car2 older than 25 years?: " + car2.isAntique());
        System.out.println("Is car3 older than 25 years?: " + car3.isAntique());
    }
}