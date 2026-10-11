public abstract class GraphicObject{
    protected int x,y;

    public void moveTo(int newX, int newY){
        this.x = newX;
        this.y = newY;
        System.out.println("New object position = x:" + this.x + " y:" + this.y);
    }

    abstract void draw();

    public static void main(String[] args){
        RectangleObject rectangle1 = new RectangleObject(44,20, 5.5, 8);
        CircleObject circle1 = new CircleObject(14,2, 8.4);
        circle1.draw();
        circle1.moveTo(5,22);
        circle1.draw();

        System.out.println("---Before Resizing Rectangle---");
        rectangle1.draw();

        System.out.println("---After Resizing Rectangle---");
        rectangle1.resize(2);
        rectangle1.draw();
    }
}

interface Resizable{
    public void resize(double factor);
}

class CircleObject extends GraphicObject{
    private double radius;

    public CircleObject(int x, int y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw(){
        System.out.println("Drawing a circle at (" + this.x + ", " + this.y + ") with radius " + this.radius);
    }
}

class RectangleObject extends GraphicObject implements Resizable{
    private double width;
    private double height;

    public RectangleObject(int x, int y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(){
        System.out.println("Drawing a rectangle at (" + this.x + ", " + this.y + ") with size " + this.width + "x" + this.height);
    }

    @Override
    public void resize(double factor) {
        this.width = this.width * factor;
        this.height = this.height * factor;
    }
}