public class Student {
    private String name, studentId;
    private double marks = -1;

    public void setName(String name){
        this.name = name;
    }

    public void setID(String studentId){
        this.studentId = studentId;
    }

    public void setMarks(double marks){
        if ((marks >= 0.0) && (marks <= 100.0)){
            this.marks = marks;
        } else {
            System.out.println("Mark is invalid. Marks must be between 0.0 and 100.0");
        }
    }

    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.studentId;
    }

    public double getMarks(){
        return this.marks;
    }

    public String getGrade(){
        if (this.getMarks() >= 80){
            return "A";
        } else if ((this.getMarks() >= 70) && (this.getMarks() <= 79)){
            return "B";
        } else if ((this.getMarks() >= 60) && (this.getMarks() <= 69)){
            return "C";
        } else if ((this.getMarks() >= 0) && (this.getMarks() <= 59)){
            return "F";
        } else {
            return "Invalid Mark";
        }
    }

    public static void main(String[] args){
        Student student1 = new Student();
        student1.setID("132W");
        student1.setName("Kingstone Chikodze");
        student1.setMarks(134);
        Student student2 = new Student();
        student2.setID("428H");
        student2.setName("Abednico Nyadayo");
        student2.setMarks(52);

        System.out.println("Student Details");
        System.out.println(student1.getName() + " (ID: " + student1.getID() + ") Grade: " + student1.getGrade());
        System.out.println(student2.getName() + " (ID: " + student2.getID() + ") Grade: " + student2.getGrade());
    }
}
