import api.GETUsersAPIResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static api.GETUsersAPIRequest.getResponse;


public class ReqresE2ETests extends BaseTest{

    @Test
    @Step("Test case with Allure Reporting")
    public void validateApiResponseStructure() {
        // Get the response from the API endpoint
        Response response = getResponse("/users?page=2");

        // Validate the HTTP status code of the response
        GETUsersAPIResponse.validateResponseStatus(response, 200);

        // Validate the structure and content of the response body
        GETUsersAPIResponse.validateResponseBody(response);

        // Print the whole response
        GETUsersAPIResponse.printResponse(response);
    }
}
