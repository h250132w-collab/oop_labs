public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount > 0){
            this.balance += amount;
        } else {
            System.out.println("Deposit must be more than 0");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount > this.balance){
            throw new InsufficientFundsException("Cannot withdraw " + amount + ". Balance is only " + this.balance);
        }
        this.balance -= amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public static void main(String[] args){
        BankAccount account1 = new BankAccount("Kingstone", 100.0);
        try {
            account1.withdraw(40.0);
            System.out.println("Balance: " + account1.getBalance());
            account1.withdraw(500.0);
            System.out.println("This line is never reached");
        } catch (InsufficientFundsException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Final balance: " + account1.getBalance());
    }
}
