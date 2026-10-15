import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void push(T item){
        this.items.add(item);
    }

    public T pop(){
        if (this.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return this.items.remove(this.items.size() - 1);
    }

    public T peek(){
        if (this.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        return this.items.get(this.items.size() - 1);
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public static void main(String[] args){
        Stack<Integer> numbers = new Stack<>();
        numbers.push(10);
        numbers.push(20);
        numbers.push(30);
        System.out.println("Top of stack: " + numbers.peek());
        System.out.println("Popped: " + numbers.pop());
        System.out.println("Popped: " + numbers.pop());
        System.out.println("Is the stack empty?: " + numbers.isEmpty());

        Stack<String> words = new Stack<>();
        words.push("goofy");
        System.out.println("Popped: " + words.pop());

        try {
            words.pop();
        } catch (RuntimeException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
