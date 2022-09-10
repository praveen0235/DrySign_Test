package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(
		features = "@test-output/RerunCases/rerun.txt",
		 glue= {"stepDefinitions","baseinit"},
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:test-output/cucumber-JSON-report/JSONReport.json","junit:test-output/cucumber-XML-report/XMLReport.xml"},
		 monochrome = true,
		 dryRun = false
		 
		,tags = {"not @No","@Yes"}
 )


public class failedScenariosRunner {

}
