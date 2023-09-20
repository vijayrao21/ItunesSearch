package stepDefinations.API;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import libraries.APIEndPoints;
import stepDefinations.TestBase;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ItunesSearchStepDef extends TestBase {


    @When("User search itunes with term {string}")
    public void userSearchItunesWithTerm(String term) {
        try {
            resAPI = APIEndPoints.valueOf("SearchItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("term", term)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }


    @When("User search itunes with term {string} and limit {string}")
    public void userSearchItunesWithTermAndLimit(String term, String limit) {
        try {
            resAPI = APIEndPoints.valueOf("SearchItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("term", term)
                    .param("limit", limit)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with term {string} and entity {string}")
    public void userSearchItunesWithTermAndEntity(String term, String entity) {
        try {
            resAPI = APIEndPoints.valueOf("SearchItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("term", term)
                    .param("entity", entity)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with term {string} and country {string}")
    public void userSearchItunesWithTermAndCountry(String term, String country) {
        try {
            resAPI = APIEndPoints.valueOf("SearchItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("term", term)
                    .param("country", country)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with term {string} entity {string} and country {string}")
    public void userSearchItunesWithTermEntityAndCountry(String term, String entity, String country) {
        try {
            resAPI = APIEndPoints.valueOf("SearchItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("term", term)
                    .param("entity", entity)
                    .param("country", country)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with artist ID {string}")
    public void userSearchItunesWithArtistID(String id) {
        try {
            resAPI = APIEndPoints.valueOf("LookupItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("id", id)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with itunes ID {string}")
    public void userSearchItunesWithItunesID(String itunesid) {
        try {
            resAPI = APIEndPoints.valueOf("LookupItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("id", itunesid)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }

    @When("User search itunes with amg ID {string}")
    public void userSearchItunesWithAmgID(String amgid) {
        try {
            resAPI = APIEndPoints.valueOf("LookupItunesAPI");
            resSpec = new ResponseSpecBuilder().build();
            response = given()
                    .param("amgArtistId", amgid)
                    .log().all().spec(requestSpecificationAPI())
                    .when().get(resAPI.getResource())
                    .then().log().all().spec(resSpec).extract().response();
            test.info(("GET request: "+RestAssured.baseURI+resAPI.getResource()));
            world.put("statusCode", "" + response.statusCode());
            test.info("ResultCount: "+response.jsonPath().get("resultCount").toString());
            test.info(("Response: "+response.jsonPath()));
        } catch (IllegalArgumentException | IOException e) {
            test.fail(e.toString());
        }
    }
}