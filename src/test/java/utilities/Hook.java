package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

	@Before(order=2)
    public void beforeScenario1(){
        System.out.println("This 1 will run before the Scenario");
    }	

	@Before(order=0)
    public void beforeScenario2(){
        System.out.println("This 2 will run before the Scenario");
    }	

	@Before(order=1)
    public void beforeScenario3(){
        System.out.println("This 3 will run before the Scenario");
    }	
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
    }
}
