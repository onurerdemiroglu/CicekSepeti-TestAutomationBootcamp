# Postman ile Github API

![IMG](https://miro.medium.com/max/700/1*ToucMsu-Zq3G-DiwTG8JpQ.png)

Merhabalar, bu yazımda öncelikle “Postman Nedir?”, ”Neden Postman?” gibi başlıklara değinip hemen sonrasında da Github API-Postman örneğini inceleyeceğiz.

### Postman Nedir?
**Postman**, CI/CD ardışık düzenine hızla entegre olan, API’nizin yeteneklerini görmek, çalışma hızı ve durumunu test etmek veya gelen değerleri sorgulamak gibi bir dizi işlem yapabildiğimiz mükemmel bir API test aracıdır.

Postman, direkt indirip bilgisayarımıza yükleyebileceğimiz ya da Chrome uzantı olarak kullanabileceğimiz bir uygulamadır. **[Bu linkten](https://www.postman.com/downloads/)** ister web versiyonu, isterseniz işletim sistemine göre indirerek kullanabilirsiniz.

### Neden Postman?

Yalnızca bir API’nin işlevselliğini test etmek için bir sürü kod yazma zahmetine girmeden API’lerimizi kolayca test edebileceğimiz, API’mizin dokümantasyonunu hazırlamamızı sağlayan ve “rest client” olarak adlandırabileceğimiz harika bir araç. 😊

### Github API - Postman

Postman’i açtığımızda aşağıdaki gibi bir arayüz bizi karşılıyor.

![genel](https://user-images.githubusercontent.com/35347777/144523571-d7e3dbdb-2238-4a09-a24c-4ad4f50bc988.PNG)

Postman ara yüzünde ilk önce Workspaces alanından bir **Workspace** tanımlanır ardından Collections’dan aşağıdaki görüntüde belirtildiği gibi “+” butonuna basılıp bir **Collection** oluşturulur. Ben Github API testi yapacağım için Github ismini verdim. Oluşturduğumuz Collection içerisine sağ tık yapıp **Add Request** seçeneği ile requestlerimizi ekleyebiliriz.

![Collections](https://user-images.githubusercontent.com/35347777/144523641-66a46452-13a8-4fe0-a94f-dcca542ef92d.PNG)

İlk olarak tarayıcımdan mevcut github hesabım ile login oldum. Daha sonra Github Api kullanımı için “**TOKEN**” bilgisi almamız gerekiyor. Bunu Github üzerinden **Settings** → **Developer Settings** → **Personel Access Token** bölümünden **Generate new token** butonuna basıp alabilirsiniz. Ya da direk [bu linke](https://github.com/settings/tokens) tıklayabilirsiniz.

Aldığımız tokeni aşağıda da gösterildiği gibi Collection yanındaki “…” ‘a basıp Edit kısmını açıyoruz. Auth Type kısmını Bearer Token seçip Token kısmına aldığımız tokeni yazıp kaydediyoruz. Böylelikle auth işlemimiz tamamlandı.


![out1](https://user-images.githubusercontent.com/35347777/144523755-0f43f97d-d449-40bf-b9fa-8ad45d192ee9.gif)

[Github API requestlerini](https://docs.github.com/en/rest) incelediğimizde kullanılan sabit değişkenler olduğunu görüyoruz. Bu gibi durumlarda değişkeni tekrar tekrar yazmak yerine **Environments** içinde sabit değişkenleri tanımlayabilirsiniz.

![out2](https://user-images.githubusercontent.com/35347777/144523833-fc66db91-aadb-4e0e-badf-05ec58e3868b.gif)

Request alanlarını tanımlayacak olursak,

**Params** → Gerekli parametreleri key, value olarak gönderildiği alandır.
**Authorization** → API’lere erişmek için yetkilendirme gerekmektedir, bir kullanıcı adı / şifre ya da bearer token vs bu kısımdan set edilebilir.
**Headers** → İhtiyacınıza göre header parametreleri buradan gönderilir.
**Body** → Bir istekteki ayrıntıların özelleştirebildiği alan.
**Pre-request Script** → Bir request gönderilmeden önce çalışan alandır.
**Tests** → Bu kısım API’yi test edeceğimiz test scriptlerinin yazıldığı alandır.

![out](https://user-images.githubusercontent.com/35347777/144523903-19eee3c3-1649-4cfe-bb81-a51e0fd807f0.gif)

Yukarıda örnek bir kullanıcı arama ve test scriptlerini görüyoruz. **Environments** içinden gelen baseUrl ve username değişkenleri ile kullanıcı araması yapıp GET işlemine karşılık aldığımız veri içerisinde “login” ve “url” bizim belirttiğimiz değerlere eşit mi? diye sorgulayabiliyoruz.
Sorgulamanın ardından Test Result kısmında testin başarılı olup olmadığını rahatlıkla görebiliyoruz.

KAYNAKLAR
[how-use-postman-manage-and-execute-your-apis](https://www.blazemeter.com/blog/how-use-postman-manage-and-execute-your-apis)<br>
[getting-started-introduction](https://learning.postman.com/docs/getting-started/introduction/)<br>
[what-is-postman-api-test](https://www.encora.com/insights/what-is-postman-api-test)<br>
..

Bir sonra ki yazımda görüşmek üzere…


Medium : 
https://medium.com/@onurerdemiroglu/postman-ile-github-api-9ab69bde6088
