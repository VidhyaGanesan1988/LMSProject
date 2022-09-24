
Feature: Manage User Menu

  
  Scenario: Verify landing in Manage User page
    Given User is on any page after Login
    When User clicks the USER menu
    Then User should land on Manage user page

  Scenario: Verify the Manage user page header
    Given User is on any page after Login
    When User is on the Manage user page after clicking User menu
    Then User should see the page header as "Manage User"
    
  Scenario: Verify the presence of pagination
    Given User is on any page after Login
    When User is on the Manage user page after clicking User menu
    Then User should see the pagination controls below data table
    
  Scenario: Verify the Pagination control with more than 5 rows
    Given User is on Manage user page
    When Manage user table has more than or equal to five rows
    Then Pagination control should be enabled
    
  Scenario: Verify pagination next link
    Given User table is displayed in manage user page
    When User cliks next link of pagination
    Then Next page with table records should be displayed
    
  Scenario: Verify pagination Previous link
    Given User table is displayed in manage user page  
    When User cliks previous link of pagination
    Then Previous page should be displayed
    
  Scenario: Verifiy the entry details below data table
     Given User is logged on to the LMS website
     When User lands on Manage User page
     Then User should see the text "Showing no of entries" below the user table. 
     
  Scenario: Verify table footer  
     Given User is logged on to the LMS website
     When User lands on Manage User page
     Then User should see the table footer as "In total there are no of users". 
  
  Scenario: Verify the presence of Add new user button
     Given User is on any page after Login
     When User is on the Manage user page after clicking User menu
     Then User should see the button with text "+Add New User"
     
   #Scenario: Verify the functionality of Add new user button
     #Given User is on Manage user page
     #When User clicks Add New User button
     #Then User should see the "User details" modal dialog box
     #
      #
