Feature: endToEnd
@Smoke @MTMOUSDP
  Scenario: Place an order
    Given Logged User "borko.vranic@sixsentix.com" "test1234" is on Homepage
    When user Adds Product to cart using category bar
     And user opens Delivery address and checks mandatory fields
    And user Adds Delivery address
    And user Fills credit card data
#    user fills credit car number {234234} and exp date {2342342}
#  |id    | ex|
#  | 1111 |43434
    And user opens Billing address and checks mandatory fields
    And user Adds Billing address
    And user Checks the Data on Summary Page
    Then user Buys the Product

@Smoke @Rainin
Scenario: Place an order - Guest User
  Given User is on Login page as a guest
  When guest user adds product to cart using category bar
  And user adds Personal Information
  And user Adds Delivery address
  And user Fills credit card data
  And user Adds Billing address
  And user Checks the Data on Summary Page
  Then user Buys the Product


