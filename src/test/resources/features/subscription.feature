Feature: Subscription functionality------>Contains----------->TC10,TC11
  As a user, I would like to be able to subscribe to updates

  Background:   Background: Url is launched and user is on home page
    Given I navigated to homepage


  @author_Annapoorna @Sanity @smoke @regression  #TC10
  Scenario: User should be able to subscribe to updates in home page by providing email
    When I scroll down to the footer and verify the heading
    Then I should see "SUBSCRIPTION" in the heading
    #append the below email with random string in the Object repo page to get unique email each time
    And I am able to subscribe successfully with email "annus@gmail.com"

  @author_Annapoorna @smoke @regression     #TC11
  Scenario: User should be able to subscribe in cart page by providing email
    Given I am on " Cart" page
    When I scroll down to the footer and verify the heading
    Then I should see "SUBSCRIPTION" in the heading
    #append the below email with random string in the Object repo page to get unique email each time
    And I am able to subscribe successfully with email "annus@gmail.com"

