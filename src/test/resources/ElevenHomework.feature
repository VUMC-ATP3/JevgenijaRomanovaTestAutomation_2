Feature: SauceLabs Login
  User is able to login, add item to the cart, checkout.
  Test correct error messages on the checkout page.


  @browser
  Scenario: User is able to make an order in webpage
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    When user add item to cart
    And user clicks cart button
    When user sees item 'Sauce Labs Onesie'
    And user clicks checkout button
    When user enter name 'Jevgenija' and lastname 'Romanova' and zip 'LV-2164'
    And user clicks continue button
    When checkout data is correct
    And user clicks finish button
    Then order is created successfully

  @browser
  Scenario: User sees correct error messages
    Given user is navigated to page 'https://www.saucedemo.com/'
    When user enters username 'standard_user' and password 'secret_sauce'
    And user clicks login button
    When user add item to cart
    And user clicks cart button
    And user clicks checkout button
    Then users sees error message '<errors_text>'
    Examples:
      | firstName | lastname  | zip     | errors_text                    |
      |           |           |         | Error: First Name is required  |
      | Jevgenija |           |         | Error: Last Name is required   |
      | Jevgenija | Romanovae |         | Error: Postal Code is required |
      |
