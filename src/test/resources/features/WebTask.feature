Feature: Orders checking-out
  Background: User opened the homepage
    Then Thinking in HTML book is existed

  @Test
  Scenario: Validate order's checking out
    Given User clicks on add the book to basket
    And User clicks on shopping cart
    Then Book added to cart with its details
    When User clicks on proceed to checkout
    Then Billing details form is displayed
