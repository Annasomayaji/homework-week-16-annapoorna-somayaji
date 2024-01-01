Feature: Brand Functionality-------->Contains----->TC19
  As a user, I like to be able to check out different brands

  Background: User navigates to home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression #TC19     # first set of data working unpredictably
  Scenario Outline: User should be able to view brands on the left side panel and choose different brands
    When I click on " Products" from the top navigation bar
    Then I should see "BRANDS" in the heading
    When I select a brand from sheet name "<sheetName>" and row number "<rowNumber>"
    Then I should see brand name from sheet name "<sheetName>" and row number "<rowNumber>" in the heading
    And I should see brand products are displayed
    When I click on another brand "BABYHUG"
    Then I should see "BRAND - BABYHUG PRODUCTS" in the heading
    And I should see brand products are displayed

    Examples:
      | sheetName | rowNumber |
      | Sheet1    | 0         |
      | Sheet1    | 1         |
      | Sheet1    | 2         |




