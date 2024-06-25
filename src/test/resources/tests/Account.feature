Feature: Account statement

  Background:
    Given Account exists for Acc No. "12345678" with Name "Bob Smith"
    And deposits are made
      | INIT | 200 |
      | DEP1 | 100 |
      | DEP2 | 450 |
      | DEP3 | 50  |
    And withdrawals are made
      | CHQ001 | 675.55 |
    When statement is produced


  @regression
  Scenario: Statement includes account details
    Then statement includes "Name: Bob Smith"
    * statement includes "Account: 12345678"

  @regression
  Scenario: Balance is calculated on the statement
    Then statement includes "Balance: 124.45"

  @regression
  Scenario: Statement includes transaction details
    Then statement includes "INIT"
    * statement includes "DEP1"
    * statement includes "DEP2"
    * statement includes "DEP3"
    * statement includes "CHQ001"
    
  @edge
	Scenario: Account with empty name
  	Given Account exists for Acc No. "12345679" with Name ""
 		Then an error should occur with message "Account name cannot be empty"
	
	@edge
  Scenario: Deposit zero amount
    Given Account exists for Acc No. "12345680" with Name "Alice Johnson"
    And deposits are made
      | INIT | 0 |
    Then an error should occur with message "Deposit amount must be positive"

  @edge
  Scenario: Deposit negative amount
    Given Account exists for Acc No. "12345681" with Name "Alice Johnson"
    And deposits are made
      | INIT | -100 |
    Then an error should occur with message "Deposit amount must be positive"

    