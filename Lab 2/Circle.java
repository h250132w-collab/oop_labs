public class Circle {
    protected double radius;
    protected static int instanceCount = 0;

    public Circle(){
        this.radius = 1.0D;
        instanceCount++;
    }

    public Circle(double radius){
        this.radius = radius;
        instanceCount++;
    }

    public static void getInstanceCount(){
        System.out.println("The current object count is " + instanceCount);
    }

    public static void main(String[] args){
        Circle circle1 = new Circle(5);
        getInstanceCount();
        Circle circle2 = new Circle();
        getInstanceCount();
        Circle circle3 = new Circle();
        getInstanceCount();
        Circle circle4 = new Circle(2);
        getInstanceCount();

    }
}
