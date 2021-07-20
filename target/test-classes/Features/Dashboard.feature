Feature: Dashboard tab functionality
    @smoke
  Scenario:  Dashboard tab verification
    When user is logged in with valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in
    Then verify the following tabs on Dashboard
      |Admin|PIM|Leave|Time|Recruitment|Performance|Dashboard|Directory|
