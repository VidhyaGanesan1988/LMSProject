Feature: User Details DialogBox
  
  
  Scenario: Verify the heading of User details window
    Given User is on Manage user page
    When User clicks Add new user button
    Then User should see User details window with heading "User Details"
    
  Scenario: Verify the presence of Cancel button in user details window
    Given User is on Manage user page
    When User clicks Add new user button
    Then User should see a button with text "Cancel" in user details window
    
   Scenario: Validating functionality of Cancel button 
     Given User is on User details window
     When User clicks cancel button
     Then User details window should be closed
     
   Scenario: Verify the presence of Cancel(x) icon in user details window
     Given User is on Manage user page
     When User clicks Add new user button
     Then User should see a cancel(x) "Cancel" icon in user details window
    
   Scenario: Validating functionality of Cancel(x) icon
      Given User is on User details window
      When User clicks cancel(X) icon
      Then User details dialog box should be closed
      
   Scenario: Verify the presence of Submit button in user details window
     Given User is on Manage user page
     When User clicks Add new user button
     Then User should see a button with text submit "Submit" in user details window
     
   Scenario: Verify the presence of Label Texts
     Given User is on Manage user page
     When User clicks Add new user button
     Then User should see all the placeholders displayed 

   Scenario: verify state drop down menu
     Given User is on User details window
     When User clicks the drop down icon for state 
     Then User should see drop down menu options for state 
     
   Scenario: verify user role drop down menu
     Given User is on User details window
     When User clicks the drop down icon for user role 
     Then User should see drop down menu options for user role
     
   Scenario: Validating the User details window with all fields empty
     Given User is on User details window
     When User clicks save button with all fields empty   
     Then User should see a message "Mandatory Fields cannot be empty"
     
   Scenario Outline: Validating the User details window with valid inputs 
     Given User is on User details window
     When User clicks Save button by entering all valid values from "<SheetName>" and <Rownumber> 
     Then New User Should be Saved
     
   Examples: 
      | SheetName        | Rownumber | 
      | ValidUserDetails |     0     |
     
   Scenario Outline: Validating the User details window with invalid inputs
     Given User is on User details window
     When User clicks Save button by entering invalid values from "<SheetName>" and <Rownumber> 
     Then User should see the erorr message "Invalid Input"
     
   Examples: 
      | SheetName          | Rownumber | 
      | InvalidUserDetails |     0     |
      | InvalidUserDetails |     1     |
      | InvalidUserDetails |     2     |
      | InvalidUserDetails |     3     |
      | InvalidUserDetails |     4     |
      | InvalidUserDetails |     5     |
     
    Scenario: Verifying the presence of Add Address2 button
      Given User is on Manage user page
      When User clicks Add new user button
      Then User should see the button with text "Add New User"
      
    Scenario: Validating the function of Add Address2 button
      Given User is on User details window
      When User clicks the button + Add C/O, Apt, Suite, Unit
      Then User should see "Address2" option
      
    Scenario: Verifying the presence of input number arrows in postal code input field
      Given User is on User details window
      When User clicks postal code input field
      Then User should see the input number arrows in the postal code input field