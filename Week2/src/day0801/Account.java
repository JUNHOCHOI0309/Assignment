package day0801;

public class Account {
    public int balance;
    public String owner;
    public Account(int balance, String owner){
       this.balance = balance;
       this.owner = owner;
    }

    public void deposit(int amount){
        balance += amount;
    }
    public void deposit(String date, int amount){
        balance += amount;
        System.out.println(date + " 날에 " + amount + "원이 입금완료 되었습니다.");
    }

    public void withdraw(int amount){//수수료 방식이 다름.
        balance -= amount;
    }

    public static void main(String[] args) {
        Account[] accounts = new Account[2];

        accounts[0] = new SavingsAccount(1000000000, "RHO");
        accounts[1] = new CheckingAccount(1000000,"CHOI");
        accounts[0].deposit(10000);
        accounts[1].deposit(20000);
        accounts[0].withdraw(10000);
        accounts[1].withdraw(20000);

        accounts[0].deposit("2020-08-01", 10000);
        accounts[1].deposit("2020-08-02", 20000);

        for(Account account : accounts){
            System.out.println(account.owner +" 님의 잔액은" + account.balance + "원 입니다.");
        }
    }
}

class SavingsAccount extends Account{
    public SavingsAccount(int balance, String owner){
        super(balance, owner);
    }

    public void withdraw(int amount){
        amount -= 1000;
        super.withdraw(amount);
    }
}

class CheckingAccount extends Account{
    public CheckingAccount(int balance, String owner){
        super(balance, owner);
    }

    public void withdraw(int amount){
        amount -= 500;
        super.withdraw(amount);
    }
}
