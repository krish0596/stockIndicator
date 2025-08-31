package com.stock.stockindicator.service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NseService {

    private final WebClient.Builder webClientBuilder;

    //here we can see the Bean of webclient builder getting injected via constructor injection
    public NseService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getChartData() {
        WebClient client = webClientBuilder.baseUrl("https://www.nseindia.com").build();

        ResponseEntity<String> response = client.get()
                .uri("/api/chart-databyindex-dynamic?index=MRFEQN&type=symbol")
                .header("cookie", "nsit=6Ck6KX9SB6jbUb-YE0kWVJuZ;bm_mi=39A32C672092C58834F9E30E709B50B2~YAAQhNcLF/CNFfKYAQAAnYQ6/xxnJrhdBp50ZGbraVv04DvCMCRhRjlNyLXRu66Qr22ycbwco2QIjOWQO6g14ikbEBpSZTI6ib47/ducEedKknnP6INAXho1cE/VAt3L5Ab2xvjgfn8ffD5xUGcWtmyJKnVC+yzdN4I1OlcNPwirvxfgeECsZwN5+iab3reP+Ga+1tVtTDHWbDQKe5Nywz2WSmHhoJIIa9iZV/edi7jGHBODJdGevarfPLTuUBeiRk+tBe0vxMzkxa9jwEQJFXXBebQuWHEwGo6E2HeJZ8ksuTsuD16cFw/EqzYRCtG3jMP6M58TVHNJ9c5kvQLzbYM=~1;ak_bmsc=7F41D5E584BA80A64DE7D0886888FD5C~000000000000000000000000000000~YAAQhNcLF9iNFfKYAQAAkYM6/xxqgz6BdVuY75rHmMqkouekpInCf9WgDnrovVM56m67RuHsn/A+BBrXI2LYD4Pv91PoHx2GYlXwFItMdsyjiP9bERFyK8WVDtS6ygjFWn0f2r6FaZuRoEroD61VHkIPkssm+zwgfAksWVAW77n9/SngHfQg4RuuPbHf3IyiJ3SPS+VYhsjGHb7sIV9HsNn7Za7g6qxxk9tuqAhdpCbT1wKGVHG58LwgC7STsgs57pZ4gL3xf8FewUxNKTRv2jyEpYJSrlRYDeniVT6tY74kLSYppD/p68F1A4XIvqhJI2MZrB2ElPxF2EdvNuQUwxQewsrMiEYj2AZ8FtpyJf4YZR0gCyMKlMElbiCVx2mThYR4DJsp6j4jrz2CiIQ=;nseappid=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhcGkubnNlIiwiYXVkIjoiYXBpLm5zZSIsImlhdCI6MTc1NjYyODY4MiwiZXhwIjoxNzU2NjM1ODgyfQ.ngwSCtBcpZWEZifBuhdMZo6ytvHEJSi8eQXE5pXN_Zk;")
                .header("referer", "https://www.nseindia.com/get-quotes/equity?symbol=ITC")
                .retrieve()
                .toEntity(String.class)
                //.exchangeToMono(res -> res.toEntity(String.class))
                .block();  // blocking call
        return response.getBody();
    }
}
