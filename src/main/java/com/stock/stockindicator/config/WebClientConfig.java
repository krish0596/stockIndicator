package com.stock.stockindicator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Linux; Android 11; Pixel Build/RQ1A.210105.003; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.120 Mobile Safari/537.36")
                .defaultHeader(HttpHeaders.ACCEPT, "application/json, */*; q=0.01")
                .defaultHeader("x-requested-with", "XMLHttpRequest")
                .defaultHeader("sec-fetch-site", "same-origin")
                .defaultHeader("sec-fetch-mode", "cors")
                .defaultHeader("sec-fetch-dest", "empty")
                .defaultHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate")
                .defaultHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.9");
    }
}
