package portifolio.eltonlira.rummye2e.stepdefinitions;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.springframework.http.MediaType;
import portifolio.eltonlira.rummye2e.config.RestConfig;
import portifolio.eltonlira.rummye2e.config.ScenarioContext;
import portifolio.eltonlira.rummye2e.dto.RoomDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomStepTest {

    private ScenarioContext scenarioContext;
    private RestConfig rest;

    public RoomStepTest(ScenarioContext scenarioContext, RestConfig rest) {
        this.scenarioContext = scenarioContext;
        this.rest = rest;
    }

    @Quando("pesquisar todas as salas")
    public void pesquisarTodasAsSalas() {
        var response = rest.givenBackend()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get("/rooms");

        scenarioContext.put("response", response);
    }

    @Então("encontro a sala {string}")
    public void encontroASalaNome(String nome) {
        var response = scenarioContext.get("response", Response.class);

        var rooms = response.then()
                .statusCode(200)
                .extract()
                .as(new TypeRef<List<RoomDto>>() {
                });

        assertTrue(rooms.stream()
                .anyMatch(r -> r.name().equalsIgnoreCase(nome)));
    }

}
