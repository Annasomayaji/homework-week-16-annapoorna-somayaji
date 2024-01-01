Feature: Navigation Functionality------>Contains------>TC25,TC26
  As a user, I would like to navigate easily using page navigation features

  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression #TC25
  Scenario: User should be able to scroll up and down using page navigation
    Then I can view "Home" tab is selected
    When I scroll down to the footer and verify the heading
    Then I should see "SUBSCRIPTION" in the heading
    When I click on scroll up arrow
    Then I should see "Full-Fledged practice website for Automation Engineers" in the carousel heading

  @author_Annapoorna @smoke @regression @runonlythis   #TC26  #using JS Executor interface
  Scenario: User should be able to scroll up and down using JavaScript Executor
    Then I can view "Home" tab is selected
    When I scroll down to the footer and verify the heading
    Then I should see "SUBSCRIPTION" in the heading
    When I scroll back up the page
    Then I should see "Full-Fledged practice website for Automation Engineers" in the carousel heading

