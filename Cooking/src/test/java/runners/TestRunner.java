package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/use_cases2",
    glue = "stepDefinitions",
    plugin = {"pretty", "summary"},
    monochrome = true,
    tags="@LS"
    
    
    


)
public class TestRunner {
}
