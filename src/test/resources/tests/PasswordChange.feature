@passwordchange
Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

  @regression
  Scenario: Successful password change
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "currentPassword"
    And User enters new password "newPassword1"
    And User confirms new password "newPassword1"
    When User submits the password change form
    Then Password change is successful

  @regression
  Scenario: Password change fails due to incorrect current password
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "incorrectPassword"
    And User enters new password "newPassword1"
    And User confirms new password "newPassword1"
    When User submits the password change form
    Then Password change fails with error "Incorrect current password"

  @regression
  Scenario: Password change fails due to password mismatch
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "currentPassword"
    And User enters new password "newPassword1"
    And User confirms new password "newPassword2"
    When User submits the password change form
    Then Password change fails with error "Passwords do not match"

  @regression
  Scenario: Password change fails due to password complexity rules not met
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "currentPassword"
    And User enters new password "weak"
    And User confirms new password "weak"
    When User submits the password change form
    Then Password change fails with error "Password must be at least 3 characters long and contain at least one digit"

  @edge
  Scenario: Password change fails due to empty new password
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "currentPassword"
    And User enters new password ""
    And User confirms new password ""
    When User submits the password change form
    Then Password change fails with error "New password cannot be empty"

  @edge
  Scenario: Password change fails due to new password being same as current password
    Given User is on the change password screen
    And User enters current username "username"
    And User enters current password "currentPassword"
    And User enters new password "currentPassword"
    And User confirms new password "currentPassword"
    When User submits the password change form
    Then Password change fails with error "New password cannot be the same as the current password"


