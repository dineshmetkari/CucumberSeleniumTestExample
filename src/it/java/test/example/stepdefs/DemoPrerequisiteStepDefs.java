package test.example.stepdefs;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import test.example.WebDriverFactory;
import test.example.pageobjects.DemoPageObjects;

/**
 * Step Definitions for DemoPrerequisits.feature 
 * Attempts to access the test
 * URL. If the page title is not as expected, terminates the JVM.
 * 
 *
 */
public class DemoPrerequisiteStepDefs {

	private static WebDriver webDriver = WebDriverFactory.getBrowser("Chrome");
	private DemoPageObjects homePageObjects = new DemoPageObjects(webDriver);

	@Given("^that the Demo site has been accessed$")
	public void that_the_Demo_site_has_been_accessed() throws Throwable {
		homePageObjects.loadUrl();
		if (!homePageObjects.getTitle().equals(homePageObjects.getSiteTitle())) {
			homePageObjects.shutdown();
		}
	}
}
