public abstract class Animal {
    public abstract void makeSound();

    public static void main(String[] args){
        Animal[] animals = new Animal[3];
        animals[0] = new Cat();
        animals[1] = new Dog();
        animals[2] = new Cow();
        for (Animal animal:animals){
            animal.makeSound();
        }
    }
}

class Dog extends Animal{
    public void makeSound(){
        System.out.println("Woof");
    }
}

class Cat extends Animal{
    public void makeSound(){
        System.out.println("Meow");
    }
}

class Cow extends Animal{
    public void makeSound(){
        System.out.println("Moo");
    }
}

