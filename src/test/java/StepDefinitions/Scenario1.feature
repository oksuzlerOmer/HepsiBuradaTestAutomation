#Author: Omer OKSUZLER
#Feature: logging in, product searching, and adding products to cart.
#Scenario: user logs in, makes a product search, chooses one, and adds to cart from 2 different vendors
Feature: logging in, product searching, and adding products to cart features

  @Parallel
  Scenario Outline: user logs in, makes a product search, adds to cart from two different vendors.
    #firstPart
    Given the user has opened hepsiburada.com homepage on their browser
      And the user hovers over "Giriþ Yap" text
     Then the user clicks "Giriþ Yap" text in the dropdown menu
     Then check password input is existent
     When if existent enters <username> and <password>
      And user enters password as above
     Then the user clicks "Giriþ Yap" button
      And the user should be redirected to the homepage
    #secondPart
     Then the user clicks the search box
      And enters <searchString> and hits enter
     Then the second product in the results is clicked
    #thirdPart
     Then the user clicks "Sepete Ekle" from the first vendor
      And the user closes the modal
    Given the cart counter is 1
     Then the user clicks "Sepete Ekle" from the second vendor
    Given the cart counter is incremented

    Examples: 
      | username                | password     | searchString |
      | testhb6102021@gmail.com | rs8jhYx8AZ86 | abc          |
