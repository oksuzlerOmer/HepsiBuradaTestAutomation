#Author Omer OKSUZLER
#Date 6 Oct 2021
#Description: Product searching feature


Feature: Feature of making a product search

  Scenario Outline: User is able to search for a product using the search box
  Given the user had opened the browser
  Given the user had opened "https://hepsiburada.com"
  Given the user had logged in
  Then the user clicks the search box
  And enters <searchString> and hits enter
  Then the second product in the results is clicked
  
  Examples:
  |searchString|
  |abc|