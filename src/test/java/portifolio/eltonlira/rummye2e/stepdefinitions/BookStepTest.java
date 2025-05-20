package portifolio.eltonlira.rummye2e.stepdefinitions;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import portifolio.eltonlira.rummye2e.config.RestConfig;
import portifolio.eltonlira.rummye2e.config.ScenarioContext;
import portifolio.eltonlira.rummye2e.dto.BookingRequest;

import java.time.LocalDateTime;

public class BookStepTest {

    private final ScenarioContext scenarioContext;
    private final RestConfig rest;

    public BookStepTest(ScenarioContext scenarioContext, RestConfig rest) {
        this.scenarioContext = scenarioContext;
        this.rest = rest;
    }

    @E("a sala esta disponível para reserva hoje")
    public void aSalaEstaDisponívelParaReservaHoje() {

        var roomId = scenarioContext.get("roomId", Integer.class);

        rest.givenBackend()
                .queryParam("room_id", roomId)
                .delete("/test-utils/bookings")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value());

    }

    @E("um usuario reservou a sala por uma hora apartir de agora")
    @Quando("eu reservar para uma hora apartir de agora")
    public void euReservarParaUmaHoraApartirDeAgora() {

        var roomId = scenarioContext.get("roomId", Integer.class);
        var startTime = LocalDateTime.now().plusHours(1);
        var endTime = startTime.plusHours(1);

        var request = new BookingRequest(roomId,startTime,endTime);

        var response = rest.givenBackend()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .post("/bookings");

        scenarioContext.put("response",response);
    }

    @Então("a sala deve ser reservada com sucesso")
    public void aSalaDeveSerReservadaComSucesso() {

        var response = scenarioContext.get("response", Response.class);
        response.then().statusCode(HttpStatus.OK.value());

    }

    @Então("a reserva deve dar um conflito")
    public void aReservaDeveDarUmConflito() {

        var response = scenarioContext.get("response", Response.class);
        response.then().statusCode(HttpStatus.CONFLICT.value());

    }
}
