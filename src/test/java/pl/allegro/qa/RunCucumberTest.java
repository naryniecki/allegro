package pl.allegro.qa;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:reports", "json:reports/tests.json", "junit:reports/tests.xml"})
public class RunCucumberTest {
}
