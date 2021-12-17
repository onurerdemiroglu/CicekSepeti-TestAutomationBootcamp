Feature: EvideaWebUI Tests

    Evidea Web UI Tests with .NET & Specflow (BDD-Framework for .NET)

    Background:
        Given navigate to website

    @positive
    Scenario: Adding the product to the basket
        Given I choose 'ELEKTRİKLİ EV ALETLERİ' from the dropdown menu
        And I choose 'Kahve ve Espresso Makinesi' from the dropdown sub menu
        And I open the first product page
        And I click the add to basket button
        When I click the close popup button
        Then Verify success add product result 'Ürün sepetinize eklenmiştir.'


    @negative
    Scenario Outline: Incorrect product search in the search box
        Given I search for <searchKeyword>
        When I click the search button
        Then search result should be seen 'Sonuç bulunamadı'

        Examples:
            | searchKeyword   |
            | asdkjasdkjaksdj |