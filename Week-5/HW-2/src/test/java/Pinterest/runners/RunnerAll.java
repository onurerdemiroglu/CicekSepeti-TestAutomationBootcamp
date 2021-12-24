package Pinterest.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@message",
        plugin = {"html:target/reports/index.html","json:target/reports/cucumber.json" ,"pretty"},
        features = {"src/test/java/Pinterest/features/steps.feature"},
        glue = {"Pinterest.definations"},
        dryRun = false
)

public class RunnerAll {


}
