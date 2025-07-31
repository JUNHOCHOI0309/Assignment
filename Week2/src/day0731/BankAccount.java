package day0731;

public class BankAccount {// 과제 10
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
    public int getBalance(){
        return balance;
    }

    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount(100000);
        accounts[1] = new BankAccount(200000);
        accounts[2] = new BankAccount(300000);

        accounts[0].deposit(10000);
        accounts[1].withdraw(200000);
        accounts[2].deposit(1500000);

        int sum = 0;
        for(BankAccount account : accounts){
            sum += account.getBalance();
        }

        System.out.println("계좌 잔액 합계: "+sum+"원");
    }
}
