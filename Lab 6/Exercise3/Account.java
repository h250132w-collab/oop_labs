public abstract class Account {
    protected String owner;
    protected double balance;

    public Account(String owner, double balance){
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

    public abstract double monthlyFee();

    public static void main(String[] args){
        Account[] accounts = new Account[3];
        accounts[0] = new SavingsAccount("Kingstone", 500.0);
        accounts[1] = new SavingsAccount("Alice", 2500.0);
        accounts[2] = new CurrentAccount("Bob", 800.0);

        accounts[0].deposit(100.0);
        for (Account account : accounts){
            System.out.println(account.owner + " balance: " + account.balance + " monthly fee: " + account.monthlyFee());
        }
    }
}

class SavingsAccount extends Account{
    public SavingsAccount(String owner, double balance){
        super(owner, balance);
    }

    @Override
    public double monthlyFee(){
        if (this.balance >= 1000){
            return 0.0;
        } else {
            return 5.0;
        }
    }
}

class CurrentAccount extends Account{
    public CurrentAccount(String owner, double balance){
        super(owner, balance);
    }

    @Override
    public double monthlyFee(){
        return 15.0;
    }
}
