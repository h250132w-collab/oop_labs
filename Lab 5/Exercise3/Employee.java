public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculatePay(){
        return this.baseSalary;
    }

    public static void main(String[] args){
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("Alice", 1200.0);
        employees[1] = new Manager("Bob", 2000.0, 500.0);
        employees[2] = new Developer("Kingstone", 1800.0, 10, 15.0);
        employees[3] = new Intern("Danny", 300.0);

        double totalPayroll = 0;
        for (Employee employee : employees){
            System.out.println(employee.name + " earns " + employee.calculatePay());
            totalPayroll += employee.calculatePay();
        }
        System.out.println("Total payroll: " + totalPayroll);
    }
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, double baseSalary, double bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay(){
        return this.baseSalary + this.bonus;
    }
}

class Developer extends Employee{
    private int overtimeHours;
    private double overtimeRate;

    public Developer(String name, double baseSalary, int overtimeHours, double overtimeRate){
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculatePay(){
        return this.baseSalary + (this.overtimeHours * this.overtimeRate);
    }
}

class Intern extends Employee{
    public Intern(String name, double stipend){
        super(name, stipend);
    }

    @Override
    public double calculatePay(){
        return this.baseSalary;
    }
}
