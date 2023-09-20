package stepDefinations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import libraries.APIEndPoints;
import libraries.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestBase {
    public ResponseSpecification resSpec;
    public QueryableRequestSpecification queryRequest;
    public static Map<String, String> world = new HashMap<>();
    public static String sendmail;
    public static String recipients;
    public RequestSpecification req;
    public static Response response;
    public static String env;
    public Logger logger = LogManager.getLogger(TestBase.class);
    public static ExtentReports reports;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
    public static String reportName = null;
    protected APIEndPoints resAPI;
    public Gson gson = new Gson();
    public Faker faker=new Faker();

      public RequestSpecification requestSpecificationAPI() throws IOException {
        RestAssured.baseURI = ConfigReader.getConfigValue("API_BASE_URL");
        req = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .build();
        queryRequest= SpecificationQuerier.query(req);
        return req;
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        logger.info("json key: " + key + " | json value: " + js.get(key).toString());
        return js.get(key).toString();
    }

    public String getJsonArrayPath(Response response, String key, int index) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        logger.info("json key: " + key + " | json value: " + js.getList(key).get(index).toString());
        return js.getList(key).get(index).toString();
    }

    public String convertToJson(String req) {
        Gson gson = new Gson();
        String json = gson.toJson(req);
        test.info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
        return json;
    }

    public void recordSuccessInReportAndLog(String successMsg) {
        test.pass(successMsg);
        logger.info(successMsg);
    }

    public void recordFailureInReportAndLog(String failureMsg) {
        test.fail(failureMsg);
        logger.error(failureMsg);
    }

    protected void reportPass(String passTxt) {
        test.pass(passTxt);
    }

    protected void reportFail(String failTxt) {

        test.fail(failTxt);
        Assert.fail(failTxt);
    }


}