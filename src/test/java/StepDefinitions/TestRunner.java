package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
glue= {"StepDefinitions"},
monochrome = true,
plugin = {"pretty", "html:target/HtmlReports/report.html",
		"json:target/JSONReports/report.json",
		"junit:target/JUnitReport/report.xml"},

tags= "(@LoginScenario and (@ValidTest or @InvalidTest or @BlankTest)) or " + 
	  "(@LogoutScenario and (@ValidTest)) or" +
	  "(@RegisterScenario and (@InvalidTest)) or" +
	  "(@SearchSectionScenario and (@ValidTest or @InvalidTest))"

)

public class TestRunner {

}
