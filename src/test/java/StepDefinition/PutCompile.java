package StepDefinition;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import io.cucumber.java.en.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.restassured.response.Response;

public class PutCompile {


	Response response;
	JSONObject requestParams;
	JSONObject request = null;

	@Given("^I set PUT employee service api endpoint and (.*)$")
	public void i_set_PUT_employee_service_api_endpoint_as_baseUri_and_file_loc(String file_loc) {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(file_loc);
			prop.load(input);
			baseURI = prop.getProperty("baseUri");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Given("^I create a put request and enter updated (.*) and (.*)$")
	public void i_create_a_put_request_and_enter_updated_name_and_job(String name,String job) throws IOException {
//		XSSFWorkbook wb = new XSSFWorkbook("D:\\Excel\\Book1.xlsx");
//		XSSFSheet sheet = wb.getSheet("Sheet1");
//		int count = sheet.getPhysicalNumberOfRows();
//		System.out.println(count);
//		String celldata = sheet.getRow(1).getCell(0).getStringCellValue();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", name);
		map.put("job", job);
		request = new JSONObject(map);
	}

	@When("^I pass the put request and (.*)$")
	public void i_pass_the_put_request_and_endpointUri(String endpointUri) throws Exception {

		response = given().header("Content-Type", "application/json").body(request.toJSONString()).when()
				.put(endpointUri);
	}

	@Then("^I check the put response by (.*)$")
	public void i_check_the_put_reponse_by_statuscode(int statuscode) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, statuscode);
		response.getBody().prettyPrint();

	}

}