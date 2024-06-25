package account;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private String accountHolderName;
    private String accountNumber;
    private List<String> lines;

    //Constructor to initialise Statement with account details
    public Statement(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.lines = new ArrayList<>();
    }

    //Method to add a line to the statement
    public void addLine(String line) {
        lines.add(line);
    }

    //Method to check if the statement contains a specific line
    public boolean contains(String line) {
        return lines.contains(line);
    }

    //Method to retrieve all lines in the statement
    public List<String> getLines() {
        return lines;
    }
}
