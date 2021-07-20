package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/Resources/Features/",
        glue = "APIWorkflowSteps",
        dryRun = false,
        monochrome = true,
        strict = true,
        tags="@APIWorkflow",
        plugin={"pretty","html:target/cucumber-default-report.html","json:target/cucumber.json","rerun:target/failed.txt"}
)
public class APIRunner {

}
