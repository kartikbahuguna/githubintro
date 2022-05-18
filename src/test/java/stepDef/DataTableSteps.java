package stepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {

	WebDriver driver; //modified//
	String projectpath = System.getProperty("user.dir");
	@Given("^User is on Login Page$")
	public void user_is_on_login_page() {
	System.setProperty("webdriver.chrome.driver", projectpath +"/src/test/resources/Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");

	}




	@When("User enters Credentials to LogIn")
	public void user_enters_credentials_to_log_in(DataTable table) {
	List<List<String>> data = table.cells();
	driver.findElement(By.id("txtUsername")).sendKeys(data.get(0).get(0));
	driver.findElement(By.id("txtPassword")).sendKeys(data.get(0).get(1));
	driver.findElement(By.id("btnLogin")).click();


	}



	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {

	System.out.println("Welcome Ashutosh!! Logged in successfuly ");
	driver.close();
	driver.quit();
	}
}
