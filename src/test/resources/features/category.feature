Feature: Category Functionality'-------->Contains ------->TC18
  As a user, I like to be able to browse through different categories pf products

  Background: User navigates to home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression     #TC18
  Scenario: The user should see the category panel on left side of the page and can choose different categories
    Then I should see "CATEGORY" in the heading
    When I select the "Women" category
    And I select the sub category "Dress"
    Then I should see "WOMEN - DRESS PRODUCTS" in the heading
    When I select the "Men" category
    And I select the sub category "TShirts"
    Then I can see "Men > Jeans" in breadcrumb