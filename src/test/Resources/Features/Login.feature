Feature:Login

  Scenario: valid admin login
    When user is logged in with valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

    Scenario: valid ess employee login
      When user enters valid ess username and password
      And user clicks on login button
      Then ess user is successfully logged in

      Scenario: login with valid username and invalid password
        When user enter valid username and invalid password
        And user clicks on login button
        Then user see invalid credentials text on login page

  Scenario Outline: Login with multiple data
    When user enter "<username>" and "<password>"
    And user clicks on login button
    And "<firstname>" is successfully logged in
    Examples:
    |username|password|firstname|
    |Admin   |Hum@nhrm123|Admin |
    |william1236000000|Syntax12!!!!|William|



    Scenario: Login with valid username and invalid password
      When user enter valid username and invalid password and verify the error
      |username|password|errormessage|
      |Admin   |Hum@|Admin |
      |william1236000000|!!!!|William|


  Scenario Outline: Login with multiple username and password combination
    When user enters different "<usernamevalue>" and "<passwordvalue>" and verify the "<error>" for all the combinations
    Examples:
      |usernamevalue|passwordvalue|error|
      | Admin      | Hum@nhrm   | Invalid credentials |
      |abd77       |Hum@nhrm123!|Invalid credentials|
      |James       |            |Password cannot be empty|
      |            |Syntax123!  |Username cannot be empty|