package dev.lydtech.component;

import dev.lydtech.component.framework.client.service.ServiceClient;
import dev.lydtech.component.framework.client.wiremock.RequestCriteria;
import dev.lydtech.component.framework.client.wiremock.WiremockClient;
import dev.lydtech.component.framework.extension.ComponentTestExtension;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.restassured.RestAssured.put;

@Slf4j
@ExtendWith(ComponentTestExtension.class)
public class CallThirdPartyApiCT {

    private String serviceBaseUrl;

    @BeforeEach
    public void setup() {
        WiremockClient.getInstance().deleteAllRequestsMappings();

        serviceBaseUrl = ServiceClient.getInstance().getBaseUrl();
        RestAssured.baseURI = serviceBaseUrl;
    }

    /**
     */
    @Test
    public void testThirdPartyEndpointIsCalled() {

        Response response = put("/users/1/mood/HAPPY");
        log.info("Response: {}", response.getStatusCode());

        RequestCriteria request = RequestCriteria.builder()
                .method("GET")
                .url("/api/thirdparty/HAPPY")
                .build();
        WiremockClient.getInstance().countMatchingRequests(request, 1);
    }
}
