Feature: Edit the employee from table
   @homework
   Scenario: select the employee from employee table and edit the employee list
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    Then user select the employee from employee table
    And user click to the edit button
    Then user is able to edit the employee and save the employee