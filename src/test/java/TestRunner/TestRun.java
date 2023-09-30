package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/Customer.feature"
		,glue={"Steps"},
		dryRun = false,
		monochrome = true,
		tags="@regression",
		//plugin = {"pretty","html:target/cucumber-reports/report11_xml.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)


// html format report plugin = {"pretty","html:target/cucumber-reports/report1.html"}

//json format report plugin = {"pretty","json:target/cucumber-reports/report1_json.json"}

public class TestRun extends AbstractTestNGCucumberTests{

}
