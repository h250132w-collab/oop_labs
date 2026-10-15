import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>{
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;
    private int size = 0;

    public void add(T item){
        Node<T> newNode = new Node<>(item);
        if (this.head == null){
            this.head = newNode;
        } else {
            Node<T> current = this.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator<T> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>{
        private Node<T> current = head;

        @Override
        public boolean hasNext(){
            return this.current != null;
        }

        @Override
        public T next(){
            if (this.current == null){
                throw new NoSuchElementException();
            }
            T data = this.current.data;
            this.current = this.current.next;
            return data;
        }
    }

    public static void main(String[] args){
        LinkedList<String> names = new LinkedList<>();
        names.add("Kingstone");
        names.add("Alice");
        names.add("Bob");

        System.out.println("List size: " + names.size());
        for (String name : names){
            System.out.println(name);
        }
    }
}
