#  Udemy - Android UI Test

Merhaba, bu projede Java dilinde Appium kullanılarak Udemy sitesinin Android UI testleri yapılmaktadır. 

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


###  👨🏻‍💻 TestCase-1 : SignUp Test
---

```java
@Test(priority = 0)
public void signUpTest() throws FileNotFoundException {
    String[] randomUser = getRandomUser();

    homePage
        .clickSignIn();
    signupPage
        .clickByText("Create an account")
        .clickByText("Sign up with email")
        .writeTheUserName(randomUser[0])
        .writeTheEmail(randomUser[2])
        .writeThePassword(randomUser[3])
        .clickCreateAccount();
    homePage
        .iShouldSeeAccountTab();
}
``` 
 
https://user-images.githubusercontent.com/35347777/147300703-a350964c-6572-4d0e-b4c4-b90e53ea5f96.mp4

**Result :** Başarılı bir şekilde üyelik açıldığı görülmüştür. ✅


###  👨🏻‍💻 TestCase-2 : SignIn Test
---

```java
@Test(priority = 1)
public void signInTest() {
    String email = "ciceksepetibootcamp@gmail.com";
    String password = "ciceksepetibootcamp";

    homePage
        .clickSignIn();
    signinPage
        .clickByText("Sign in with email")
        .writeTheEmail(email)
        .clickNextBtn()
        .writeThePassword(password)
        .clickSigninBtn();
    homePage
        .clickAccountTab();
    accountPage
        .verifyEmailAdress(email);
}
``` 

https://user-images.githubusercontent.com/35347777/147300709-e3e0ab31-222e-4c0c-abdb-bd22a76c219d.mp4

**Result :** Başarılı bir şekilde üye girişi yapıldığı görülmüştür. ✅

###  👨🏻‍💻 TestCase-3 : Incorrect Search Test
---

```java
@Test(priority = 2)
public void incorrectSearchTest() {
    homePage
        .clickByText("Browse")
        .clickSearchTab();
    searchPage
        .clickSearchBox()
        .writeSearchText("FSF3513daddfhasgASF.,^%!2EWsd")
        .pressKey(AndroidKey.ENTER)
        .verifySearchResult("No matching courses");
}
``` 
 
https://user-images.githubusercontent.com/35347777/147300721-f962e9b9-9c22-4b8c-b011-1f3863c52951.mp4

**Result :** Hatalı aranan eğitim adı ile sonuçlarda eşleşen ürün bulunamadığı görülmüştür. ✅

###  👨🏻‍💻 TestCase-4 : Browse Category
---

```java
@Test(priority = 3)
public void browseCategories() throws FileNotFoundException {
    String randomCategory = getRandomCategory();
    homePage
        .clickByText("Browse")
        .clickSearchTab();
    learningPage
        .scrollAndClickText(randomCategory)
        .verifyCategory(randomCategory);
}
``` 
 
https://user-images.githubusercontent.com/35347777/147300725-eaf175db-674d-434e-80a3-25da0af2fd96.mp4

**Result :** Rastgele girilen kategori sayfasında kategori başlığının aynı olduğu görülmüştür.✅
 
