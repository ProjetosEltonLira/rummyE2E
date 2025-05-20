package portifolio.eltonlira.rummye2e.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import portifolio.eltonlira.rummye2e.config.ScenarioContext;

import java.util.List;

public class SiteStepsTest {

    private ScenarioContext scenarioContext;

    public SiteStepsTest(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }


    @Given("Eu quero acessar {string}")
    public void EuQueroAcessar(String url){

        scenarioContext.put("url",url);
        System.out.println("Acessar o site - " + url);
    }
    

    @When("Eu acessar esse site")
    public void euAcessarEsseSite() {
        var url = scenarioContext.get("url", String.class);
        var response = RestAssured.given()
                .filters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .baseUri(url)
                .get();

        scenarioContext.put("response", response);
    }
    

    @Then("o site esta corregado correto.")
    public void oSiteEstaCorregadoCorreto() {
        var response = scenarioContext.get("response", Response.class);

        response.then().statusCode(200);
    }
}
