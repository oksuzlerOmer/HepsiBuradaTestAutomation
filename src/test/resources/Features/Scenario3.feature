#Author: Omer OKSUZLER
#Scenario: the user adds 8 products to their cart and proceeds to the delivery options screen
Feature: adding different products to cart and choosing from different delivery options

  @smoke
  Scenario: the user adds eight products to their cart and proceeds to the delivery options screen
    Given the user logged in
    Given the user has added random eight products to their cart.
    Given the user opens their cart
    When the user clicks "Alýþveriþi tamamla" button (sc3)
    Then the user is navigated to delivery options phase.
    Given the user had already defined two different delivery addresses.
    Then the number of items grouped in the delivery options should match the count in the actual cart.
    Then the delivery options should change according to the selected delivery address.
    Given a delivery option with more cost than the default exists.
    Then the user selects the extra cost option
    And the extra cost should be added to the cart total.
    Then the approximately calculated shipping dates should not be later than the calculated delivery dates.
    
    