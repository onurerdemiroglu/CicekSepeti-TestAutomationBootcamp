#  .NET & Specflow (BDD-Framework for .NET) ile Evidea Web UI Testleri  

Merhaba, bu projede .Net dilinde NUnit ile Specflow kütüphaneleri kullanılarak Evidea sitesinin UI(User Interface) testleri yapılmaktadır.

### 👨‍💻 Nedir bu SpecFlow?  
---

Specflow .NET içerisinde BDD uygulamalarını destekleyen bir frameworktür. BDD(Behaviour Driven Development) ile, yazılım süreçlerinin daha test odaklı gitmesini sağlayan ve prensip olarak öncelikli olarak test kodları yazılıp daha sonrasında proje kodu yazılsın anlayışını benimsemektedir. 

Senaryoları Gherkin dilini kullanarak herkesin anlayabileceği basit en basit haliyle yazmaktayız. Böylece senaryoya göz gezdiren herkes için teknik bilgisi olmaksızın anlamasını sağlamaktadır. Böylece, teknik veya teknik olmayan ekipler arasındaki iletişimi kolaylaştırmaktadır. Eğer yazılımlarımızın değişime duyarlı, hızlı ve anlaşılır olmasını istiyorsak BDD kullanmalıyız.

“Agile methodolojisi ile iş yapıyorsanız ve uygulama testi için BDD kullanmıyorsanız kendinizle çelişiyorsunuzdur.”


Aşağıya örnek bir senaryo görseli bırakıyorum. Ne demek istediğimi çok daha iyi anlayacağınızı düşünüyorum.🙃

![search](https://user-images.githubusercontent.com/35347777/146364944-6b207c62-15ad-4eec-a280-e378dc6b7ee9.PNG)


SpecFlow, açık kaynak ve kullanımı ücretsiz bir frameworktür. [Github linkine buradan ulaşabilirsiniz.](https://github.com/SpecFlowOSS/SpecFlow)🙂


### 👨🏿‍💻 Senaryo-1 : Adding the product to the basket
---

```cucumber
@positive
Scenario: Adding the product to the basket
    Given I choose 'ELEKTRİKLİ EV ALETLERİ' from the dropdown menu
    And I choose 'Kahve ve Espresso Makinesi' from the dropdown sub menu
    And I open the first product page
    And I click the add to basket button
    When I click the close popup button
    Then Verify success add product result 'Ürün sepetinize eklenmiştir.'
```
 
![addtobasket](https://user-images.githubusercontent.com/35347777/146387742-813829f6-2840-4e56-9755-e1d58faaba27.gif)

https://user-images.githubusercontent.com/35347777/146384841-9bf6e1e7-2446-4526-b153-a80e8f873ced.mp4

**Result :** Ürünün başarılı bir şekilde sepete eklendiği görülmüştür. ✅

![sc1](https://user-images.githubusercontent.com/35347777/146396794-587f3e1d-dcdd-4d1d-ad8a-ecc701d506bc.PNG)

### 👨🏿‍💻 Senaryo-2 : Incorrect product search in the search box
---

```cucumber
@negative
Scenario Outline: Incorrect product search in the search box
    Given I search for <searchKeyword>
    When I click the search button
    Then search result should be seen 'Sonuç bulunamadı'

    Examples:
        | searchKeyword   |
        | asdkjasdkjaksdj |
```

![search](https://user-images.githubusercontent.com/35347777/146391693-21c32ac7-aaf9-4653-9277-bfcbb4e6a4ba.gif)

https://user-images.githubusercontent.com/35347777/146392153-f7ffd25b-e432-474d-959e-38b002add1c0.mp4

**Result :** Hatalı aranan ürün adı ile sonuçlarda eşleşen ürün bulunamadığı görülmüştür. ✅

![sc2](https://user-images.githubusercontent.com/35347777/146546609-2765447e-d97d-4386-8876-66c5e5c415c7.PNG)
