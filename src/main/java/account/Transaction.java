package account;

public class Transaction {
    private String transactionId;
    private double amount;

    //Constructor to initialise Transaction with transaction ID and amount
    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    //Getter method for transaction ID
    public String getTransactionId() {
        return transactionId;
    }

    //Getter method for transaction amount
    public double getAmount() {
        return amount;
    }
}
