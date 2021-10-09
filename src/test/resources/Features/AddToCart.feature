#Author Omer OKSUZLER
#Date 6 Oct 2021
#Description: add to cart feature


Feature: Feature of adding any product to cart
  Scenario: The user can add any product from any vendor to their shopping cart
  Given the user had opened any product page
  Then the user clicks "Sepete Ekle" from the first vendor
  And the user closes the modal
  Given the cart counter is 1
  Then the user clicks "Sepete Ekle" from the second vendor
  Given the cart counter is incremented