Feature: Registration Form
Background:
Given User is on LMS website
When User lands on Registration page
Scenario: Validating the heading of Registration form
Then User sees the Registration Form heading on the form as "Registration Form"
Scenario: Validating the Login button visibility
Then User sees a button with text Login on the form
Scenario: Validating the Login button functionality
When User clicks on Login button
Then User lands on Log in page
Scenario: Validating the Sign Up button visibility
Then User sees a button with text Sign Up on the form
Scenario Outline: Validating the text fields on Registration Form page
When User clicks on Sign Up button after entering "<FirstName>" "<LastName>" "<HouseNumber>" "<streetName>" "<city>" "<state>" "<zip>" "<birthDate>"  "<phno>" "<username>" "<password>" "<email>"
Then User Registraion should get error message as "enter valid data"
Examples:
|FirstName|LastName|HouseNumber|streetName|city|state|zip|birthDate|phno|username|password|email|
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|abcd|admin@123|    |
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|	10/22/1990|9872345619|abcd|     |abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|    |admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|abcd|admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|10/22/1990| 			|abcd|admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|Naperville|illinois|60504|					|9872345619|abcd|admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|Naperville|				  |	60504|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|chesapeake drive|					|illinois|60504|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
|Pinku|Sharma|4321|									|Naperville|illinois|60504|10/22/1990|9872345619|abcd|admin@123|abcd@gmail.com|
|Pinku|Sharma|		|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
|Pinku|				|	4321	|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
|		  |	Sharma|	4321	|chesapeake drive|Naperville|illinois|60504|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
|	Pinku	|	Sharma|	4321	|chesapeake drive|Naperville|illinois|			|10/22/1990|9872345619|abcd| admin@123|abcd@gmail.com|
