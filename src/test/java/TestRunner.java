import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@Carrito2",
        glue = "step",
        plugin =  {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        //plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-report/cucumber-report.html"},
        monochrome = true
)

public class TestRunner {
}
