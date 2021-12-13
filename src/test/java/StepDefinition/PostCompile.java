package StepDefinition;

import org.json.simple.JSONObject;

import io.cucumber.java.en.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PostCompile {

	Response response;
	JSONObject requestParams;
	JSONObject request = null;
	ResponseBody extract;

	@Given("^I set POST employee service api endpoint and (.*)$")
	public void i_set_POST_employee_service_api_endpoint_and_file_loc(String file_loc) {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(file_loc);
			prop.load(input);
			baseURI = prop.getProperty("baseUri");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Given("^I create a request and enter (.*) and (.*)$")
	public void i_create_a_request_and_enter_name_and_job(String name, String job) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", name);
		map.put("job", job);
		request = new JSONObject(map);

	}

	@When("^I pass the request and (.*)$")
	public void i_pass_the_request_and_endpointUri(String endpointUri) throws Exception {

		response = given().header("Content-Type", "application/json").body(request.toJSONString()).when()
				.post(endpointUri);
	}

	@Then("^I check the reponse by (.*)$")
	public void i_check_the_reponse_by_statuscode(int statuscode) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, statuscode);
		response.getBody().prettyPrint();
//		extract = response.getBody();
//		extract.prettyPrint();

	}

}