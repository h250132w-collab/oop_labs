public class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args){
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = r1; //copies the reference, not the object
        System.out.println("r1.width before: " + r1.width);
        r2.width = 10;
        System.out.println("r1.width after changing r2.width: " + r1.width);
        System.out.println("Do r1 and r2 point to the same object?: " + (r1 == r2));
    }
}
