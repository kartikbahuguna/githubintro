package StepDefinition;

import org.json.simple.JSONObject;

import io.cucumber.java.en.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import io.restassured.response.Response;

public class DeleteCompile {
	
	Response response;
	JSONObject requestParams;
	JSONObject request = null;


	@Given("^I set DELETE employee service api endpoint and (.*)$")
	public void i_set_DELETE_employee_service_api_endpoint_and_file_loc(String file_loc) {

		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(file_loc);
			prop.load(input);
			baseURI = prop.getProperty("baseUri");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@When("^I create DELETE HTTP request and pass the (.*)$")
	public void i_create_DELETE_put_request_and_pass_the_endpointUri(String endpointUri) {

		response = given().header("Content-Type", "application/json").delete(endpointUri);

	}

	@Then("^I check the DELETE response by (.*)$")

	public void i_check_the_DELETE_reponse_by_statuscode(int statuscode) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, statuscode);
		response.getBody().prettyPrint();

	}

	

}