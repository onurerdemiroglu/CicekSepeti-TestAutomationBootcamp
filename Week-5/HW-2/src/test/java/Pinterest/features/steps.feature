Feature: Pinterest Android UI Tests

  @positive @signup
  Scenario:  Signup with email and password
    Given I type random mail in the field
    And   I type random password in the field
    And   I type random full name in the field
    And   I type random age in the field
    And   I select random gender
    And   I select random country
    When  I select random topics
    Then  I should see profile view button


  @positive @login
  Scenario Outline: Login with email and password
    Given I type "<mail>" in the mail field
    And   I type "<password>" in the password field
    When  I click the Log In
    Then  I should see the pinterest feed on the homepage

    Examples:
      | mail                      | password            |
      | ciceksepeti1@bootcamp.com | ciceksepetibootcamp |


  @negative @search
  Scenario Outline: Incorrect search in the search box
    Given I type "ciceksepeti1@bootcamp.com" in the mail field
    And   I type "ciceksepetibootcamp" in the password field
    And   I click the Log In
    And   I click the search tab
    When  I search for "<searchKeyword>"
    Then  I should see result "We couldn't find any Pins"

    Examples:
      | searchKeyword    |
      | asdfcafa.,=!%^we |


  @positive @board
  Scenario: Create board
    Given I type "ciceksepeti1@bootcamp.com" in the mail field
    And   I type "ciceksepetibootcamp" in the password field
    And   I click the Log In
    And   I click the profile tab
    And   I press the create button
    And   I select the board
    And   I type "Home Decor" in the board name field
    When  I click the done
    Then  I should see the created board name is "Home Decor"


  @positive @follow
  Scenario: Follow user
    Given I type "ciceksepeti1@bootcamp.com" in the mail field
    And   I type "ciceksepetibootcamp" in the password field
    And   I click the Log In
    And   I click the search tab
    And   I search for "Onur Erdemiroglu"
    And   I click the profiles tab
    When  I press the Follow button
    Then  I should see "Following"


  @positive @message
  Scenario: Sending a message to the user
    Given I type "ciceksepeti1@bootcamp.com" in the mail field
    And   I type "ciceksepetibootcamp" in the password field
    And   I click the Log In
    And   I click the notifications tab
    And   I click the Messages
    And   I click the New message
    And   I search user for "Onur Erdemiroglu"
    And   I select the searched user and press the next button
    And   I type "Ciceksepeti Bootcamp😍" in the message field
    When  I click the send button
    Then  I should see the message sent

