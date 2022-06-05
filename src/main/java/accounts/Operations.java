package accounts;

public enum Operations {
    PAY("Выполнен платёж.", "Сумма платежа: "),
    TRANSFER("Выполнен перевод.", "Сумма перевода: "),
    ADD("Счет пополнен.", "Сумма зачисления: ");

    private final String action;
    private final String actionSumLabel;

    Operations(String action, String actionSumLabel) {
        this.action = action;
        this.actionSumLabel = actionSumLabel;
    }

    public String getAction() {
        return action;
    }

    public String getActionSumLabel() {
        return actionSumLabel;
    }
}
