package accounts;

public class Print {

    public void operationReport (Operations operation, int amount, int tax, Account thisAccount, Account interactingAccount) {
        System.out.println(operation.getAction() +
                (operation != Operations.ADD ? "\nСчет списания: " + thisAccount : "\nСчет зачисления: " + thisAccount) +
                (operation == Operations.TRANSFER ? "\nСчет зачисления: " + interactingAccount : "") +
                "\n" + (operation.getActionSumLabel()) + amount +
                (tax != 0 ? "\nКомиссия: " + tax : "") +
                "\nБаланс: " + thisAccount.getBalance() + "\n");
    }

    public void unavailableOperation () {
        System.out.println("Операция недоступна!\n");
    }

    public void insufficientFunds () {
        System.out.println("На счете недостаточно средств!\n");
    }

    public void overOfMaxLimit (int amount) {
        System.out.println("Баланс кредитного счета не может превышать 0.00 рублей.\n" +
                "Допустимая сумма для пополнения: " + (-amount) + " рублей\n");
    }
}


