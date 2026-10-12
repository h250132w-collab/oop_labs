enum GradeLevel {
    FRESHMAN(0),
    SOPHOMORE(30),
    JUNIOR(60),
    SENIOR(90);

    private final int minimumCredits;

    GradeLevel(int min){
        this.minimumCredits = min;
    }

    boolean canGraduate(){
        return this.minimumCredits >= 90;
    }
}