Feature: Login Page
Scenario: Testing the Login page with valid username and password

Given User access the browser
When user in login page "https://ignition.stag.triomics.in/login"
Then enter username "naveenraj@triomics.in" and password "Ignition@2023"
And click the login button
And select TPM from Dropdown
Then Close the browser