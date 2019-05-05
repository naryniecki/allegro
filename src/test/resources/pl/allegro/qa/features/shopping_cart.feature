Feature: Shopping cart
    Add, remove items to the cart, check content

@gui
Scenario: Add two most expensive items to the shopping cart
     Given e-shop site is open
     When I choose "Supermarket" category
     And I chose "Kawa" subcategory
     And I sort result by price descending
     And I add two top items from the list to the shopping cart
     Then I have two items in the shopping cart

#@api
#Scenario: Add two most expensive itents to the shopping cart
#    Given I have a valid token
#    When I get the list of items from a category
#    And I choose two most expensive
#    And I send a request to add two most expensive items to the shopping cart
#    Then when I get content of my cart
#    And I have two items in it