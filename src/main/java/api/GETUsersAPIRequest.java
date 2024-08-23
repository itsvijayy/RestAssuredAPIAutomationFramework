package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GETUsersAPIRequest {

    /**
     * Sends a GET request to the specified endpoint and returns the response.
     *
     * @param endpoint the API endpoint to send the request to
     * @return the response from the API
     */
    public static Response getResponse(String endpoint) {
        return given()
                .header("accept", "application/json") // Set the Accept header to request JSON response
                .when()
                .get(endpoint) // Send the GET request
                .then()
                .extract()
                .response(); // Extract the response
    }
}
