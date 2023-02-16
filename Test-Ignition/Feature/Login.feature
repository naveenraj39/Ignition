Feature: Login Page
Scenario: Testing the Login page with valid username and password

Given User access the browser
When user in login page "https://ignition.stag.triomics.in/login"
Then enter username "naveenraj@triomics.in" and password "Hello@123"
And click the login button
And select from Dropdown
Then Close the browser