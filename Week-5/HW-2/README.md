#  Pinterest - Android UI Test (Cucumber/BDD)

Merhaba, bu projede Java dilinde Appium kullanılarak Pinterest sitesinin Android UI testleri yapılmaktadır. 

## ![appium](https://user-images.githubusercontent.com/35347777/147242877-3543ab25-e931-4ed6-95a4-5c8c95018ce0.png)  Appium Nedir? 


**Appium**, iOS, Android ve Windows masaüstü platformlarında mobil ve hibrit uygulamalarında web sürücüsü kullanarak test otomasyonunda kullanılan açık kaynak kodlu bir test aracıdır.
 
#### Peki Neden Appium Kullanıyoruz?
---
- [X] Açık kaynaklıdır ve geniş bir topluluk desteğine sahiptir.
- [X]  Android, iOS ve Windows platformunu kapsar. 
- [X]  Mobil cihazlarda Yerel uygulama, Hibrit uygulama ve Web Tarayıcılarına destek sağlar.
- [X]  Java, Python, C #, Ruby, Javascript, PHP vb. gibi başlıca programlama dillerini destekler.
- [X]  Jenkins gibi entegrasyon araçlarıyla sorunsuz bir şekilde bütünleşir .
- [X]  Test kodunuz emülatörler, simülatörler, gerçek cihazlar ve AWS Device Farm , BrowserStack gibi bulut tabanlı mobil otomasyon hizmetlerinde çalıştırabilme imkanı sağlar.
- [X]  Arka planda Selenium Webdriver komutlarını kullanır. Daha önce selenium üzerinde çalıştıysanız, Appium'da zorluk çekmezsiniz.
- [X]   Otomasyon programlama diliniz, uygulama geliştiricinizin programlama diline bağlı değildir. 

Appium'a ufak bir giriş yaptıktan sonra senaryolarımıza geçebiliriz😀


###  👨🏻‍💻 Senaryo-1 : Signup with email and password
---

```cucumber
@positive 
Scenario:  Signup with email and password
  Given I type random mail in the field
  And   I type random password in the field
  And   I type random full name in the field
  And   I type random age in the field
  And   I select random gender
  And   I select random country
  When  I select random topics
  Then  I should see profile view button
```
  
https://user-images.githubusercontent.com/35347777/147234748-aa4165d9-d07f-4019-a43b-b02e20fc6f15.mp4


#### 📝 Cucumber Reporu
---
  
![scenario-1](https://user-images.githubusercontent.com/35347777/147235341-4a69e0f6-db44-4f39-b441-9ed70f35c547.PNG)
 
**Result :** Başarılı bir şekilde üyelik açıldığı görülmüştür. ✅
 
### 👨🏿‍💻 Senaryo-2 : Login with email and password
---

```cucumber
@positive
Scenario Outline: Login with email and password
  Given I type "<mail>" in the mail field
  And   I type "<password>" in the password field
  When  I click the Log In
  Then  I should see the pinterest feed on the homepage

  Examples:
    | mail          	        | password            |
    | ciceksepeti1@bootcamp.com | ciceksepetibootcamp |
```

https://user-images.githubusercontent.com/35347777/147235609-41f4a490-77a1-4b08-ad24-03f62a134d90.mp4


#### 📝 Cucumber Reporu
---

![scenario-2](https://user-images.githubusercontent.com/35347777/147235625-dc385760-533b-4f8f-8c0e-95b482bfeeb1.PNG)

**Result :** Başarılı şekilde üye girişi yapıldığı görülmüştür ✅

### 👨🏻‍💻 Senaryo-3 : Incorrect search in the search box
---

```cucumber
@negative
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
```

https://user-images.githubusercontent.com/35347777/147236298-12a16fc2-416b-4e67-aed6-05cf749eace7.mp4


#### 📝 Cucumber Reporu
---

![scenario-3](https://user-images.githubusercontent.com/35347777/147236280-91afa613-602d-4247-9813-f78745807b2f.PNG)

**Result :** Başarılı şekilde login işlemi yapıldığı görülmüştür ✅

### 👨🏿‍💻 Senaryo-4 : Create board
---

```cucumber
@positive
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
```

https://user-images.githubusercontent.com/35347777/147236416-9f6fa998-d04a-4368-a632-1c9b6c609a8a.mp4


#### 📝 Cucumber Reporu
---

![scenario-4](https://user-images.githubusercontent.com/35347777/147236428-106fba37-e38f-49c7-b4ba-d6bfde36b150.PNG)

**Result :** Başarılı şekilde pano oluşturulduğu görülmüştür. ✅


### 👨🏻‍💻 Senaryo-5 : Follow user
---

```cucumber
@positive
Scenario: Follow user
  Given I type "ciceksepeti1@bootcamp.com" in the mail field
  And   I type "ciceksepetibootcamp" in the password field
  And   I click the Log In
  And   I click the search tab
  And   I search for "Onur Erdemiroglu"
  And   I click the profiles tab
  When  I press the Follow button
  Then  I should see "Following"
```

https://user-images.githubusercontent.com/35347777/147236946-11bcf7d9-a53d-481b-8696-a658ef567f76.mp4


#### 📝 Cucumber Reporu
---

![scenario-5](https://user-images.githubusercontent.com/35347777/147236940-1d4491ee-54a7-4237-84be-9ba657979098.PNG)

**Result :** Başarılı şekilde kullanıcı takip edildiği görülmüştür. ✅


### 👨🏿‍💻 Senaryo-6 : Sending a message to the user
---

```cucumber
@positive
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
```

https://user-images.githubusercontent.com/35347777/147237217-e9b3f216-5121-488b-a98c-1bf524d35e56.mp4

#### 📝 Cucumber Reporu
---

![scenario-6](https://user-images.githubusercontent.com/35347777/147237226-373e12bc-6838-4527-bd90-4ed60e921b43.PNG)

**Result :** Başarılı şekilde kullanıcıya mesaj atıldığı görülmüştür. ✅