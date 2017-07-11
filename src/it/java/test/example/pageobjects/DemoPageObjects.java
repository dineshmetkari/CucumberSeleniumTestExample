package test.example.pageobjects;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Manages the shared WebDriver
 * 
 *
 */
public class DemoPageObjects {

	private WebDriver webDriver = null;
	private Properties p = new Properties(System.getProperties());

	public DemoPageObjects(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public DemoPageObjects() {
	}

	/**
	 * Reads a property file to obtain a URL
	 * 
	 * @return a property object representing the URl to test
	 */
	public Object getURL() {
		return p.getProperty("baseUrl");
	}

	/**
	 * Reads a property file to obtain a value for matching a page title.
	 * 
	 * @return a property object representing the URl to test
	 */
	public Object getSiteTitle() {
		return p.getProperty("siteTitle");
	}

	/**
	 * Reads a property file to obtain a setting value for Selenium Chrome
	 * browser
	 * 
	 * @return a property object representing the URl to test
	 */
	public Object getChromeSetting() {
		return p.getProperty("chromeSetting");
	}

	/**
	 * Reads a property file to obtain a setting value for Selenium IE browser
	 * 
	 * @return a property object representing the URl to test
	 */
	public Object getIESetting() {
		return p.getProperty("ieSetting");
	}

	/**
	 * Loads a retrieved URL via webDriver.
	 * 
	 */
	public void loadUrl() {
		System.out.println("The url is: " + getURL());
		webDriver.get((String) getURL());
	}

	/**
	 * Returns a WebDriver
	 * 
	 * @return a WebDriver
	 */
	public WebDriver getWebDriver() {
		return webDriver;
	}

	/**
	 * Gets web page title from the WebDriver
	 * 
	 * @return a String representing a web page title
	 */
	public String getTitle() {
		return webDriver.getTitle();
	}

	/**
	 * Locates a search input field, enters a value into the file and submits
	 * the value.
	 * 
	 * @param input
	 *            is a String representing a search value
	 */
	public void performProductSearch(String input) {
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/header/nav/form/fieldset/input[1]")).sendKeys(input);
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div/header/nav/form/fieldset/input[1]")).submit();

	}

	/**
	 * 
	 * @return
	 */
	public boolean checkSearchResults() {
		return webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/a"))
				.isDisplayed();
	}

	/**
	 * Terminates the JVM. This would typically be used only with prerequisites
	 * features which perform checks that are critical to the remaining features
	 * (i.e. if website being tested is available). If the prerequisites fail,
	 * all of the subsequent features will fail, so terminating the JVM will
	 * stop any further tests.
	 */
	public void shutdown() {
		System.out.println("The site title is not correct. URL not loaded. EXITING!!!");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		s += "/src/it/java/test/example/error.html";
		webDriver.navigate().to("file://" + s);
		webDriver.quit();
		System.exit(0);
	}

}
