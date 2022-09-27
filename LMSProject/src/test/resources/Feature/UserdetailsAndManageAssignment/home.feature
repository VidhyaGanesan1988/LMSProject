Feature: Home Page
Background:
Given User opens LMS website
When User is on Home page

Scenario: Verify that the title of the Home page is "LMS"
Then User verifies that title of the page is "LMS"
Scenario: Verifying the heading on the Home page
Then User should see LMS-Learing Management System heading
Scenario: Verifying the Program button visibility
Then User should see Program button on menu bar
Scenario: Verifying the Batch button visibility
Then User should see Batch button on the menu bar
Scenario: Verifying the User button visibility
Then User should see User button on the menu bar
Scenario: Verifying the Assignment button visibility
Then User should see Assignment button on the menu bar
Scenario: Verifying the Attendance button visibility
Then User should see Attendance button on the menu bar
Scenario: Verifying the Logout button visibility
Then User should see Logout button on the menu bar
#And quit browser