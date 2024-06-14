package activities;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Activity2 {

    @Test(priority = 1)
    public void addNewUser(){


        File file = new File("src/test/resources/FST.json");
        Response response=
                given().baseUri("https://petstore.swagger.io/v2/user").
                        header("Content-Type", "application/json").
                        body(file).
                        log().all().
                        when().post();


        //Assertions
        response.then().
                statusCode(200).
                body("code",equalTo(200)).
                body("message",equalTo("102111"))
                .log().all();



    }

    @Test(priority = 2)
    public void getUserName(){
        given().
                baseUri("https://petstore.swagger.io/v2/user").
                header("Content-Type", "application/json").
                pathParam("username","padminitest").
                log().all().
                when().
                get("/{username}").
                then().
                statusCode(200).
                body("id",equalTo(102111)).
                body("firstName",equalTo("Padmini")).
                body("lastName",equalTo("Test")).
                body("username",equalTo("padminitest")).
                body("email",equalTo("padminitest@mail.com")).
                body("phone",equalTo("9998822422")).
                log().all();
    }


    @Test(priority = 3)
    public void deleteUser(){
        given().
                baseUri("https://petstore.swagger.io/v2/user").
                header("Content-Type", "application/json").
                pathParam("username","padminitest").
                log().all().
                when().
                delete("/{username}").
                then().
                statusCode(200).
                body("message",equalTo("padminitest")).
                log().all();

    }
}

