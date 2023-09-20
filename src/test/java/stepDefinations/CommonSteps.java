package stepDefinations;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonSteps extends TestBase {

    @Then("^I verify statuscode as \"([^\"]*)\"$")
    public void i_verify_statuscode(String statusCode) throws Throwable {
        if(world.get("statusCode").equalsIgnoreCase(statusCode)) {
            test.pass("Expected Status Code#" + statusCode + " | Actual Status Code#" + world.get("statusCode"));
        }else{
            test.fail("Expected Status Code#" + statusCode + ",Actual Status Code#" + world.get("statusCode"));
            test.info(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
            Assert.assertTrue(world.get("statusCode").equalsIgnoreCase(statusCode));
        }
    }

    @And("pause {string}")
    public void pause(String time) throws InterruptedException {
        Thread.sleep(Integer.valueOf(time));
    }


}