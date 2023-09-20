package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends TestBase {

    @Before
    public void InitiateExtentReport(Scenario scenario) {
        test = reports.createTest("Scenario: "+scenario.getName());
    }

    @After
    public void closeExtentReport(Scenario scenario) {
        if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
            test.info("Test Case completed");
        } else {
            test.info("Test Case Completed");
        }
        reports.flush();
    }
}