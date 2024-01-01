Feature: Products Functionality -------->Contains TC8,TC9, TC21
  As a user, I like to be able to view all products and click on individual product, submit a review

  Background: User navigates to home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression
  Scenario: User should be on Home page
    When I observe the homepage
    Then I can view "Home" tab is selected

  @author_Annapoorna @smoke @regression #TC8  #using excel data
  Scenario Outline: User should be able to view products and click on individual products for details
    When I click on " Products" from the top navigation bar
    Then I should see "ALL PRODUCTS" in the heading
    When I click on the "1st" item
    Then I am on product information page
    And I can view product details from sheet name "<SheetName>" and row number "<RowNumber>"

    Examples:
      | SheetName | RowNumber |
      | Sheet1    | 0         |

  @author_Annapoorna @regression    #TC9
  Scenario Outline: User is able to search for a product
    When I click on " Products" from the top navigation bar
    And I enter product name from sheet name "<sheetName>" and row number "<rowNumber>"
    Then I am able to view the "SEARCHED PRODUCTS" in the result
   And I can view the products related to search from sheet name "<sheetName>" and row number "<rowNumber>"

    Examples:
      | sheetName | rowNumber |
      | Sheet1    | 0         |
      | Sheet1    | 1         |
      | Sheet1    | 2         |

  @author_Annapoorna @regression    #TC21
  Scenario: User should be able to view products and submit a review
    When I click on " Products" from the top navigation bar
    Then I should see "ALL PRODUCTS" in the heading
    When I click on the "1st" item
    Then I should see "WRITE YOUR REVIEW" is visible
    When I submit review with name "Annu", email "Annu@gmail.com", review message "An excellent product"
    Then I should see a success message "Thank you for your review." displayed


