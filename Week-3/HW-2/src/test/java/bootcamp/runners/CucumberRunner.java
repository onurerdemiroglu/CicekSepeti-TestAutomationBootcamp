package bootcamp.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/default-html-reports",
                "pretty"
        },
        glue="bootcamp/step_def",
        features = "src/test/resources/features",
        tags = "@positive",
        dryRun = false
)
public class CucumberRunner {

}
