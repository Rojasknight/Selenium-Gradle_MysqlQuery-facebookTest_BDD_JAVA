package co.com.accenture.Facebook.gradle.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src.test.resources/features/Facebook.feature",
		glue = {"co.com.accenture.Facebook.gradle.stepdefinition"}		
)
		
public class FacebookSearcRunner {

}
