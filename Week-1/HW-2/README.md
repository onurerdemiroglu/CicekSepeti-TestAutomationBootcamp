# Çiçek Sepeti Bootcamp Ödev 2


## Test Class 1 Senaryoları
### 1.Senaryo : signUp()
--- 

🛑 Çiceksepeti.com'a gidilir ve öne çıkan gönderim adresi popup kapatılır.

🛑 'Üyelik' ve ardından 'Üye Ol' butonuna tıklanır.

🛑 RandomUser classından gelen veriler ile üyelik formu doldurulur.

🛑 Üyelik sözleşmeleri onaylanır.

🛑 Üye ol butonuna tıklanır.

🛑 Teşekkürler mesajı görüntülenmesi izlenir.

Test Status :  ✅

 
<details>
  <summary><strong> signUp() methodunu görmek için tıklayınız</strong></summary>
  
```java
public void signUp() throws FileNotFoundException, InterruptedException {
    String[] userArray = RandomUser.getRandomUser();

    Driver.get().findElement(By.xpath("//*[text()='Üyelik']")).click(); // Üyelik sekmesine tıklanması
    Driver.get().findElement(By.xpath("//*[text()='Üye Ol']")).click(); // Üyelik sekmesi içinden Üye Ol tıklanması
    Driver.get().findElement(By.id("NameIndivual")).sendKeys(userArray[0] + " " + userArray[1]); // Ad soyad bölümü yazdırılması
    Driver.get().findElement(By.id("EmailIndivual")).sendKeys(userArray[2]); // Email bölümü yazdırılması
    Driver.get().findElement(By.id("PasswordIndivual")).sendKeys(userArray[3]); // Şifre bölümü yazdırılması
    Driver.get().findElement(By.xpath("//label[@for='IsCheckAllContact']")).click(); // "Çiçeksepeti.com tarafından tarafıma ticari elektronik ileti gönderilmesine izin veriyorum."
    Driver.get().findElement(By.xpath("//button[text()='Okudum, Kabul Ediyorum']")).click(); // Popup okudum kabul ediyorum onayı
    Driver.get().findElement(By.xpath("//label[@for='IsCustomerContractConfirmed']")).click(); // "Üyelik Sözleşmesi 'ni ve Kişisel Verilerin Korunmasına İlişkin Aydınlatma Metni 'ni okudum, onaylıyorum."
    Driver.get().findElement(By.xpath("//button[text()='Okudum, Kabul Ediyorum']")).click(); // Popup okudum kabul ediyorum onayı

    if (!Driver.get().findElement(By.id("BlockCaptcha")).getAttribute("type").equals("hidden")) { //captcha çıkmadı ise
        System.out.println("Captcha var");
        System.out.println("Ben çok denedim ancak karşılaşamadım bir türlü, eğer denk gelirseniz haber etmeyi unutmayın :)");
    }
    Driver.get().findElement(By.xpath("//button[text()='Üye Ol']")).click(); // Üye Ol butonuna basıyoruz

    boolean isOK = Driver.get().findElement(By.className("membership-thanks__heading")).isDisplayed(); //Teşekkürler yazısı göründü ise kayıt başarılı demektir.

    Assert.assertTrue(String.valueOf(true), isOK);
}
```
</details>

[![IMAGE_ALT](https://user-images.githubusercontent.com/35347777/143438485-69fb4d73-9506-4700-bbd6-b0815341ed52.PNG)](https://www.youtube.com/watch?v=ncjw2tQszwI)
 
### 2.Senaryo : login()
--- 

🛑 Çiceksepeti.com'a gidilir ve öne çıkan gönderim adresi popup kapatılır.

🛑 'Üyelik' ve ardından 'Üye Girişi' butonuna tıklanır.

🛑 Config dosyasından alınan email ve password değerleri ile form doldurulur.

🛑 Giriş butonuna tıklanır 

🛑 Hesabım kısmına gönderilir, hesabım sekmesinin görünürlüğü izlenir.

Test Status :  ✅
 
<details>
  <summary> login() methodunu görmek için tıklayınız</summary>
  
  ```java
public void login() throws InterruptedException {
    Driver.get().findElement(By.xpath("//*[text()='Üyelik']")).click(); // Üyelik sekmesine tıklanması
    Driver.get().findElement(By.xpath("//*[text()='Üye Girişi']")).click(); // Üyelik sekmesi içinden Üye Girişi'ne tıklanması
    Driver.get().findElement(By.name("Email")).sendKeys(ConfigReader.get("email")); // app.config dosyasındaki email adresini yazdırıyoruz
    Driver.get().findElement(By.name("Password")).sendKeys(ConfigReader.get("password")); // app.config dosyasındaki password değerimizi yazdırıyoruz
    Driver.get().findElement(By.xpath("//button[text()='Giriş']")).click(); // Giriş butonuna bastırıyoruz
    Thread.sleep(2000);
    Driver.get().get("https://www.ciceksepeti.com/hesabim/siparislerim"); // Hesabım kısmına gönderelim
    boolean account = Driver.get().findElement(By.xpath("(//span[text()='Hesabım'])[1]")).isDisplayed(); // Hesabım sekmesi görünüyorsa giriş yapmış olarak kabul ediyoruz

    Assert.assertTrue(String.valueOf(true), account);
}
``` 
</details>

 [![IMAGE_ALT](https://user-images.githubusercontent.com/35347777/143438477-c2c32d7b-9f69-4783-81b8-7995970c1518.PNG)](https://youtu.be/vEKSMrsAY4c)



## Test Class 2 Senaryoları

### 1.Senaryo : bonnyFoodToBasket()
--- 

🛑 Çiceksepeti.com'a gidilir ve öne çıkan gönderim adresi popup kapatılır.

🛑 BonnyFood menüsüne tıklanır.

🛑 İlk ürün seçilir.

🛑 Seçilen ürünün adı alınır.

🛑 Sepete ekle butonuna basılır.

🛑 Sepetteki ürün ismi alınır ve ürün sayfasındaki alınan isimler karşılaştırılır.

Test Status :  ✅
 
<details>
  <summary> bonnyFoodToBasket() methodunu görmek için tıklayınız</summary>
  
  ```java
public void bonnyFoodToBasket() {
    Driver.get().findElement(By.xpath("(//*[contains(text(),'BonnyFood')])[2]")).click();
    Driver.get().findElement(By.xpath("//*[@alt='Seni Seviyorum Çikolataları']")).click(); // İlk ürünü seçtiriyoruz
    String productName = Driver.get().findElement(By.className("js-product-title")).getText(); // ürün ismini getiriyoruz
//    Driver.get().findElement(By.xpath("//input[@placeholder='Göndereceğiniz mahalleyi, Okul, Hastane vb. seçin']")).sendKeys("Kocaeli, İzmit/Kocaeli, Türkiye"); // Adres giriyoruz
//    Driver.get().findElement(By.xpath("//*[@data-secondary-address='İzmit/Kocaeli, Türkiye']")).click(); // İkincil adres giriyoruz
    Driver.get().findElement(By.xpath("//div[@class='product__action-col']")).click(); // Sepete ekle butonuna bastırıyoruz
    String basketProductName = Driver.get().findElement(By.className("cart__item-col-link")).getText(); // Sepet ekranında ürün ismini alıyoruz

    Assert.assertEquals(productName, basketProductName);
}
``` 
</details>

 [![IMAGE_ALT](https://user-images.githubusercontent.com/35347777/143438492-66d87cbe-e1ec-41b8-8f99-2de51f915596.PNG)](https://www.youtube.com/watch?v=tfUCLMuX0zs)
 
 
### 2.Senaryo : addProductToFavorite()
--- 

🛑 Çiceksepeti.com'a gidilir ve öne çıkan gönderim adresi popup kapatılır.

🛑 Login işlemi yapılır

🛑 Arama bölümüne "Çikolata" yazılır ve ara butonuna tıklanır.

🛑 İlk ürün sayfasına girilir ve ürün fiyatı alınır

🛑 Ürün fiyatının ardından favori iconuna tıklanır.

🛑 Favorilerim sayfasına gidilir.

🛑 Favorilerde bulunan ürünün fiyatı alınır ve karşılaştırılır.

Test Status :  ✅
 
<details>
  <summary> addProductToFavorite() methodunu görmek için tıklayınız</summary>
  
  ```java
public void addProductToFavorite() throws InterruptedException {
    Test1 loginCase = new Test1();
    loginCase.login(); // Login methodunu çağırıyoruz
    Driver.get().findElement(By.xpath("//input[@placeholder='Ürün veya kategori ara']")).sendKeys("Çikolata"); // Çikolata kelimesini arama kutusuna yazdırıyoruz
    Driver.get().findElement(By.xpath("//span[text()='ARA']")).click(); // Ara butonuna bastırıyoruz
    Driver.get().findElement(By.cssSelector(".products__item:nth-child(1)")).click(); // ilk ürünü seçtiriyoruz
    String productPrice = Driver.get().findElement(By.className("js-price-integer")).getText(); // ürün fiyatını getiriyoruz
    Driver.get().findElement(By.xpath("//i[@class='icon-favorite favorite__icon']")).click(); // favori iconuna tıklatıyoruz
    Thread.sleep(2000);
    Driver.get().findElement(By.className("user-menu__link--favorite")).click(); // favorilerime gidiyoruz
    String favProductPrice = Driver.get().findElement(By.className("price__integer-value")).getText(); // favoriler ekranında ürün fiyatını alıyoruz
    String favoriIcon = Boolean.toString(Driver.get().findElement(By.className("add-favorite")).isDisplayed()); // üründeki favori iconu kontrol

    Assert.assertTrue((productPrice.equals(favProductPrice)) || (favoriIcon.equals("true"))); // ürün sayfasındaki fiyat ile favoriler erkanındaki fiyat karşılaştırılması veya icon karşılaştırılması ile sorgulama
}
``` 
</details>

 [![IMAGE_ALT](https://user-images.githubusercontent.com/35347777/143438467-f66e13b3-a673-48d2-9f26-b7e8977c73b7.PNG)](https://youtu.be/fNsP4h1ONdA)
 
--- 

- [X] Not: app.config dosyasını düzenlemeyi unutmayın, keyifli çalışmalar.

![out](https://user-images.githubusercontent.com/35347777/143421998-20d8db44-093d-4f76-8cc9-e08c1bb598e2.gif)
