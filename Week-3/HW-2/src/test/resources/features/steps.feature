Feature: bootcamp tests

  Background:
    Given navigate to website

  @positive
  Scenario Outline:  Login with email and password
    Given I am at the Login page
    When I type "<mail>" in the email field
    And I enter "<password>" in the password field
    And I click the login button
    Then I should see the name and surname as a "<name & surname>"
    Examples:
      | mail                          | password | name & surname |
      | ciceksepetibootcamp@gmail.com | Cicek123 | Cicek Sepeti   |
      | kiltevurki@vusra.com          | Cicek123 | Onur Erdem     |


  @negative
  Scenario Outline: Product search in the search box
    When I search for "<searchKeyword>"
    And I click the search button
    Then search result should be seen "Aradığınız filtrelerle eşleşen ürün bulunamadı."
    Examples:
      | searchKeyword   |
      | asdkjasdkjaksdj |
      | oerdemdasfasf   |

  @positive
  Scenario: Adding the product to the basket
    Given I choose the "Çok Satanlar" from the slide menu
    When I open the first product page
    And I click the add to basket button
    Then verify success add product result "Sepete Eklendi."
