package portifolio.eltonlira.rummye2e.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProportiesConfig {

    @Value("${backend.url}")
    private String backendUrl;

    public String getBackendUrl() {
        return backendUrl;
    }
}
