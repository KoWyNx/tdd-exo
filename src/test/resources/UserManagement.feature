Feature: User account management
  As a user, I want to create an account and log in to the system.

  Scenario: Successful account creation
    Given a user with the email "email@test.com", username "username", and password "password123"
    When the user tries to create an account
    Then the account should be created successfully
    And the user should be able to find the account by the username "username"

  Scenario: Account creation with an existing username
    Given a user with the email "existing@test.com", username "existingUser", and password "password123"
    And the account already exists
    When the user tries to create a new account with the username "existingUser"
    Then the account creation should fail

  Scenario: Successful login
    Given a user with the username "username" and password "password123"
    And the account exists in the system
    When the user tries to log in with the correct credentials
    Then the login should be successful

  Scenario: Failed login with wrong password
    Given a user with the username "username" and password "wrongPassword"
    And the account exists in the system
    When the user tries to log in with the wrong password
    Then the login should fail
