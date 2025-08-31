package com.stock.stockindicator.utils.cookieDef;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/////////////////////////////////////////////////////////////////////
////  The aim is to hit the nseindia.com host and fetch cookies  ////
////  nsit                                                       ////
////  ak_bmsc                                                    ////
////  bm_mi                                                      ////
////  nseappid                                                   ////
////  and return those cookies in a single string                ////
/////////////////////////////////////////////////////////////////////

@Component
public class FirstCookie {

    WebClient client;

    public FirstCookie(WebClient.Builder webClientBuilder) {
        this.client = webClientBuilder.baseUrl("https://www.nseindia.com").build();
    }

    public List<String> returnCookie(){
        //it should send a Http request to the nse india
        //see the cookies it set and fetch those cookies
        //construct string
        //send it back
        Mono<List<String>> monoCookies = client.get()
                .uri("/")
                .retrieve()
                .toBodilessEntity()
                .map(entity -> entity.getHeaders().get(HttpHeaders.SET_COOKIE));
        return monoCookies.block();
    }
}
