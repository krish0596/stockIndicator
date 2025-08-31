package com.stock.stockindicator.service;
import com.stock.stockindicator.utils.cookie.GenerateNewCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NseService {

    private final WebClient client;
    private final GenerateNewCookie generateNewCookie;

    //here we can see the Bean of webclient builder getting injected via constructor injection
    public NseService(WebClient.Builder webClientBuilder, GenerateNewCookie generateNewCookie) {
        this.client = webClientBuilder.baseUrl("https://www.nseindia.com").build();
        this.generateNewCookie = generateNewCookie;
    }

    public String getChartData(String symbol) {
        ResponseEntity<String> response = client.get()
                .uri("/api/chart-databyindex-dynamic?index={symbol}EQN&type=symbol", symbol)
                .header("cookie", generateNewCookie.returnNewCookie())
                .header("referer", "https://www.nseindia.com/get-quotes/equity?symbol={symbol}", symbol)
                .retrieve()
                .toEntity(String.class)
                //.exchangeToMono(res -> res.toEntity(String.class))
                .block();  // blocking call
        return response.getBody();
    }
}
