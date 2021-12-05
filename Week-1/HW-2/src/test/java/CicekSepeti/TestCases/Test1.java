package CicekSepeti.TestCases;

import CicekSepeti.utils.ConfigReader;
import CicekSepeti.utils.Driver;
import CicekSepeti.utils.RandomUser;
import org.junit.*;
import org.openqa.selenium.By;
import java.io.FileNotFoundException;
import java.time.Duration;

public class Test1 {
    @Before
    public void setup() {
        Driver.get().get("https://www.ciceksepeti.com/");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Driver elementlere erişim için 10 sn bekleme süresi tanınır
        Driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200)); //Sayfaların timeouta düşme süresi tanınır
        Driver.get().manage().window().maximize(); // Tarayıcı tam ekran modu

        Driver.get().findElement(By.xpath("//span[@class='icon-close']")).click(); // Gönderim Adres Popup Kapatma
    }

    @Test
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

    @Test
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



    @After
    public void teardown() {
        Driver.closeDriver();
    }

}