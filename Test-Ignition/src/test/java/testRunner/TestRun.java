package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(features=".//Feature/LO.feature",
 glue="stepDefinition",
 
 monochrome=true,
 plugin= {"pretty","html:test-output"})
 
public class TestRun {

}
