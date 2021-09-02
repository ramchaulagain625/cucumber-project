package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/Resources/Features",
        glue = "steps",
        dryRun = false,
        monochrome = true,
        strict = true,
        tags="",
        plugin={"pretty","html:target/cucumber-default-report.html","json:target/cucumber.json","rerun:target/failed.txt"}
)
public class TestRunner {

}
