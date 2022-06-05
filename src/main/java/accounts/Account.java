package accounts;

public abstract class Account {

    Print print = new Print();
    int balance;
    String name;

    public Account(String name) {
        this.name = name;
    }

    public void pay(int amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            print.operationReport(Operations.PAY, amount,0,this, null);
        } else {
            print.insufficientFunds();
        }
    }

    public void transfer(Account account, int amount) {
        if (account == this) {
            print.unavailableOperation();
            return;
        }
        if (balance - amount >= 0) {
            if (account.addMoney(amount)) {
                balance -= amount;
                print.operationReport(Operations.TRANSFER, amount, 0, this, account);
            }
        } else {
            print.insufficientFunds();
        }
    }

    public boolean addMoney(int amount) {
        balance += amount;
        print.operationReport(Operations.ADD, amount, 0,this, null);
        return true;
    }

    public int getBalance() {
        return balance;
    }

    public String toString() {
        return name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
