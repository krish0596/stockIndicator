package com.stock.stockindicator.testingburp.bsefcl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;


@Service
public class FetchUsers {

    private final WebClient webClient;

    public FetchUsers(@Qualifier("webClientBuilderBurpTesting") WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public JsonNode fetchUserById(int id) {
        return webClient.get()
                .uri("/api///{id}", id)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .retryWhen(
                        Retry.fixedDelay(5, Duration.ofSeconds(1))
                                .doAfterRetry(retrySrr -> {
                                    System.out.println("Retry triggerer Attempt#" + (retrySrr.totalRetries() + 1) +
                                            "Failure " + retrySrr.failure().getMessage());
                                }))
                .block();
    }
}
