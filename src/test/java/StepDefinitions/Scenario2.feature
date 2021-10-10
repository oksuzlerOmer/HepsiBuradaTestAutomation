#Author: Omer OKSUZLER
#Scenario: user opens hepsiburada.com homepage, navigates under a category and adds a product to cart
Feature: navigating categories and adding to cart features


  Scenario: user opens hepsiburada.com homepage, navigates under a category and adds a product to cart
    Given the user has opened hepsiburada.com homepage on their browser
    And the user clicks on "Kitap, Müzik, Film, Hobi" text
    Given a dropdown menu opens
    When the user clicks "Uzaktan Kumandalý Araçlar"
    Given the user should be redirected to "https://www.hepsiburada.com/uzaktan-kumandali-arabalar*"
    Then the user moves the cursor over the third product
    Given "Sepete ekle" button becomes visible
    And the user clicks "Sepete ekle" button (sc2)
    Then a green "Sepete Eklendi" button should be displayed
    And the user, from left, under "Kategori", clicks "Drone Yedek Parçalarý" 
    Then the user moves the cursor over a sixth product in the list
    And the user clicks "Sepete ekle" button (sc2)
    Then a green "Sepete Eklendi" button should be displayed
    
    
    