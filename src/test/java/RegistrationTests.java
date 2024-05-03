import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegistrationTests {
    @Test
    void registerUserSuccesful() {
        String requestBody = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";
        given()
                .baseUri(apiTestingConfig.BASE_URL)
                .contentType("application/json")
                .body(requestBody).
                when()
                .post("api/register").
                then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("token", notNullValue());
    }

    @Test
    void registerUserNotSuccesful() {
        String requestBody = "{\"email\": \"sydney@fife\"}";
        given()
                .baseUri("https://reqres.in/")
                .contentType("application/json")
                .body(requestBody).
                when()
                .post("api/register").
                then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));
    }

    @Test
    void updateUserSuccesful() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"zion resident\", \"updateAt\": \"2024-05-01T09:10:47.298Z\" }";
        given()
                .baseUri(apiTestingConfig.BASE_URL)
                .contentType("application/json")
                .body(requestBody).
                when()
                .put("api/users/2").
                then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .body("updateAt", equalTo("2024-05-01T09:10:47.298Z"));
    }

    @Test
    void deleteUser() {
        String requestBody = "{\"name\": \"morpheus\", \"job\": \"zion resident\", \"updateAt\": \"2024-05-01T09:10:47.298Z\" }";
        given()
                .baseUri(apiTestingConfig.BASE_URL)
                .contentType("application/json")
                .body(requestBody).
                when()
                .delete("api/users/2").
                then()
                .statusCode(204);
    }
}
