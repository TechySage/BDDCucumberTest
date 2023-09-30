

Feature: Customer

Background:

    Given User lunch Chrome browser
    When User open the application URL"https://admin-demo.nopcommerce.com/login"
    And User Enters emailId as"admin@yourstore.com" and password as"admin"
    And Click on login button
    Then User can view dasboard
    When User click on the customer menu 
    And Click on the customer menu item


   @sanity @regression
   Scenario: Add new Customer
   
    And Click on Add new button
    Then user can view add new customer page
    When User enter customer info
    And  Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And  Close browser
    Then print message successful
    
    @regression
    Scenario:Search a Customer by email
    And Enter customer Email
    When  click on the search button
    Then user should found the email in the search table
    And Close browser
    
    @regression
    Scenario:Search a Customer by email
    And Enter customer first Name
    And Enter customer last name
    When  click on the search button
    Then user should found the name in the search table
    And Close browser
    
    
 
    



  
