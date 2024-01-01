Feature: --------------->Contains------------>TC7
  As a user, I like to navigate to test cases page


  @author_Annapoorna @sanity @smoke @regression
  Scenario: User should be on Home page
    Given I navigated to homepage
    When I observe the homepage
    Then I can view "Home" tab is selected


  @author_Annapoorna @smoke @regression   #TC7
  Scenario: User should be able to navigate to test cases page successfully
    Given I navigated to homepage
    When I click on "Test Cases" from the top navigation bar
    Then I am able to view "TEST CASES" in the heading
