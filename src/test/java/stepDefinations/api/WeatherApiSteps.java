package stepDefinations.api;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeatherApiSteps {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API_KEY="5e2eb10fc89352405be6159ff61eae27";
    Response response;
    ResponseBody body;

    @Given("^I made a Get request on \"([^\"]*)\" API with Latitude \"([^\"]*)\",Longitude \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMadeAGetRequestOnAPIWithLatitudeLongitude(String path, String latitude, String longitude, String dailyHours){
        RestAssured.baseURI = BASE_URL;

        response =  given().get(baseURI+path+"lat="+latitude+"&lon="+longitude+"&"+dailyHours+"&APPID="+API_KEY+"").then().extract().response();
    }

    @When("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int statusCode) {

        assertEquals(statusCode, response.statusCode());
    }


    @Then("^I should verify the response from the server with following response:$")
    public void iShouldVerifyTheResponseFromTheServerWithFollowingResponse(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();

        body = response.getBody();

        assertNotNull(response.body());

        String actual = response.getBody().asString();

         assertEquals(data.get(1).get(0), body.jsonPath().get("lat").toString());

         assertEquals(data.get(1).get(1), body.jsonPath().get("lon").toString());

         assertEquals(data.get(1).get(2), body.jsonPath().get("timezone"));

        System.out.println(actual+".....................body");

    }
}
