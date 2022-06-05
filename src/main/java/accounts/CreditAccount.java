package accounts;

public class CreditAccount extends Account {
    public CreditAccount(String name) {
        super(name);
    }

    @Override
    public void pay(int amount) {
        balance -= amount;
        print.operationReport(Operations.PAY, amount, 0,this, null);
    }

    @Override
    public void transfer(Account account, int amount) {
        if (account == this) {
            print.unavailableOperation();
            return;
        }
        int tax = (amount < 10000) ? 400 : amount / 100 * 4;
        balance -= (amount + tax);
        account.addMoney(amount);
        print.operationReport(Operations.TRANSFER, amount, tax, this, account);
    }

    @Override
    public boolean addMoney(int amount) {
        if (balance + amount > 0) {
            print.overOfMaxLimit(balance);
            return false;
        }
        balance += amount;
        print.operationReport(Operations.ADD, amount, 0, this, null);
        return true;
    }
}

