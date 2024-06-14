package examples;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId;

    @BeforeClass
    public void setUp() {
        // Request Specifications
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();
        // Response Specifications
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status", equalTo("alive"))
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();
    }

    // POST https://petstore.swagger.io/v2/pet
    @Test(priority = 1)
    public void postRequest() {
        // Request Body
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 1122);
        reqBody.put("name", "Charlie");
        reqBody.put("status", "alive");

        // Save the Response
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        // Extract petId
        petId = response.then().extract().path("id");
        // Assertions
        response.then().spec(responseSpec).body("name", equalTo("Charlie"));
    }

    // GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
    @Test(priority = 2)
    public void getRequest() {
        given().spec(requestSpec).pathParam("petId", petId).
                when().get("/{petId}").
                then().spec(responseSpec);
    }

    // DELETE https://petstore.swagger.io/v2/pet/{petId}
    @Test(priority = 3)
    public void deleteRequest() {
        // send request, get Response, assert
        given().spec(requestSpec).pathParam("petId", petId).
                when().delete("/{petId}").
                then().statusCode(200).body("message", equalTo("" + petId));
    }


}
