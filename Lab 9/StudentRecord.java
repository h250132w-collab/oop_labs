record StudentRecord(String name, int id, double gpa){
    public StudentRecord{
        if (gpa < 0.0 || gpa > 4.0){
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
    }
}