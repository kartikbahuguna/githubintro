package StepDefinition;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONObject;

import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetCompile {
	
	Response response;
	JSONObject requestParams;
	JSONObject request = null;

	
	@Given("^I set GET employee service api endpoints and (.*)$")
	public void i_set_GET_employee_service_api_endpoint_as_baseUri_and_file_loc(String file_loc) {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(file_loc);
			prop.load(input);
			baseURI = prop.getProperty("baseUri");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("^I create a get request and pass the (.*)$")
	public void i_create_a_get_request_and_pass_the_endpointUri(String endpointUri) {

		 response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpointUri)
                .then()
                .extract().response();
		
	}

	@Then("^I check the get response by (.*)$")

	public void i_check_the_get_response_by_statuscode(int statuscode) {
	
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, statuscode);
		response.getBody().prettyPrint();

	}


}