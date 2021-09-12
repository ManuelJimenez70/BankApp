package models;

public class OutOfBalanceException extends Exception {
    private static final String MESSAGE_OUT_OF_BALANCE = "Saldo Insuficiente";

    public OutOfBalanceException() {
        super(MESSAGE_OUT_OF_BALANCE);
    }
}
