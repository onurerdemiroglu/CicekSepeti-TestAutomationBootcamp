# Rest Assured - Medium API Test

Merhaba, bu projede Java dilinde Rest Assured ile TestNG kütüphaneleri kullanılarak Medium API testleri yapılmaktadır.

### 👨‍💻 Medium - Integration Token Nasıl Alınır?  
---

> Medium hesabımıza giriş yaptıktan sonra Settings'e basıyoruz
 
![Medium settings](https://user-images.githubusercontent.com/35347777/145384469-e0121f84-af2f-4db2-8e8b-651d5b124abe.PNG)
 
>Ardından Integraion Tokens'e basalım 

![Integration token](https://user-images.githubusercontent.com/35347777/145384489-8e2ee475-6465-4658-b20f-1f28345f0259.PNG)
 
> Bir açıklama girip "Get integration token" butonuna basalım 

![CicekSepeti Integration Token](https://user-images.githubusercontent.com/35347777/145385183-9a57b443-556b-4e84-a363-be51d9878cda.PNG)
<br>

`
Tokenimizi aldık 🙂 Testlere geçebiliriz 🔎`

### 👨🏿‍💻 Test-1 : getUserDetails()

---


| API Referansı | Sorgu Adresi | İstek Yöntemi | Yetkilendirme | Yapılan Test |
| ---- | ---- | ---- | ---- | ---- |
| Uygulamaya izin veren kullanıcının bilgilerini döndürür | https://api.medium.com/v1/me | GET | Gerekli | Kullanıcı Adı ve URL sorgusu |

**Yanıt Verileri:**

| Alan | Veri Tipi | Açıklama |
| ---- | ---- | ---- |
| id  | string | Kullanıcı için tanımlanan benzersiz sayı |
| username | string | İzin veren kullanıcının Medium'daki kullanıcı adı |
| name | string | Kullanıcının Medium'daki adı |
| url | string | Kullanıcının Medium'daki profil URL'si |
| imageUrl | string | Kullanıcının Medium'daki avatarının URL'si |

**Olası hatalar:**

| Hata Kodu | Açıklama |
| ---- | ---- |
| 401 Unauthorized | Token kodunuz geçersiz veya iptal edildi |



**Method:**
```java
public void getUserDetails() {
    String requestUrl = String.format("%s/v1/me", baseURL);

    Response response =
        given()
            .headers("Authorization", "Bearer " + accessToken)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .get(requestUrl)
        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .extract().response();

    String username = response.path("data.username").toString();
    String url = response.path("data.url").toString();

    Assert.assertEquals(username, "cs_bootcamp");
    Assert.assertEquals(url, "https://medium.com/@cs_bootcamp");
} 
```
**Result:**

![Usage](https://user-images.githubusercontent.com/35347777/145391175-2ce51133-03a3-4d6b-938b-488b54a1f07f.gif)

![UserDetails](https://user-images.githubusercontent.com/35347777/145380316-37bae310-d348-4e8b-bba9-3ed89c0bfe62.PNG)

### 👨🏿‍💻 Test-2 : listingPublications()

---


| API Referansı | Sorgu Adresi | İstek Yöntemi | Yetkilendirme | Yapılan Test |
| ---- | ---- | ---- | ---- | ---- |
| Kullanıcının abone olduğu, yazdığı veya düzenlediği tüm yayınların tam listesini döndürür  | https://api.medium.com/v1/users/{{userId}}/publications | GET | Gerekli | İlk Yayının Adı ve Url Sorgusu |

**Yanıt Verileri:**

| Alan | Veri Tipi | Açıklama |
| ---- | ---- | ---- |
| id  | string | Yayın için tanımlanan benzersiz sayı |
| name | string | Yayının Medium'daki adı |
| description | string | Yayının kısa açıklaması |
| url | string | Yayının ana sayfasının URL'si |
| imageUrl | string | Yayının resminin/logosunun URL'si |

**Olası hatalar:**

| Hata Kodu | Açıklama |
| ---- | ---- |
| 401 Unauthorized | Token kodunuz geçersiz veya iptal edildi |
| 403 Forbidden | İstek, başka bir kullanıcı için yayınları listelemeye çalışıyor |



**Method:**
```java
public void listingPublications() {
    String requestUrl = String.format("%s/v1/users/%s/publications", baseURL, userId);

    Response response =
        given()
            .headers("Authorization", "Bearer " + accessToken)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .get(requestUrl)
        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .extract().response();

    String firstPubName = response.path("data[0].name").toString();
    String firstPubUrl = response.path("data[0].url").toString();

    Assert.assertEquals(firstPubName, "The Daily Cuppa");
    Assert.assertEquals(firstPubUrl, "https://medium.com/the-daily-cuppa");
}
```
**Result:**

![Usage](https://user-images.githubusercontent.com/35347777/145393483-9f4af033-875d-42fa-8f7a-2cbea5f7330e.gif)

![listingPublications](https://user-images.githubusercontent.com/35347777/145393731-74ed7b87-b157-4786-bb0e-b1a818944439.PNG)


### 👨🏿‍💻 Test-3 : listingContributors()

---


| API Referansı | Sorgu Adresi | İstek Yöntemi | Yetkilendirme | Yapılan Test |
| ---- | ---- | ---- | ---- | ---- |
| Yayın için katkıda bulunanların listesini döndürür  | https://api.medium.com/v1/publications/{{publicationId}}/contributors | GET | Gerekli | Yayın ID ve Rol sorgusu |

**Yanıt Verileri:**

| Alan | Veri Tipi | Açıklama |
| ---- | ---- | ---- |
| publicationId  | string | Yayın için benzersiz bir kimlik |
| userId | string | Katkıda bulunanın kullanıcı kimliği |
| role | string | Yayında "userId" ile tanımlanan kullanıcının rolü. 'editor' veya 'writer' olabilir |

**Olası hatalar:**

| Hata Kodu | Açıklama |
| ---- | ---- |
| 401 Unauthorized | Token kodunuz geçersiz veya iptal edildi | 



**Method:**
```java
public void listingContributors() {
    String requestUrl = String.format("%s/v1/publications/%s/contributors", baseURL, publicationId);

    Response response =
        given()
            .headers("Authorization", "Bearer " + accessToken)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
        .when()
            .get(requestUrl)
        .then()
            .statusCode(200)
            .time(lessThan(3000L))
            .extract().response();

    String contrID = response.path("data[0].publicationId").toString();
    String contrRole = response.path("data[0].role").toString();

    Assert.assertEquals(contrID, publicationId);
    Assert.assertEquals(contrRole, "editor");
}
```
**Result:**

 
![Usage](https://user-images.githubusercontent.com/35347777/145396094-99893ecd-283d-4b4d-a10f-a0658eec79c1.gif)

![listingContributors](https://user-images.githubusercontent.com/35347777/145396102-15c7e54f-d5ae-4028-9f76-3243f38aac2f.PNG)


### 👨🏿‍💻 Test-4 : createPost()

---


| API Referansı | Sorgu Adresi | İstek Yöntemi | Yetkilendirme | Yapılan Test |
| ---- | ---- | ---- | ---- | ---- |
| Gönderi oluşturur  | https://api.medium.com/v1/users/{{authorId}}/posts | POST | Gerekli | Gönderi Başlığı ve canonicalUrl Sorgusu  |

**İleti Verileri:**

| Parametre | Veri Tipi | Yetkilendirme | Açıklama |
| ---- | ---- | ---- | ---- |
| title  | string | Gerekli | Yazının başlığı |
| contentFormat  | string | Gerekli | İçerik formatı, "html" veya "markdown" olabilir |
| content  | string | Gerekli | İçerik yazısı|
| tags  | dizi(string) | İsteğe bağlı | İçerik etiketleri, sadece ilk üçü kullanılacaktır. Etiketler karakterden kısa olmalı |
| canonicalUrl  | string | İsteğe bağlı | Orijinal olarak başka bir yerde yayınlanmışsa, bu içeriğin orijinal ana sayfası |
| publishStatus  | enum | İsteğe bağlı | Gönderinin gizlilik durumu. Varsayılan "public" olarak gelir. Kullanılabilen durumlar ise,"public", "draft" veya "unlisted" dır |
| notifyFollowers  | bool | İsteğe bağlı | Kullanıcının yayınladığı içeriğin Takipçilere bildirim yapılıp yapılmayacağı |

**Yanıt Verileri:**

| Alan | Veri Tipi | Açıklama |
| ---- | ---- | ---- |
| id | string | Gönderi için tanımlanan benzersiz sayı |
| title | string | Gönderinin başlığı |
| authorId | string | Yazarın kullanıcı kimliği |
| tags | dizi(string) | Gönderi etiketleri |
| url | string | Gönderinin URL'si |
| canonicalUrl | string | Gönderinin standart URL'si. Gönderinin oluşturulmasında canonicalUrl belirtilmemişse, bu alan mevcut olmayacaktır |
| publishStatus | string | Gönderinin yayınlanma durumu |
| publishedAt  | timestamp | Gönderinin yayınlanma tarihi |


**Olası hatalar:**

| Hata Kodu | Açıklama |
| ---- | ---- |
| 400 Bad Request | Zorunlu alanlar geçersiz veya belirtilmedi| 
| 401 Unauthorized | Token kodunuz geçersiz veya iptal edildi | 
| 403 Forbidden | Kullanıcının yayınlama izni yok veya istek yolundaki AuthorId yanlış ya da var olmayan kullanıcıyı işaret ediyor | 


**PostData:**
```json
{
	"title": "Medium API Test RestAssured"
	"contentFormat": "html"
	"content": "<h1>Medium API Test RestAssured</h1>"
	"canonicalUrl": "https://cs-testbootcamp.com"
	"tags": ["test", "API", "RestAssured"]
	"publishStatus": "public"
}
```

**Method:**
```java
public void createPost() {
    String requestUrl = String.format("%s/v1/users/%s/posts", baseURL, userId);

    String postData = "{\n" +
        "  \"title\": \"Medium API Test RestAssured\",\n" +
        "  \"contentFormat\": \"html\",\n" +
        "  \"content\": \"<h1>Medium API Test RestAssured</h1>\",\n" +
        "  \"canonicalUrl\": \"https://cs-testbootcamp.com\",\n" +
        "  \"tags\": [\"test\", \"API\", \"RestAssured\"],\n" +
        "  \"publishStatus\": \"public\"\n" +
        "}";

    Response response =
        given()
            .headers("Authorization", "Bearer " + accessToken)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(postData)
        .when()
            .post(requestUrl)
        .then()
             .statusCode(201)
             .time(lessThan(3000L))
             .extract().response();

    String postTitle = response.path("data.title").toString();
    String canonicalUrl = response.path("data.canonicalUrl").toString();

    Assert.assertEquals(postTitle, "Medium API Test RestAssured");
    Assert.assertEquals(canonicalUrl, "https://cs-testbootcamp.com");
}
```
**Results:**

 
![usage](https://user-images.githubusercontent.com/35347777/145401573-fcb2b21e-f410-475c-a672-ec8b09146cab.gif)

![createPost](https://user-images.githubusercontent.com/35347777/145401747-69552bb7-bba3-4376-857e-ab5ed11d2ebc.PNG)

![Result](https://user-images.githubusercontent.com/35347777/145404034-bd6de055-5ae9-4c1a-a4ff-aa345885457e.PNG)


### 👨🏿‍💻 Test-5 : uploadImages()

---


| API Referansı | Sorgu Adresi | İstek Yöntemi | Yetkilendirme | Yapılan Test |
| ---- | ---- | ---- | ---- | ---- |
| Yerel görüntü dosyalarınızı yüklemek için kullanılır  | https://api.medium.com/v1/images | POST | Gerekli | Görüntü URL içerisinde değer sorgusu  |
 

**Yanıt Verileri:**

| Alan | Veri Tipi | Açıklama |
| ---- | ---- | ---- |
| url | string | Resmin URL'si | 
| md5 | string | Görüntü verilerinin MD5 değeri  | 


**Olası hatalar:**

| Hata Kodu | Açıklama |
| ---- | ---- |
| 415 Unsupported Media Type | Desteklenmeyen Medya Tipi|  
 
**Method:**
```java
public void uploadImages() {
    String postURL = String.format("%s/v1/images", baseURL);
    File Image = new File(System.getProperty("user.dir") + "//bin//caravan.png");

    Response response =
        given()
            .headers("Authorization", "Bearer " + accessToken)
            .contentType("multipart/form-data")
            .accept(ContentType.JSON)
        .and()
            .multiPart("image", Image, "image/png")
        .when()
            .post(postURL)
        .then()
            .statusCode(201)
            .time(lessThan(3000L))
            .extract().response();


    String url = response.path("data.url").toString();
    Assert.assertTrue(url.contains("https://cdn-images-1.medium.com/proxy"));
}
```
**Results:**

![Usage](https://user-images.githubusercontent.com/35347777/145403812-d212d1ae-32b2-4be6-8c6c-929b5e845d55.gif)
