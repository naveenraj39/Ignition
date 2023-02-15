
Feature: Login Test
 
  Scenario: Verification of login page finctions
    Given driver "https://ignition.stag.triomics.in/login"
    And delay(4000)
    And input("//*[@type="email"]","naveenraj@triomics.in")
