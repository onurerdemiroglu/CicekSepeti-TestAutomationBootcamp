package CicekSepeti.TestCases;

import CicekSepeti.utils.Driver;
import org.junit.*;
import org.openqa.selenium.By;

import java.time.Duration;


public class Test2 {
    @Before
    public void setup() {
        Driver.get().get("https://www.ciceksepeti.com/");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // Driver elementlere erişim için 25 sn bekleme süresi tanınır
        Driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200)); //Sayfaların timeouta düşme süresi tanınır
        Driver.get().manage().window().maximize(); // Tarayıcı tam ekran modu

        Driver.get().findElement(By.xpath("//span[@class='icon-close']")).click(); // Gönderim Adres Popup Kapatma
    }

    @Test
    public void bonnyFoodToBasket() {
        Driver.get().findElement(By.xpath("(//*[contains(text(),'BonnyFood')])[2]")).click();
        Driver.get().findElement(By.xpath("//*[@alt='Seni Seviyorum Çikolataları']")).click(); // İlk ürünü seçtiriyoruz
        String productName = Driver.get().findElement(By.className("js-product-title")).getText(); // ürün ismini getiriyoruz
//        Driver.get().findElement(By.xpath("//input[@placeholder='Göndereceğiniz mahalleyi, Okul, Hastane vb. seçin']")).sendKeys("Kocaeli, İzmit/Kocaeli, Türkiye"); // Adres giriyoruz
//        Driver.get().findElement(By.xpath("//*[@data-secondary-address='İzmit/Kocaeli, Türkiye']")).click(); // İkincil adres giriyoruz
        Driver.get().findElement(By.xpath("//div[@class='product__action-col']")).click(); // Sepete ekle butonuna bastırıyoruz
        String basketProductName = Driver.get().findElement(By.className("cart__item-col-link")).getText(); // Sepet ekranında ürün ismini alıyoruz

        Assert.assertEquals(productName, basketProductName);
    }

    @Test
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

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}