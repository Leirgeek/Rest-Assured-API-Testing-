import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class userTests {
    @Test
    void selectAllMembers(){
        //Get the endpoint url and store the response in a variable response
        Response response = get("https://reqres.in/api/users?page=2");
        //print the response and conver it to a string
        System.out.println("Response : "+response.asString());
        //print the status code
        System.out.println("Status Code : "+response.statusCode());
        //get the response body and convert it to a string
        System.out.println("Body : "+response.getBody().asString());
        //get the response time
        System.out.println("Time taken : "+response.getTime());
        //get the response header
        System.out.println("Header : "+response.getHeader("Content-type"));

        //create assertions. for status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    void Test2(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200); //including assertions
    }

    @Test
    void singleUserFound(){
        baseURI = "https://reqres.in/api/";
        given().get("users?page=2").then().statusCode(200).
                body("data[3].first_name", equalTo("Byron"));
        //body("data[3].first_name", hasItems("Byron"));

    }

    @Test
    void singleUserNotFound(){
        baseURI = "https://reqres.in/";
        given().get("api/users?page-2").
                then().
                statusCode(200).
                body("data[1].first_name", equalTo("Janet"));


    }
    //hasmap test
    @Test
    void testPost(){
        //include the body using hashmap. K-> string value, V-> object
        Map<String, Object> map = new HashMap<>();
        map.put("name","morpheus");
        map.put("job","leader");
        System.out.println(map);

    }
}
