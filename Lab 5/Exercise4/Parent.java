public class Parent {
    protected String name = "Parent field";

    public void show(){
        System.out.println("Parent method");
    }

    public static void main(String[] args){
        Parent object1 = new Child();
        object1.show(); //method is chosen by the actual object
        System.out.println(object1.name); //field is chosen by the reference type
        Child object2 = (Child) object1;
        System.out.println(object2.name);
    }
}

class Child extends Parent{
    protected String name = "Child field";

    @Override
    public void show(){
        System.out.println("Child method");
    }
}
