@E2E_Checkout
Feature: Validate E2E Checkout

  @SmokeTest @RegressionTest
  Scenario Outline: Validate Checkout for any item
    Given user is on logged in with "<Username>" and "<password>" and adds "<Count>" items to cart
    When user navigate to cart page and click on checkout, then  enters "<FirstName>" "<LastName>" and "<ZipCode>"
    And user clicks continue, they are directed to checkout overview page
    Then user clicks finish, the order confirmation message is displayed

    Examples: 
      | Username      | password     | Count | FirstName | LastName | ZipCode |
      | standard_user | secret_sauce |     2 | sam       | willies  |   94566 |
