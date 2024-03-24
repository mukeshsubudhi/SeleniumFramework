package Cucumber;

@CucumberOptions(feature = "src/test/java/cucmber", glue = "stepDefinitions", monochrome = true, plugin = {
		"html:target/cucmber.html" })
public class TestNGTestRunner extends AbstractTestNGCucumberTest{
	
	
}
