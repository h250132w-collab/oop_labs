public class Student extends Person{
    private String studentId;
    private String major;

    public Student(String name, int age, String studentId, String major){
        super(name, age);
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Major: " + this.major);
    }

    public static void main(String[] args){
        Person student1 = new Student("Kingstone", 20, "S12", "Software Engineering");
        student1.displayDetails();
    }
}
