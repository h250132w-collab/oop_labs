import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private String owner;
    private double balance;
    private ArrayList<String> history = new ArrayList<>();

    public BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
        this.history.add("Account opened with " + balance);
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
            this.history.add("Deposited " + amount);
        } else {
            System.out.println("Deposit must be more than 0");
        }
    }

    public boolean withdraw(double amount){
        if ((amount > 0) && (amount <= this.balance)){
            this.balance -= amount;
            this.history.add("Withdrew " + amount);
            return true;
        } else {
            this.history.add("Failed withdrawal of " + amount);
            return false;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public List<String> getHistory(){
        return Collections.unmodifiableList(new ArrayList<>(this.history));
    }

    public static void main(String[] args){
        BankAccount account1 = new BankAccount("Kingstone", 100.0);
        account1.deposit(50.0);
        account1.withdraw(30.0);
        account1.withdraw(500.0);

        System.out.println("Balance: " + account1.getBalance());
        System.out.println("---Transaction History---");
        for (String entry : account1.getHistory()){
            System.out.println(entry);
        }

        try {
            account1.getHistory().add("Fake transaction");
        } catch (UnsupportedOperationException e){
            System.out.println("\nHistory cannot be modified from outside");
        }
    }
}
