package test.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/it/resources", glue = "test.example.stepdefs", strict = true, tags = {
		"@DemoPrerequisites" }, plugin = { "json:target/cucumber-report.json" })
public class CucumberFeaturesPrerequisiteIT extends AbstractTestNGCucumberTests {

}
