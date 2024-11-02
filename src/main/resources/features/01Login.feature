Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should be redirected to the inventory page

  Scenario: Failed login with invalid credentials
    Given I am on the login page
    When I enter an empty username an empty and password
    And I click the login button
    Then I see message invalid credentials

  Scenario: Failed login with empty username
    Given I am on the login page
    When I enter an empty username and valid password
    And I click the login button
    Then I should see an error message indicating that the username is required

  Scenario: Failed login with empty password
    Given I am on the login page
    When I enter a valid username and an empty password
    And I click the login button
    Then I should see an error message indicating that the password is required