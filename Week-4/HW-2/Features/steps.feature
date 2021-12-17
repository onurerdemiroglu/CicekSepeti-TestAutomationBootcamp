Feature: EbayWebUI Tests

  Ebay Web UI Tests with Python & Behave (BDD-Framework for Python)

  Background:
    Given navigate to website

  @positive
  Scenario: Adding the product to the basket
    Given I choose "Electronics" from the dropdown menu
    And I choose "Apple" from the dropdown sub menu
    And I open the first product page
    And I click the add to basket button
    Then Verify success add product result "Go to checkout"

  @negative
  Scenario Outline: Incorrect product search in the search box
    Given I search for "<searchKeyword>"
    When I click the search button
    Then search result should be seen "No exact matches found"

    Examples:
      | searchKeyword   |
      | asdkjasdkjaksdj |

  @positive
  Scenario Outline: Sort searched item list with different sort criterion
    Given I search for "<searchItem>"
    When I click the search button
    And I sort result list based on "<sortCriterion>"
    Then I should see the search result list sorted by "<sortCriterion>"

    Examples:
      | searchItem | sortCriterion |
      | iPhone     | Price + Shipping: highest first |