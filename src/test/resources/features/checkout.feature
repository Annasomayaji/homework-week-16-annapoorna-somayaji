Feature: Checkout Functionality---------->Contains------->TC14,TC15,TC16,TC23,TC24
  As a user, I like to be able to checkout after adding items to cart


  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression
  Scenario: User is able to add products to cart and checkout
    When I add "2nd" item to cart
    Then I can view "Cart" tab is selected

  @author_Annapoorna @smoke @regression     #TC14 part 1
  Scenario Outline: User is able to add products and successfully register on checkout
    When I add "2nd" item to cart
    And I proceed to checkout
    And I click on Register and Login link
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
    Then I can view "Logged in as" "<name>" tab is visible

    Examples:
      | name | email           | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu | annus@gmail.com | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |

  @author_Annapoorna  @regression    #TC14 part1+part2
  Scenario Outline: User is able to add products to cart and register while checkout and checkout
    When I add "2nd" item to cart
    And I proceed to checkout
    And I click on Register and Login link
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    And I click on continue button
    And I click on "Cart" from the top navigation bar
    And I proceed to checkout
    Then I can see the address details
      | YOUR DELIVERY ADDRESS   |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi  Karnatake 765849 |
      | India                   |
      | 07734532904             |

    And I can see order details

      | Men > Tshirts |
      | Rs. 400       |
      | Rs. 400       |
      | 1             |
    And I enter comment "<Please deliver through special delivery>" and place order
    And I enter payment information name "Annu Som", card number "12345623", CVC "123", Expiration "06", Year "2025"
    And I place order
    Then I should see "ORDER PLACED!" in the heading
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page


    Examples:
      | name | email           | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu | annus@gmail.com | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |

  @author_Annapoorna  @regression  #TC15
  Scenario Outline: User is able to add products to cart and register before checkout and checkout
    When I click on "Signup / Login" from the top navigation bar
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
    Then I can view "Logged in as" "<name>" tab is visible
    When I add "2nd" item to cart
    Then I can view "Cart" tab is selected
    When I proceed to checkout
    Then I can see the address details
      | YOUR DELIVERY ADDRESS   |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi  Karnatake 765849 |
      | India                   |
      | 07734532904             |
    And I can see order details
      | Men > Tshirts |
      | Rs. 400       |
      | Rs. 400       |
      | 1             |
    And I enter comment "<Please deliver through special delivery>" and place order
    And I enter payment information name "Annu Som", card number "12345623", CVC "123", Expiration "06", Year "2025"
    And I place order
    Then I should see "ORDER PLACED!" in the heading
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page

    Examples:
      | name | email           | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu | annus@gmail.com | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |


  @author_Annapoorna  @regression      #TC16
  Scenario: User is able to add products to cart and login before checkout and checkout
    When I click on "Signup / Login" from the top navigation bar
    And I enter "annusom@gmail.com" and "Password1" in the credentials to login
    Then I can view "Logged in as" "Annu" tab is visible
    When I add "2nd" item to cart
    Then I can view "Cart" tab is selected
    When I proceed to checkout
    Then I can see the address details
      | YOUR DELIVERY ADDRESS   |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi  Karnatake 765849 |
      | India                   |
      | 07734532904             |
    And I can see order details
      | Men > Tshirts |
      | Rs. 400       |
      | Rs. 400       |
      | 1             |
    And I enter comment "<Please deliver through special delivery>" and place order
    And I enter payment information name "Annu Som", card number "12345623", CVC "123", Expiration "06", Year "2025"
    And I place order
    Then I should see "ORDER PLACED!" in the heading
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page


  @author_Annapoorna  @regression     #TC23
  Scenario Outline: User can verify address details in checkout page
    When I click on "Signup / Login" from the top navigation bar
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
    Then I can view "Logged in as" "<name>" tab is visible
    When I add "2nd" item to cart
    Then I can view "Cart" tab is selected
    When I proceed to checkout
    Then I can see the address details
      | YOUR DELIVERY ADDRESS   |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi Karnatake 765849 |
      | India                  |
      | 07734532904             |
    And I can see the billing address details
      | YOUR BILLING ADDRESS    |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi Karnatake 765849 |
      | India                   |
      | 07734532904             |
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page

    Examples:
      | name | email             | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu | annuabc@gmail.com | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |


  @author_Annapoorna @regression     #TC24
  Scenario Outline: User is able to add products and successfully register on checkout and download invoice
    When I add "2nd" item to cart
    And I proceed to checkout
    And I click on Register and Login link
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
    Then I can view "Logged in as" "<name>" tab is visible
    When I click on "Cart" from the top navigation bar
    And I proceed to checkout
    Then I can see the address details
      | YOUR DELIVERY ADDRESS   |
      | Mrs. Annu Som           |
      | 5 High view             |
      | Udupi Karnatake 765849 |
      | India                   |
      | 07734532904             |
    And I can see order details
      | Men > Tshirts |
      | Rs. 400       |
      | Rs. 400       |
      | 1             |
    And I enter comment "<Please deliver through special delivery>" and place order
    And I enter payment information name "Annu Som", card number "12345623", CVC "123", Expiration "06", Year "2025"
    And I place order
    Then I should see "ORDER PLACED!" in the heading
    When I download invoice and verify download for file "invoice.txt"
    And I click on continue button
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page


    Examples:
      | name | email           | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu | annus@gmail.com | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |




