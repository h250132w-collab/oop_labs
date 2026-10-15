public class Rectangle {
    protected double width;
    protected double height;

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double area(){
        return this.width * this.height;
    }

    public double perimeter(){
        return 2 * (this.width + this.height);
    }

    public static void main(String[] args){
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle(2, 3);
        rectangles[1] = new Rectangle(5, 4);
        rectangles[2] = new Rectangle(1.5, 8);
        rectangles[3] = new Rectangle(7, 3);
        rectangles[4] = new Rectangle(4, 4);

        Rectangle largest = rectangles[0];
        for (Rectangle rectangle : rectangles){
            if (rectangle.area() > largest.area()){
                largest = rectangle;
            }
        }

        System.out.println("Largest rectangle: " + largest.width + "x" + largest.height);
        System.out.println("Area: " + largest.area());
        System.out.println("Perimeter: " + largest.perimeter());
    }
}
