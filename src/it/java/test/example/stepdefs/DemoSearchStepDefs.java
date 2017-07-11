package test.example.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.Assertion;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.example.WebDriverFactory;
import test.example.pageobjects.DemoPageObjects;

/**
 * Step definition class for DemoSearch.feature
 * tearDown method runs after all scenarios 
 * are completed, closing the shared WebDriver
 * 
 *
 */
public class DemoSearchStepDefs {

	private WebDriver webDriver = WebDriverFactory.getBrowser("Chrome");
	private DemoPageObjects homePageObjects = new DemoPageObjects(webDriver);
	private Assertion hardAssert = new Assertion();

	@Then("^Verify that there is a search field that will produce a search for the word \"([^\"]*)\"$")
	public void verify_that_there_is_a_search_field_that_will_produce_a_search_for_the_word(String searchWord)
			throws Throwable {
		homePageObjects.performProductSearch(searchWord);
		Assert.assertTrue(homePageObjects.checkSearchResults());
	}

	@AfterSuite
	public void tearDown() {
		WebDriverFactory.closeDrivers();
	}
}
