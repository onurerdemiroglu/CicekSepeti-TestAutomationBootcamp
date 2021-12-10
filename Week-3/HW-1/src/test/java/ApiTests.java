import static io.restassured.RestAssured.*;
import static org.hamcrest.number.OrderingComparison.lessThan;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ApiTests {

    public String baseURL = "https://api.medium.com";
    public String accessToken = "2f5467cf39f11963f1d4e6bf8ee41a6695d4b62f44b5d8adce91d2ebb06ebac55";
    public String userId = "1d7e49c1fd6c898d2babe4d9246a581e3a133352bfeef5ccd10e794350529bd41";
    public String publicationId = "23a1c81f48c3";

    @Test
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

    @Test
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

    @Test
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

    @Test
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
                     .time(lessThan(4000L))
                     .extract().response();

        String postTitle = response.path("data.title").toString();
        String canonicalUrl = response.path("data.canonicalUrl").toString();

        Assert.assertEquals(postTitle, "Medium API Test RestAssured");
        Assert.assertEquals(canonicalUrl, "https://cs-testbootcamp.com");
    }

    @Test
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

}
