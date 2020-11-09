package practicecucumber1;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/report.html"},
        glue = "stepsDefinitions",
        features = "src/test/resources/practicecucumber1"


)
public class RunCucumberTest {

}
