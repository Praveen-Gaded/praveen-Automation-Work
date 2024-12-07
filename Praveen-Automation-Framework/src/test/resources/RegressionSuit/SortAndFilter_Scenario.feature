@SortAndFilter
Feature: Validate sort and filter functionality

  @SmokeTest
  Scenario Outline: Validate page is changing after applying sort and filter
    Given user is on home page after entering "<username>" and "<password>"
    When user click on Sort and filter dropdown
    And selects "<option>"
    Then items reflected according to sorted options

    Examples: 
      | username      | password     | option        |
      | standard_user | secret_sauce | Name (Z to A) |

  @RegressionTest
  Scenario Outline: validate page is updating after appling filter options
    Given user is on home page after entering "<username>" and "<password>"
    When user click on Sort and filter dropdown
    And selects "<option>"
    Then "<Filter Option>" is applied

    Examples: 
      | username      | password     | option              | Filter Option       |
      | standard_user | secret_sauce | Name (A to Z)       | Name (A to Z)       |
      | standard_user | secret_sauce | Name (Z to A)       | Name (Z to A)       |
      | standard_user | secret_sauce | Price (low to high) | Price (low to high) |
      | standard_user | secret_sauce | Price (high to low) | Price (high to low) |
