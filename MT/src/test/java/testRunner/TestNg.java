package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/resources/features", glue = "testStepDefinitions", tags="@MTMOUSDP", monochrome=true)

public class TestNg extends AbstractTestNGCucumberTests {


}
