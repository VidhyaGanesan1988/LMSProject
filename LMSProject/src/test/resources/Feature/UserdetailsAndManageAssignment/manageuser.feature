
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
    
  Scenario: Verify the entry details below data table
     Given User is logged on to the LMS website
     When User lands on Manage User page
     Then User should see the text "Showing 1 to 4 of 4 entries" below the user table. 
     
  Scenario: Verify table footer  
     Given User is logged on to the LMS website
     When User lands on Manage User page
     Then User should see the table footer as "In total there are no of users". 
  
  Scenario: Verify the presence of Add new user button
     Given User is on any page after Login
     When User is on the Manage user page after clicking User menu
     Then User should see the button with text "Add New User"
     
   Scenario: Verify the functionality of Add new user button
     Given User is on Manage user page
     When User clicks Add New User button
     Then User should see the "User Details" modal dialog box
     
   Scenario: Verify Table header
     Given User is on any page after Login
     When User is on the Manage user page after clicking User menu
     Then User should see the table header as Empty checkbox-icon , ID with sort icon, Name with Sort icon, Email Address with sort icon,Contact Number with sort icon, Batch with sort icon, Skill with Sort icon, Edit/Delete as column names
     
   Scenario: Verify the functionality of sort icon present in table header
     Given User table is displayed in manage user page
     When User clicks sort icon in table header
     Then Table rows should be sorted
     
   Scenario: Verify Check box functionality in table header    
   	 Given User table is displayed in manage user page
   	 When User checks empty checkbox in header
   	 Then Check box in all the rows of user table should be checked
   	 
   Scenario: Verify the presence of Delete icon in manage user page
     Given User is on any page after Login
     When User is on the Manage user page after clicking User menu
     Then User should see the delete icon at the top left corner of the user table
     
   Scenario: Verify behavior of Delete icon when rows checked  
     Given User table is displayed in manage user page
     When User checks the rows in user table
     Then Delete icon at the top left corner of the user table enabled
     
   Scenario: Verify functionality of Delete icon when rows checked   	
     Given User table is displayed in manage user page
     When User clicks the delete icon after checking the row
     Then Confirm dialog box should display warning message
     
   Scenario: Validating Confirm dialog box by selecting Yes
     Given User is in confirm dialog box after clicking delete icon
     When User clicks button with text Yes    
     Then Selected rows should be deleted and popup should be shown with success message "Successful"
     
   Scenario: Validating Confirm dialog box by selecting No  
     Given User is in confirm dialog box after clicking delete icon
     When User clicks button with text No
     Then Selected rows should not be deleted and dialog box should be closed
     
   Scenario: Validating Confirm dialog box by clicking close(x) icon
     Given User is in confirm dialog box after clicking delete icon
     When User clicks the close(x) icon
     Then Confirm dialog box should be closed
     
   Scenario: Verify the presence of Edit/Delete icon in rows
     Given User is on any page after Login
     When User is on the Manage user page after clicking User menu
     Then User should see the buttons with edit/delete icon in each row of Edit/Delete coulmn
     
    Scenario: Validating delete button functionality in rows
      Given User table is displayed in manage user page   
      When User clicks delete button
      Then Confirm dialog box should display warning message "Are you sure you want to delete John Dove?"
     
    Scenario: Validating edit button functionality in rows
      Given User table is displayed in manage user page
      When User clicks Edit button
      Then User Details dialog box should be displayed for editing
     
     Scenario: Verify the presence of Input field for searching
       Given User is on any page after Login
       When User is on the Manage user page after clicking User menu
       Then User should see the Search input field after the delete icon
     
     Scenario: Validating search functionality
       Given User is on Manage user page
       When User types Name to search
       Then Rows with the name should be displayed 
     
     Scenario: Validating search functionality
       Given User is on Manage user page
       When User types random text in search field which has no matching entry
       Then No rows is displayed
     
     Scenario: Validating ID functionality
       Given User table is displayed in manage user page
       When User clicks ID in any row
       Then User details dialog box displayed with user information
       
     Scenario: Validating Cancel button functionality in user details dialog box
       Given User table is displayed in manage user page
       When User clicks cancel button in user details dialog box
       Then User details dialog box is closed
    