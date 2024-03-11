import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Boarding.feature"},
        glue = {"stepdefs", "utils", "pages", "core", "base"},
        plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "html:target/cucumber-reports/report.html" , "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        publish = true
)
public class RunnerTest {
}