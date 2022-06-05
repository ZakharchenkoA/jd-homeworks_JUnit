import accounts.Account;
import accounts.CheckingAccount;
import accounts.CreditAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    @DisplayName("Проверка работоспособности функции платёж")
    public void successPay() {
        Account tinkoff = new CreditAccount("Тинькофф");
        var result = 9000;

        tinkoff.setBalance(10_000);
        tinkoff.pay(1000);

        Assertions.assertEquals(result, tinkoff.getBalance());
    }

    @Test
    @DisplayName("Проверка работоспособности функции трансфер")
    public void successTransfer(){
        Account sberbank = new CreditAccount("Сбербанк");
        Account VTB = new CheckingAccount("ВТБ");
        var result = -2400;

        sberbank.transfer(VTB,2000);

        Assertions.assertEquals(result, sberbank.getBalance());
    }

    @Test
    @DisplayName("Проверка пополнения кредитного счета")
    public  void successAddMoney(){
        Account alpha = new CreditAccount("Альфабанк");
        var expected = 0;

        alpha.setBalance(-5000);
        alpha.addMoney(5000);

        Assertions.assertEquals(expected, alpha.getBalance());
    }
}
