package portifolio.eltonlira.rummye2e.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestConfig {

    private ProportiesConfig proportiesConfig;

    public RestConfig(ProportiesConfig proportiesConfig) {
        this.proportiesConfig = proportiesConfig;
    }

    public RequestSpecification givenBackend(){
        return RestAssured.given()
                .baseUri(proportiesConfig.getBackendUrl())
                .filters(List.of(new RequestLoggingFilter(), new ResponseLoggingFilter()));
    }
}
