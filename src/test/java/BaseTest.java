import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setup() {
        // Set up base URI once for all tests
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
