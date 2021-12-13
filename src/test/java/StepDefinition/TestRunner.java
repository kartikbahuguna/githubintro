package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Features/CRUD.feature", glue = {
		"StepDefinition" }, tags = "@smoke", monochrome = true, plugin = { "pretty",
				"html:target/reports/cucumber.html", "pretty", "json:target/reports/cucumber.json", "pretty",
				"junit:target/reports/cucumber.xml" })

public class TestRunner {

}