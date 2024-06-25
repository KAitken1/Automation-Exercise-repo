package account;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private List<Transaction> transactions;

    //Constructor to initialise Account with account number and holder name
    public Account(String accountNumber, String accountHolderName) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account name cannot be empty");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.transactions = new ArrayList<>();
    }

    //Method to deposit funds into the account
    public void deposit(String transactionId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        transactions.add(new Transaction(transactionId, amount));
    }

    //Method to withdraw funds from the account
    public void withdraw(String transactionId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        transactions.add(new Transaction(transactionId, -amount));
    }

    //Method to generate a statement with account details and transactions
    public Statement generateStatement() {
        Statement statement = new Statement(accountHolderName, accountNumber);

        //Add account details to statement
        statement.addLine("Name: " + accountHolderName);
        statement.addLine("Account: " + accountNumber);

        //Add transactions to statement
        for (Transaction transaction : transactions) {
            statement.addLine(transaction.getTransactionId());
        }

        //Calculate and format balance to two decimal places
        double balance = calculateBalance();
        DecimalFormat df = new DecimalFormat("#.##");
        statement.addLine("Balance: " + df.format(balance));

        return statement;
    }

    //Private method to calculate total balance from transactions
    private double calculateBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }
}
