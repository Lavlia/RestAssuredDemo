package runner;

import org.testng.annotations.Test;
import cucumber.api.cli.Main;

public class TestRunner {
    @Test
    public void testRunner() {
        Main.main(new String[]{
                "-p", "pretty",
                "-p", "html:target/cucumber-reports",
                "-p", "json:target/report.json",
                "-g", "stepsDefinition", "src/test/java/features"
        });
    }

}
