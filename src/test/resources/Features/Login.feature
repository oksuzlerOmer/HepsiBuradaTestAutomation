#Author Omer OKSUZLER
#Date 6 Oct 2021
#Description: logging in feature

Feature: Feature of logging in
  
  Scenario Outline: Check login is successful
  Given the user opens browser
  Then the user opens "https://hepsiburada.com"
  And the user hovers over "Giriþ Yap" text
  Given a dropdown menu opens
  Then the user clicks "Giriþ Yap" text in the dropdown menu
  Then check password input is existent
  When if existent enters <username> and <password>
  And user enters password as above
  Then the user clicks "Giriþ Yap" button
  And the user should be redirected to the homepage
  
  Examples:
  |username|password|
  |testhb6102021@gmail.com|rs8jhYx8AZ86|
  |testhb6102021@gmail.com|wrongpassword|
  ||rs8jhYx8AZ86|
  |testhb6102021@gmail.com||
  #SQL Injection
  |' or 1=1|\' or 1=1|