Feature: Adding employee
  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add employee button

  @smoke
  Scenario: Adding employee from add employee page
    And user enters firstname middlename and lastname
    And user clicks on save button option
    Then employee added successfully

  @smoke
  Scenario: Adding employee from add employee page via feature file
    And user enters first name "Yulia123" middle name "MS" and last name "Yulia456"
    And user clicks on save button option
    Then employee added successfully

  @smoke
  Scenario Outline: Adding employee from add employee page via feature file
    And user enters "<FirstName>" "<MiddleName>" and "<LastName>" in the application
    And user clicks on save button option
    Then employee added successfully

    Examples:
      |FirstName |MiddleName|LastName|
      |Test123456| MS       |Test9876|
      |Test1212  | MS       |Test7654|
      |Test3232  | MS       |Test5454|

    @datatablewithheader
    Scenario: Adding multiple employee in a single execution
      When add multiple employee and verify they are added successfully
        |FirstName |MiddleName|LastName|
        |Test1234564| MS       |Test987633|
        |Test121233  | MS       |Test765433|
        |Test323212 | MS       |Test545433|
      |ram123     |chau      |chaula    |


      @excel
      Scenario: Adding the employee from excel file
        When user adds multiple employees from excel file from "newdata" sheet and verify they are added
        @dbconnection
        Scenario: Add employee and testing it from the backend
          And user enters first name "Yulia123" middle name "MS" and last name "Yulia456"
          And capture the employeeId
          And user clicks on save button option
          Then query the HRMS database
          And verify the data from frontend and backend