Feature: Register User ------------> Contains------------>TC1, TC5

  As a user, I would like to register, create account and delete it

  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression
  Scenario: User should be on Home page
    When I observe the homepage
    Then I can view "Home" tab is selected

  @author_Annapoorna @smoke @regression
  Scenario: New user should be able to sign up and navigate to sign page successfully
    When I click on "Signup / Login" from the top navigation bar
    Then I should see "New User Signup!" in the heading
    And I enter following details to sign up
      | Annu              |
      | annusom@gmail.com |

  @author_Annapoorna @regression   #TC1 method 1
  Scenario: New user should be able to register successfully on sign up page (method 1 with data table)
    When I click on "Signup / Login" from the top navigation bar
    And I enter following details to sign up
      | Annu              |
      | annusom@gmail.com |
    And I enter following details to register
      | Mrs       |
      | Password1 |
      | 5         |
      | June      |
      | 2000      |
    And I select newsletter and special offers checkboxes
    And I enter following details to continue register
      | Annu          |
      | Som           |
      | 5 High View   |
      | United States |
      | Florida       |
      | Orlando       |
      | 345653        |
      | 07785436745   |
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
#    Then I can view "Logged in as Annu" tab is visible

  @author_Annapoorna @regression    #TC1 method 2
  Scenario Outline: New user should be able to register successfully on sign up page (Method 2 with scenario outline)
    When I click on "Signup / Login" from the top navigation bar
    And I enter "<name>","<email>","<title>","<password>","<date>","<month>","<year>","<fname>","<lname>","<address>","<country>","<state>","<city>","<zipcode>","<mobile>"
    And click on create account button
    Then I should see a success message "ACCOUNT CREATED!"
    When I click on continue button
    Then I can view "Logged in as" "<name>" tab is visible
    When I click on "Delete Account" from the top navigation bar
    Then I should see a success message "ACCOUNT DELETED!"
    And I click on Continue button in Account deleted page
    Examples:
      | name  | email            | title | password  | date | month | year | fname | lname | address     | country | state     | city  | zipcode | mobile      |
      | Annu  | annus@gmail.com  | Mrs   | Password1 | 5    | June  | 2000 | Annu  | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |
      | Anoop | anoops@gmail.com | Mr    | Password1 | 5    | June  | 2000 | Anoop | Som   | 5 High view | India   | Karnatake | Udupi | 765849  | 07734532904 |


  @author_Annapoorna @regression    #TC5
  Scenario: User should see the error message displayed for existing email
    When I click on "Signup / Login" from the top navigation bar
    And I sign up with "Annu" and existing email "annusom@gmail.com"
    Then I should see the error message "Email Address already exist!"


