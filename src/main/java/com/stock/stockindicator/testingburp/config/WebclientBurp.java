package com.stock.stockindicator.testingburp.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientBurp {

    @Bean
    public WebClient.Builder webClientBuilderBurpTesting() {
        return WebClient.builder().baseUrl("https://www.bsefcl.bihar.gov.in");
    }
}
