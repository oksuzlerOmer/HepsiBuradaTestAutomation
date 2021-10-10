#Author: Omer OKSUZLER
#Feature: logging in, product searching, and adding products to cart.
#Scenario: user logs in, makes a product search, chooses one, and adds to cart from 2 different vendors
Feature: logging in, product searching, and adding products to cart features

  @Parallel
  Scenario Outline: user logs in, makes a product search, adds to cart from two different vendors.
    #firstPart
    Given the user has opened hepsiburada.com homepage on their browser
      And the user hovers over "Giri� Yap" text
    Given a dropdown menu opens
     Then the user clicks "Giri� Yap" text in the dropdown menu
     Then check password input is existent
     When if existent enters <username> and <password>
      And user enters password as above
     Then the user clicks "Giri� Yap" button
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

 
  Scenario: user opens hepsiburada.com homepage, navigates under a category and adds a product to cart
    #firstPart
    Given the user has opened hepsiburada.com homepage on their browser
      And the user clicks on "Kitap, M�zik, Film, Hobi" text
    Given a dropdown menu opens
     When the user clicks "Uzaktan Kumandal� Ara�lar"
    Given the user should be redirected to "https://www.hepsiburada.com/uzaktan-kumandali-arabalar*"
     Then the user moves the cursor over the third product
    Given "Sepete ekle" button becomes visible
      And the user clicks "Sepete ekle" button (sc2)
     Then a green "Sepete Eklendi" button should be displayed
      And the user, from left, under "Kategori", clicks "Drone Yedek Par�alar�"
     Then the user moves the cursor over a sixth product in the list
      And the user clicks "Sepete ekle" button (sc2)
     Then a green "Sepete Eklendi" button should be displayed
