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

    public String getChartData() {
        String cookie1 = generateNewCookie.returnFinalCookie();
        ResponseEntity<String> response = client.get()
                .uri("/api/chart-databyindex-dynamic?index=MRFEQN&type=symbol")
                .header("cookie", cookie1)
                .header("referer", "https://www.nseindia.com/get-quotes/equity?symbol=ITC")
                .retrieve()
                .toEntity(String.class)
                //.exchangeToMono(res -> res.toEntity(String.class))
                .block();  // blocking call
        return response.getBody();
    }
}
