package examples;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class FirstTest {
    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
    @Test
    public void getRequestWithQueryParam(){
        Response response =
                given().
                        baseUri("https://petstore.swagger.io/v2/pet").
                        header("Content-Type","application/json").
                        queryParam("status","alive").
                        when().
                        get("/findByStatus");

        //Get Body and Header and print it
        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.getHeaders().asList());

        String petStatus = response.then().extract().path("[0]['status']");
        System.out.println("Pet status is: " + petStatus);

        Assert.assertEquals(petStatus, "alive");
    }

    // GET https://petstore.swagger.io/v2/pet/{petId}
    @Test
    public void getRequestWithPathParam(){
        // send request, get Response and asset response with logging
        given().
           baseUri("https://petstore.swagger.io/v2/pet").
           header("Content-Type", "application/json").
           pathParam("petId", 12334).
           log().all().
        when().
           get("/{petId}").
        then().
            statusCode(200).
            body( "name", equalTo("Ramsy")).
            body("status", equalTo("alive")).
            log().all();
    }
}
