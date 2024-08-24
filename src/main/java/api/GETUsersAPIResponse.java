package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static files.ReusableMethods.rawToJson;
import static org.hamcrest.Matchers.*;

public class GETUsersAPIResponse {
    /**
     * Validates the HTTP status code of the response.
     *
     * @param response           the response to validate
     * @param expectedStatusCode the expected status code
     */
    public static void validateResponseStatus(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode); // Check if the status code matches the expected value
    }

    /**
     * Validates the structure and content of the response body.
     *
     * @param response the response to validate
     */
    public static void validateResponseBody(Response response) {
        response.then()
                .body("page", equalTo(3)) // Validate 'page' field
                .body("per_page", equalTo(6)) // Validate 'per_page' field
                .body("total", equalTo(12)) // Validate 'total' field
                .body("total_pages", equalTo(2)) // Validate 'total_pages' field
                .body("data.size()", equalTo(6)) // Validate the size of the 'data' array
                .body("data.id", everyItem(notNullValue())) // Ensure each 'id' in 'data' is not null
                .body("data.email", everyItem(notNullValue())) // Ensure each 'email' in 'data' is not null
                .body("data.first_name", everyItem(notNullValue())) // Ensure each 'first_name' in 'data' is not null
                .body("data.last_name", everyItem(notNullValue())) // Ensure each 'last_name' in 'data' is not null
                .body("data.avatar", everyItem(notNullValue())) // Ensure each 'avatar' in 'data' is not null
                .body("support.url", equalTo("https://reqres.in/#support-heading")) // Validate 'support.url' field
                .body("support.text", equalTo("To keep ReqRes free, contributions towards " +
                        "server costs are appreciated!")); // Validate 'support.text' field
    }

    /**
     * Print the response
     */
    public static void printResponse(Response response) {
        String res = response.then().log().all().extract().response().asString();
        JsonPath printResponse = rawToJson(res);
        System.out.println(printResponse);
    }
}
