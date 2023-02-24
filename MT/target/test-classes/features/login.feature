Feature: Login

  Scenario: Login existing account
    Given User is on login page
    When user enters valid credentials "borko.vranic@sixsentix.com" and "test1234"
    And chooses soldTo "300565214"
    Then user is logged in successfully


