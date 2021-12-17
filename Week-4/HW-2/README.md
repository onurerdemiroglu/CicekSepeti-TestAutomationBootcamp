#  Python & Behave (BDD-Framework for Python) ile Ebay Web UI Testleri  

Merhaba, bu projede Python dilinde Pytest ile Behave kütüphaneleri kullanılarak Ebay sitesinin UI(User Interface) testleri yapılmaktadır.

### 👨‍💻 Nedir bu Behave?  
---

Behave Python içerisinde BDD uygulamalarını yürütmesine izin veren en iyi Python frameworklerinden biridir. BDD(Behaviour Driven Development) ile, yazılım süreçlerinin daha test odaklı gitmesini sağlayan ve prensip olarak öncelikli olarak test kodları yazılıp daha sonrasında proje kodu yazılsın anlayışını benimsemektedir. 

Senaryoları Gherkin dilini kullanarak herkesin anlayabileceği basit en basit haliyle yazmaktayız. Böylece senaryoya göz gezdiren herkes için teknik bilgisi olmaksızın anlamasını sağlamaktadır. Böylece, teknik veya teknik olmayan ekipler arasındaki iletişimi kolaylaştırmaktadır. Eğer yazılımlarımızın değişime duyarlı, hızlı ve anlaşılır olmasını istiyorsak BDD kullanmalıyız.

“Agile methodolojisi ile iş yapıyorsanız ve uygulama testi için BDD kullanmıyorsanız kendinizle çelişiyorsunuzdur.”


Aşağıya örnek bir senaryo görseli bırakıyorum. Ne demek istediğimi çok daha iyi anlayacağınızı düşünüyorum.🙃

![search](https://user-images.githubusercontent.com/35347777/146547788-92301be8-dadc-439c-b2ba-73b5423df639.PNG)


Behave, açık kaynak ve kullanımı ücretsiz bir frameworktür. [Github linkine buradan ulaşabilirsiniz.](https://github.com/behave/behave)🙂


### 👨🏿‍💻 Senaryo-1 : Adding the product to the basket
---

```cucumber
@positive
Scenario: Adding the product to the basket
  Given I choose "Electronics" from the dropdown menu
  And I choose "Apple" from the dropdown sub menu
  And I open the first product page
  And I click the add to basket button
  Then Verify success add product result "Go to checkout"
```
 
![addtobasket](https://user-images.githubusercontent.com/35347777/146548837-c70689d8-f01c-4243-a9c4-7554da4ca837.gif)

https://user-images.githubusercontent.com/35347777/146549315-e5d499d0-26be-47fc-9ea5-f34d307a6800.mp4

**Result :** Ürünün başarılı bir şekilde sepete eklendiği görülmüştür. ✅

#### 📝 Allure Reporu
---
![Report 1](https://user-images.githubusercontent.com/35347777/146549613-eefe083c-d844-4461-b053-40ba8691e796.PNG)

### 👨🏿‍💻 Senaryo-2 : Incorrect product search in the search box
---

```cucumber
@negative
Scenario Outline: Incorrect product search in the search box
  Given I search for "<searchKeyword>"
  When I click the search button
  Then search result should be seen "No exact matches found"

  Examples:
    | searchKeyword   |
    | asdkjasdkjaksdj |
```

![search](https://user-images.githubusercontent.com/35347777/146550135-dbc769a6-2399-4674-a7f3-bf3246da3c02.gif)

https://user-images.githubusercontent.com/35347777/146551004-115aeb1d-b370-4fc0-bdbe-313a1c9987a9.mp4

**Result :** Hatalı aranan ürün adı ile sonuçlarda eşleşen ürün bulunamadığı görülmüştür. ✅

#### 📝 Allure Reporu
---

![Report 2](https://user-images.githubusercontent.com/35347777/146552132-dc78b731-138e-496d-9f6b-29aa1927fa58.PNG)


### 👨🏿‍💻 Senaryo-3 : Sort searched item list with different sort criterion
---

```cucumber
@positive
Scenario Outline: Sort searched item list with different sort criterion
  Given I search for "<searchItem>"
  When I click the search button
  And I sort result list based on "<sortCriterion>"
  Then I should see the search result list sorted by "<sortCriterion>"

  Examples:
    | searchItem | sortCriterion |
    | iPhone   | Price + Shipping: highest first |
```

![sort criterion](https://user-images.githubusercontent.com/35347777/146551846-d16efd07-00b5-448e-8387-1ceeaf0cb9c4.gif)

https://user-images.githubusercontent.com/35347777/146551169-678dff25-e8ce-4b57-9fa0-568cb2958865.mp4

**Result :** Aranan ürünün farklı sıralama kriterleri ile sıralandığı görülmüştür. ✅

#### 📝 Allure Reporu
---

![Report 3](https://user-images.githubusercontent.com/35347777/146552137-f81ff5ad-0fe6-41b5-9614-7c5cbf435321.PNG)

