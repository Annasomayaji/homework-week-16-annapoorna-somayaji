Feature: Login Functionality ------------>contains-------------->TC2, TC3, TC4
  As a user, I would like to login by providing valid credentials


  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression
  Scenario: User should be on Home page
    When I observe the homepage
    Then I can view "Home" tab is selected

  @author_Annapoorna @smoke @regression
  Scenario: User should be able to Login and navigate to login page successfully
    When I click on "Signup / Login" from the top navigation bar
    Then I should see "Login to your account" in the heading

  @author_Annapoorna  @regression   #TC2
  Scenario: User should be able to Login and able to login successfully
    When I click on "Signup / Login" from the top navigation bar
    And I enter "annusom@gmail.com" and "Password1" in the credentials to login
    Then I can view "Logged in as" "Annu" tab is visible

  @author_Annapoorna  @regression  #TC3
  Scenario:User should not be able to Login with invalid credentials and error message should be displayed    When I click on "Signup / Login" from the top navigation bar
    When I click on "Signup / Login" from the top navigation bar
    And I enter "annu@gmail.com" and "Password1" in the credentials to login
    Then I can view "Your email or password is incorrect!" error message

  @author_Annapoorna @regression  #TC4
  Scenario:  User should be able to Login and Logout successfully
    When I click on "Signup / Login" from the top navigation bar
    And  I login with valid credentials "annusom@gmail.com" and "Password1"
    When I click on "Logout" from the top navigation bar
    Then I should see "Login to your account" in the heading