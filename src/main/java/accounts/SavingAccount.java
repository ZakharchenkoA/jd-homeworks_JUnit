package accounts;

public class SavingAccount extends Account{

    public SavingAccount(String name) {
        super(name);
    }

    @Override
    public void pay(int amount) {
        print.unavailableOperation();
    }
}



