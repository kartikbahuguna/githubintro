package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.core.cli.Main;

public class Test {
	public static void main(String[] args) throws Throwable {
		String s = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		Main.main(new String[] { "-g", "StepDefinition",
				"C:\\Users\\Kartik.Bahuguna\\eclipse-workspace\\com.restAssured\\src\\test\\resources\\Features\\CRUD.feature",
				"-p", "pretty", "-t", "@smoke", "-p", "html:Extent/HtmlReports" + s + "/report.html" });

	}

}