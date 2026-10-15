public final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public ImmutablePerson withAge(int newAge){
        return new ImmutablePerson(this.name, newAge);
    }

    public void displayDetails(){
        System.out.println("Name: " + this.name + " Age: " + this.age);
    }

    public static void main(String[] args){
        ImmutablePerson person1 = new ImmutablePerson("Kingstone", 20);
        ImmutablePerson person2 = person1.withAge(21); //a new object is returned
        person1.displayDetails();
        person2.displayDetails();
    }
}
