@Login_Scenario
Feature: Login Scenario

  @SmokeTest
  Scenario Outline: Validate login scenario
    Given user is on login page
    When user enters "<username>" and "<password>"
    And click on login button
    Then user should be navigated to home page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |

  @RegressionTest
  Scenario Outline: Validate Regression Scenario for login page
    Given user is on login page
    When user enters "<username>" and "<password>"
    And click on login button
    Then "<Result>" is displayed for "<inputType>"

    Examples: 
      | username       | password      | inputType                   | Result                             |
      | standard_user  | secret_sauce  | valid Data                  | User should be landed on home page |
      | standard_user1 | secret_sauce2 | invalid Data                | input data is invalid              |
      | standard_user  |               | only with username          | password is empty                  |
      |                | secret_sauce  | only with password          | username is empty                  |
      |                |               | empty username and password | username and password required     |
