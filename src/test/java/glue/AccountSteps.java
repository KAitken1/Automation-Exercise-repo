package glue;

import account.Account;
import account.Statement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountSteps {

    private static final Logger logger = LoggerFactory.getLogger(AccountSteps.class);

    //Fields to store account and statement
    Account account = null;
    Statement statement = null;
    String lastErrorMessage = ""; //Field to store the last error message

    //Step to create an account with a given number and name
    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
        try {
            logger.info("Creating account with Acc No: {} and Name: {}", number, name);
            account = new Account(number, name);
            logger.debug("Account created: {}", account);
        } catch (IllegalArgumentException e) {
            logger.warn("Failed to create account: {}", e.getMessage());
            lastErrorMessage = e.getMessage(); //Capture the error message
        }
    }

    //Step to check for an error message
    @Then("an error should occur with message {string}")
    public void anErrorShouldOccurWithMessage(String expectedMessage) {
        assertTrue("Expected error message is not present!", lastErrorMessage.contains(expectedMessage));
    }

    //Step to deposit amounts into the account
    @Given("deposits are made")
    public void depositsAreMade(Map<String, Double> deposits) {
        for (Map.Entry<String, Double> deposit : deposits.entrySet()) {
            try {
                logger.info("Depositing amount: {} with transactionId: {}", deposit.getValue(), deposit.getKey());
                account.deposit(deposit.getKey(), deposit.getValue());
                logger.debug("Deposit successful: {}", deposit);
            } catch (IllegalArgumentException e) {
                logger.warn("Failed to deposit amount: {}", e.getMessage());
                lastErrorMessage = e.getMessage(); 
            }
        }
    }

    //Step to withdraw amounts from the account
    @Given("withdrawals are made")
    public void withdrawalsAreMade(Map<String, Double> withdrawals) {
        for (Map.Entry<String, Double> withdrawal : withdrawals.entrySet()) {
            try {
                logger.info("Withdrawing amount: {} with transactionId: {}", withdrawal.getValue(), withdrawal.getKey());
                account.withdraw(withdrawal.getKey(), withdrawal.getValue());
                logger.info("Withdrawal successful: {}", withdrawal);
            } catch (IllegalArgumentException e) {
                logger.warn("Failed to withdraw amount: {}", e.getMessage());
                lastErrorMessage = e.getMessage(); // Capture the error message
            }
        }
    }

    //Step to generate a statement
    @When("statement is produced")
    public void statementIsProduced() {
        logger.info("Generating statement for account: {}", account);
        statement = account.generateStatement();
        logger.debug("Statement generated: {}", statement);
    }

    //Step to verify the statement includes a specific line
    @Then("statement includes {string}")
    public void statementIncludes(String line) {
        logger.info("Verifying statement includes line: {}", line);
        assertTrue(statement.getLines().contains(line));
        logger.debug("Verification successful for line: {}", line);
    }
}
