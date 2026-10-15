public class Employee {
    private static int counter = 1000;
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(){
        this("Unknown", "Unassigned", 0.0);
    }

    public Employee(String name){
        this(name, "Unassigned", 0.0);
    }

    public Employee(String name, String department, double salary){
        counter++;
        this.employeeId = counter;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(Employee other){
        this(other.name, other.department, other.salary);
    }

    public void displayInfo(){
        System.out.println("ID: " + this.employeeId +
                "\nName: " + this.name +
                "\nDepartment: " + this.department +
                "\nSalary: " + this.salary + "\n");
    }

    public static void main(String[] args){
        Employee employee1 = new Employee();
        Employee employee2 = new Employee("Kingstone");
        Employee employee3 = new Employee("Alice", "Finance", 1500.0);
        Employee employee4 = new Employee(employee3);
        employee1.displayInfo();
        employee2.displayInfo();
        employee3.displayInfo();
        employee4.displayInfo(); //same data as employee3 but a new id
    }
}
