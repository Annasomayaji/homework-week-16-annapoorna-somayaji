Feature: Cart Functionality------------>Contains---------->TC12,TC13,TC17,TC20,TC22
  As a user, I would like to be able to add products and remove them and checkout

  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression #TC12
  Scenario: User is able to add products to cart
    When I click on " Products" from the top navigation bar
    And I add "1st" item to cart continue shopping
    And I add "2nd" item to cart
    Then I am able to see the right products with product name , price , quantity and total price in the cart
      | Blue Top   | Rs. 500 | 1 | Rs. 500 |
      | Men Tshirt | Rs. 400 | 1 | Rs. 400 |


  @author_Annapoorna @smoke @regression #TC13
  Scenario Outline: User is able to add products to cart and increase quantity
    When I click on " Products" from the top navigation bar
    And  I click on the "<nth>" item
    Then I am on product information page
    When I increase quantity to number "4" and add
    And I view cart
    Then I can see quantity number "4" for product name "<productName>" in the cart for the product

    Examples:
      | nth | productName |
      | 1st | Blue Top    |
      | 2nd | Men Tshirt  |

  @author_Annapoorna @regression  #using excel data    #TC17
  Scenario Outline: User is able to remove products from cart
    When I select a product to add to cart from sheet name "<sheetName>" and row number "<rowNumber>"
    And I view cart
    And I click on delete item icon
    Then I can see that the product from sheet name "<sheetName>" and row number "<rowNumber>" is removed

    Examples:
      | sheetName | rowNumber |
      | Sheet1    | 0         |
      | Sheet1    | 1         |

  @author_Annapoorna  @regression    #TC20
  Scenario Outline: User is able to search for a product,add to cart, login and still be able to view added products in cart

    When I click on " Products" from the top navigation bar
    And I enter product name to search from sheet name "<sheetName>" and row number "<rowNumber>"
    Then I am able to view the "SEARCHED PRODUCTS" in the result
   # And I can view the products related to search from sheet name "<sheetName>" and row number "<rowNumber>"
    When I select a product to add to cart from from the search result sheet name "<sheetName>" and row number "<rowNumber>"
    And I view cart
    Then I am able to see the right products with product name , price , quantity and total price in the cart
      | Sleeveless Dress | Rs. 1000 | 1 | Rs. 1000 |
#      | Blue Top         | Rs. 500  | 1 | Rs. 500  | #need to work on getting only second row from DataTable
#      | Men Tshirt       | Rs. 400  | 1 | Rs. 400  |
    When I click on "Signup / Login" from the top navigation bar
    And I enter "annusom@gmail.com" and "Password1" in the credentials to login
    And I click on "Cart" from the top navigation bar
    Then I am able to see the right products with product name , price , quantity and total price in the cart
      | Sleeveless Dress | Rs. 1000 | 1 | Rs. 1000 |
#      | Blue Top         | Rs. 500  | 1 | Rs. 500  |
#      | Men Tshirt       | Rs. 400  | 1 | Rs. 400  |

    Examples:
      | sheetName | rowNumber |
      | Sheet1    | 0         |
#      | Sheet1    | 1         |
#      | Sheet1    | 2         |

  @author_Annapoorna  @regression     #TC22
  Scenario: User is able to add to cart from recommended products
    When I scroll to recommended items and add an item "Stylish Dress"
    And I view cart
    Then I am able to see the right products with product name , price , quantity and total price in the cart
      | Stylish Dress | Rs. 1500 | 1 | Rs. 1500 |








