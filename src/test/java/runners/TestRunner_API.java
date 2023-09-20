package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import libraries.ConfigReader;
import org.testng.annotations.BeforeSuite;
import stepDefinations.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@CucumberOptions
        (features = "src/test/resources",
                plugin = {"pretty", "html:target/cucumber-html-report.html"
                        ,"html:target/cucumber_reports/cucumber_pretty.html"
                        ,"json:target/cucumber_reports/cucumberTestReport.json"
                },
                glue = {"stepDefinations"},
                tags="@REGRESSION")

public class TestRunner_API extends AbstractTestNGCucumberTests {
    static SimpleDateFormat format = null;
    static Calendar cal = null;
    String reportTime;
    public Object[][] data;

    static {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
    }

    @BeforeSuite
    public void setUp() throws IOException {
        setUpExtentReports();
    }

    private void setUpExtentReports() throws IOException {
        cal = Calendar.getInstance();
        format = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
        TestBase.reports = new ExtentReports();
        SimpleDateFormat formatt = new SimpleDateFormat("ddMMMyyyy_HH-mm");
        reportTime = formatt.format(cal.getTime());
        TestBase.reportName = System.getProperty("user.dir") + "/Reports/"+"Itunes_Search_API_Report.html";
        TestBase.htmlReporter = new ExtentHtmlReporter(new File(TestBase.reportName));
        TestBase.htmlReporter.loadXMLConfig(String.valueOf(new File(System.getProperty("user.dir") + "/src/test/resources/extent-config.xml")));
        TestBase.reports.setSystemInfo("Environment",   TestBase.env);
        TestBase.reports.setSystemInfo("Author", "Vijay");
        TestBase.reports.setSystemInfo("Executed By", System.getProperty("user.name"));
        TestBase.reports.setSystemInfo("Operating System", System.getProperty("os.name"));
        TestBase.reports.attachReporter( TestBase.htmlReporter);
    }

}