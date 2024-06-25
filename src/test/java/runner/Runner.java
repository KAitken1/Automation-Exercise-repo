package runner;

import glue.W;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        dryRun = false,
        monochrome = false,
        features = {"src/test/resources/tests"},
        glue = {"glue"},
        plugin = {"html:target/cucumber-html/cucumber.html", "json:target/cucumber-json/cucumber.json"},
        tags = "not @passwordchange" //Exclude password change due to missing step file       
)
public class Runner {
    @AfterClass
    public static void close() {
        W.close();
    }
}
