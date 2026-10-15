public class InitOrder {
    static {
        System.out.println("Static block 1");
    }

    {
        System.out.println("Instance block 1");
    }

    public InitOrder(){
        System.out.println("Constructor");
    }

    static {
        System.out.println("Static block 2");
    }

    {
        System.out.println("Instance block 2");
    }

    public static void main(String[] args){
        System.out.println("main started");
        System.out.println("---Creating first object---");
        InitOrder object1 = new InitOrder();
        System.out.println("---Creating second object---");
        InitOrder object2 = new InitOrder();
    }
}
