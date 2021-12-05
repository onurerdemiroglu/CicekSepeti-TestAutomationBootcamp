# Google PageSpeed Insights Nedir? Nasıl Kullanılır?

![IMG](https://miro.medium.com/max/700/1*aaNGbCNoWHb9JBc8an3Tqg.png)


Merhabalar, bu yazımda öncelikle “Google PageSpeed Insights Nedir?”, “PageSpeed Insights Nasıl Kullanılır?” gibi başlıklara değinip hemen sonrasında da PageSpeed’i örnek bir web site ile analiz sonuçlarını inceleyeceğiz.

### Google PageSpeed Insights (PSI) Nedir?

Google tarafından 2010 yılında tanıtılan, web sitelerin performans optimizasyonlarına yardımcı olmak amacı ile web sitenizin hem mobil hem de masaüstü cihazlarda performansı hakkında raporlama yapan ücretiz bir analiz uygulamasıdır. Raporlamanın yanı sıra ortaya çıkan optimizasyon sorunlarını da nasıl iyileştirilebileceğine dair bizlere çözüm önerilerinde bulunuyor.

PageSpeed Insights’ın sahip olduğu ve raporlama aşamasında aktardığı hız skoru hesaplayıcı ile analiz edilen sayfalar bağımsız bir şekilde değerlendirilebilir ve Hızlı, Orta veya Yavaş olarak derecelendirilebilirler. Bu ayrım **FCP** (First Contentful Paint) ve **DCL** (DOM Content Loaded) olarak belirlenen iki ana ölçümün ortalamasına göre oluşturulmaktadır.

Bu ölçümler ile ilgili daha detaylı bilgi için **[web.dev-Lighthouse performance scoring](https://web.dev/performance-scoring/)** ve **[Lighthouse Scoring calculator](https://googlechrome.github.io/lighthouse/scorecalc/)** sitelerini ziyaret edebilirsiniz.

### PageSpeed Insights Nasıl Kullanılır?

[PageSpeed Insights](https://pagespeed.web.dev/) sayfasına gidin. ve karşınıza çıkan arama kutusuna hız testi gerçekleştirmek istediğiniz Web sayfasının URL’sini girin.

![IMG](https://miro.medium.com/max/700/1*kmvlndFHtFFKKbYzmehr3A.png)

Ardından **Analiz Et** butonuna tıklayın. Merak etmeyin son derece kısa sürecektir.😃 Ekranın sol üst bölümünden **Masaüstü** ve **Mobil**e ait raporlarınızın bulunduğu sayfalara geçiş yapabilirsiniz.

### PageSpeed Insights ile Analiz Sonuçları

![](https://miro.medium.com/max/700/1*7fgk40FhTDpku3XmOsE9uw.png)

Örnek web sitemiz için mobil performans sonucumuz “**Başarısız Oldu**” olarak değerlendirilmektedir. Sebeplerini irdelemek adına oluşturulan mobil performans raporunu incelemeye devam edelim.

![](https://miro.medium.com/max/700/1*JBQYBETLom1HNZBZJGivaw.png)

![](https://miro.medium.com/max/700/1*Y2A3E4QqZ6JgmZBZRgVUHA.png)

📌**First Contentful Paint (FCP)**, İlk İçerikli Boyama anlamına gelir ve bir sayfanın yüklenmeye başladığı andan o sayfanın içeriğinin herhangi bir bölümünün ekranda görüntülendiği ana kadar geçen zamanı ölçen bir metriktir. **FCP** zamanlaması olarak 0 – 2 saniye aralığında olursa yeşil, 2 – 4 saniye aralığında olursa turuncu, 4 saniye üzerinde olursa da kırmızı renk olarak belirtiliyor. Örnekteki web siteyi analiz ettiğimizde sayfanın ilk açılma süresi 2.4 sn. yani 2–4 aralığına denk geldiği için **FCP** analizinde turuncu renkte olduğunu görebiliriz.

![](https://miro.medium.com/max/700/1*JeSPP3DFSUPr5vi-89PjWA.png)

📌**First Input Delay (FID)**, İlk Giriş Gecikmesi anlamına gelir ve kullanıcının siteye girdikten sonra interaktif bir butona tıklamasıyla birlikte, butona tıkladığı andan, tarayıcının bu etkileşimi işlemeye başlayabileceği zamana kadar geçen süreyi izleyen gerçek kullanıcı web performansı ölçümüdür.

![](https://miro.medium.com/max/700/1*og_RA_FTcswVtaTqDRGMuQ.png)

![](https://miro.medium.com/max/605/1*05CFR8dwC3yqMxWRPx97bQ.png)

📌**Largest Contentful Paint (LCP)**, En Büyük Zengin İçerikli Boya anlamına gelir ve bir web sitesine tıkladığımız andan ilgili sayfanın en büyük içerik öğesinin yüklenmesi arasında geçen süre olarak belirtilebilir. Bir başka deyişle bir web sayfasına girdiğimizde en son yüklenen eleman en büyük boyuta sahip olan elemandır. Dolayısı ile web sayfasının yüklemesini tamamlandığı veya kullanıcı için geçerli tüm öğelerin yayınlandığı süreyi kapsar. İlgili sürenin **2.5 saniyeyi geçmemesi** kullanıcı deneyimi için oldukça önemlidir.

![](https://miro.medium.com/max/700/1*i983Pgp1G6-GGJRwjS2XWA.png)

📌**Cumulative Layout Shift (CLS)**, Kısaca web sitenize ziyaretçi girdiği andan itibaren web sitenizin tamamen yüklenmesinin bittiği anı ölçen metriktir.

![](https://miro.medium.com/max/700/1*2R-7OU72RZA7qgM0vSq9FA.png)

Peki formülü nedir? Nasıl Hesaplanır? diyecek olursak, Google bu formülü kendi resmi sitesinde şöyle vermiş:

* layout shift score = etki oranı * uzaklık oranı
* etki oranı = etki bölgesi / görünüm alanı
* uzaklık oranı = hareket mesafesi / görünüm alanı yüksekliği

![](https://miro.medium.com/max/700/1*7-7Mc5GssCTLU9YEzknixQ.jpeg)

Tüm bu analizler sonucunda örneğimizde de gördüğümüz gibi Google PageSpeed Insights muhtemel sorunları tespit ediyor ve bizlere bir şeyler anlatmaya çalışıyor. Gelin biraz da bu sorunlar üzerinde duralım.

![](https://miro.medium.com/max/700/1*1SpBvydV3gkBreY7LEnavg.png)

Ana skor puanı hesaplanırken, bu 6 kriterden alınan saniye cinsinde değeri, oranlarına göre hesaplayıp ortalama bir puan üretilmektedir. LCP ve TBT bu puanı etkileyen iki önemli parametredir. LCP- CLS ve FCP parametrelerini yukarıda değinmiştik. Gelin şimdi de diğer parametrelere göz atalım.

### METRİKLER

📌**Speed Index (SI)**, Hız Endeksi anlamına gelir ve sayfanın yüklenme aşamasında içeriğin görüntülenme hızını ölçer. Bir başka deyişle sayfanın içeriğinin ne kadar çabuk yüklendiğini gösterir. Bu parametre ne kadar düşükse kadar düşükse o kadar iyidir. Hız Endeksi puanınızı düşürmek için sayfanızı daha hızlı yüklenecek şekilde görsellerinizi optimize etmeniz gerekir. Renk durum karşılıkları ise aşağıdaki görseldeki gibidir.

![](https://miro.medium.com/max/700/1*-oJcxgNRqaWhIaw2GBXutg.png)

📌**Time To Interactive (TTI)**, Etkileşime geçme zamanı olarak çevrilebilir. Bir web sayfasının kullanıcı için kullanıma hazır olma, yani tam etkileşimli olmasına kadar geçen zamanı ölçen bir performans metriğidir.

![](https://miro.medium.com/max/700/1*W78Qh4oTy7EUQDoWo_83CA.png)

📌**Total Blocking Time (TBT),** Toplam Engelleme Süresi ya da Toplam Blokaj Süresi anlamına gelen ve yüklenen sayfanın tamamen etkileşimli bir hale gelmeden önce ne kadar süre etkileşimsiz olduğunu ölçmeye yarayan bir metriktir. Bir bakıma sayfanın etkileşimlere vereceği cevabın gecikme süresini hesaplar.

![](https://miro.medium.com/max/700/1*hpg04Y6p4cdq0xaGiQp0kA.png)

### FIRSATLAR

Web sitenin performans metriklerini arttırmaya yönelik iyileştirme önerileri sunmaktadır. Öneri ve iyileştirmeler uygulandığında web site hızının artması kaçınılmazdır. Dikkate almanızı öneririm.

![](https://miro.medium.com/max/700/1*nbX1mt-RimvtLv7fZW6lPw.png)

### TEŞHİS
PageSpeed, web site hızının neden düşük olduğuyla ilgili çıkarımlarda bulunur ve web geliştiricileri için, Sunucu, DOM, CSS ve JavaScript uygulamaları hakkında öneriler sağlar.

![](https://miro.medium.com/max/700/1*sJmYnBiDO4AeKHOVWDv_aw.png)

Görüldüğü üzere **PageSpeed Insights**, web sitenizi hem **mobil** hem de **masaüstü** cihazlar için test etmekte ve web sitenizi optimize etmek için öneriler vermektedir.

### KAYNAKLAR

https://www.semrush.com/blog/how-to-improve-your-google-pagespeed-insights-score/<br>
https://www.turhost.com/blog/google-pagespeed-insights-nedir/<br>
https://www.searchenginejournal.com/google-pagespeed-insights-guide/422854/<br>
https://kinsta.com/blog/google-pagespeed-insights/<br>

Bir sonra ki yazımda görüşmek üzere…



Medium : 
https://medium.com/@onurerdemiroglu/google-pagespeed-insights-nedir-nasıl-kullanılır-cc9098d15599
