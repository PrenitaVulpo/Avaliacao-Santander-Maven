package Enums;

public enum OperationType {
    WITHDRAW("SAQUE"),
    DEPOSIT("DEPOSITO");

    public final String label;

    OperationType(String label) {
        this.label = label;
    }

}
