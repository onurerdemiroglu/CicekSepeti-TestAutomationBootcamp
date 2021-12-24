# boyner-cucumber

Merhaba, bu projede Cucumber framework ile Page Object Pattern yapısına bağlı kalınarak [boyner.com.tr](https://boyner.com.tr) websitesinin testleri yapılmıştır.
 
İlk olarak IntelliJ IDEA'da maven projesi oluşturulup Cucumber, Selenium, Bonigarcia için gerekli dependencyler pom.xml dosyasına eklenmiştir.
 
## Scenario 1
 
 

```cucumber
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
``` 

![namesurname](https://user-images.githubusercontent.com/35347777/145619315-efb00dd8-f844-4bae-8326-543546036c87.PNG)


**Result : Başarılı** bir şekilde login olup Ad Soyad bilgisinin doğruluğu görülmüştür. ✅
 
https://user-images.githubusercontent.com/35347777/145617776-4df18bc8-39e9-442f-9019-e78caede6562.mp4
  
  
## Scenario 2 

```cucumber
  Scenario Outline: Product search in the search box
    When I search for "<searchKeyword>"
    And I click the search button
    Then search result should be seen "Aradığınız filtrelerle eşleşen ürün bulunamadı."
    Examples:
      | searchKeyword   |
      | asdkjasdkjaksdj |
      | oerdemdasfasf   |
``` 

![filtre](https://user-images.githubusercontent.com/35347777/145619880-bfdce7fa-55cc-4c27-9ebd-72e0adcc041a.PNG)

**Result:** Rastgele gönderilen anlamsız kelimeler ile arama sonuçlarında eşleşen ürün bulunamadığı görülmüştür. ✅

https://user-images.githubusercontent.com/35347777/145617792-d21e2f1e-5512-427d-b951-a7e0830a25f1.mp4


## Scenario 3

```cucumber
  Scenario: Adding the product to the basket
    Given I choose the "Çok Satanlar" from the slide menu
    When I open the first product page
    And I click the add to basket button
    Then verify success add product result "Sepete Eklendi."
```

![sepet](https://user-images.githubusercontent.com/35347777/145620273-f1f94323-43f8-4780-8aa2-6ba98c0658b1.PNG)

**Result :** Çok satanlar kategorisinden bir ürünü sepete başarılı bir şekilde eklendiği görülmüştür. ✅

https://user-images.githubusercontent.com/35347777/145617803-29edb9fb-248c-4a58-9268-8281f878f171.mp4
 
