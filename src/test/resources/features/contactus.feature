Feature: Contact Us Functionality--------------->Contains-------->TC6
  As a user, I would like to be able to get in touch with the company using the contact us form

  Background: Url is launched and user is on home page
    Given I navigated to homepage

  @author_Annapoorna @sanity @smoke @regression   #TC6   using send keys to upload
  Scenario: User is able to submit the contact us for successfully
    Given I am on "Contact us" page and van view "GET IN TOUCH" heading
    When I provide information "Annu", "annusom@gmail.com", "Refund request", "Please refund my order no 345", "C:\Users\annus\Desktop\contact.txt" on the form and submit
    Then I should be able to view the success message "Success! Your details have been submitted successfully."
    When I click on Home button
    Then I can view "Home" tab is selected



  @author_Annapoorna @sanity @smoke @regression   #TC6 using Robot class to upload
  Scenario: User is able to submit the contact us for successfully using "ROBOT" class to "UPLOAD"
    Given I am on "Contact us" page and van view "GET IN TOUCH" heading
    When I provide information "Annu", "annusom@gmail.com", "Refund request", "Please refund my order no 345", "C:\Users\annus\Desktop\contact.txt" and submit
    Then I should be able to view the success message "Success! Your details have been submitted successfully."
    When I click on Home button
    Then I can view "Home" tab is selected

