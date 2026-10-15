public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    public static void main(String[] args){
        Dog dog1 = new Dog("Rex");
        System.out.println("Dog name: " + dog1.name);
    }
}
