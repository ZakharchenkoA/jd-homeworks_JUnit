import accounts.*;

public class Main {
    public static void main(String[] args) {

        // во всех операциях перевода сначала пополняется целевой счет, затем списывается с текущего

        Account checkingAccount = new CheckingAccount("расчетный");
        Account creditAccount = new CreditAccount("кредитный");
        Account savingsAccount = new SavingAccount("сберегательный");

        checkingAccount.addMoney(10000); // баланс расчетного 10к
        checkingAccount.pay(1000); // баланс расчетного 9к
        creditAccount.pay(2000); // баланс кредитного -2к
        checkingAccount.transfer(savingsAccount, 5000); // сбер 5к, расчетный 4к
        savingsAccount.transfer(creditAccount, 3000); // превышен баланс
        savingsAccount.transfer(creditAccount,2000); // кредитный 0, сбер 3к
        creditAccount.transfer(savingsAccount, 11000); // себер 14к, кредитный -11к - комиссия
        savingsAccount.pay(500); // нельзя платить со сбера
        checkingAccount.pay(15000); // недостаточно средств

        creditAccount.transfer(creditAccount, 500); // перевод самому себе
    }
}
