 package runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "FeatureFiles",
		 glue= {"stepDefinitions"},	 
		plugin = {"reporter.ExtentCucumberAdapter:","rerun:test-output/RerunCases/rerun.txt","json:test-output/cucumber-JSON-report/JSONReport.json","junit:test-output/cucumber-XML-report/XMLReport.xml"},
		 monochrome = true,
		 dryRun = false		 
		 ,tags = {"not @No","@Yes"}
 )

public class Runner extends AbstractTestNGCucumberTests{
	
		}
