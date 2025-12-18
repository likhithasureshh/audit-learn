package com.production_ready_features.production_ready_features.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value("${Employee.base.url}")
    private String BASE_URL;
    @Bean
    @Qualifier("getEmployeeRestClient")
    RestClient getEmployeeRestClient()
    {
        RestClient restClient=RestClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(req,res)->{
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw new RuntimeException("Serval error");
                })
                .build();
        return restClient;
    }
}
