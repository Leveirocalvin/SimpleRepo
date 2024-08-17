package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/cucumber",glue="cucumber.stepDefinitions",monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests 
{
	
}



//feature - path of feature FILES
//glue - step definitions for all that feature FILE'S'
//monochrome - to show report in readable format
//tags - like groups in testNG
//plugin - cucumber report

// @CucumberOptions(features="src/test/java/cucumber",glue="rahulshettyacademy.stepDefinitions",
// monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html"})