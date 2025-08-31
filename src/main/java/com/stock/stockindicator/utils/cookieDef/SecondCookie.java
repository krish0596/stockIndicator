package com.stock.stockindicator.utils.cookieDef;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecondCookie {
    WebClient webClient;
    FirstCookie firstCookie;

    public SecondCookie(WebClient.Builder webClientBuilder, FirstCookie firstCookie) {
        this.webClient = webClientBuilder.baseUrl("https://www.nseindia.com/").build();
        this.firstCookie = firstCookie;
    }

    public List<String> returnCookie(){
        StringBuilder attachcookies = new StringBuilder();
        List<String> fcookie = firstCookie.returnCookie();
        String ak_bmsc="EMPTY";
        for(String cookie: fcookie){
            cookie = cookie.substring(0,cookie.indexOf(";") + 1);
            if(cookie.startsWith("ak_bmsc")){
                ak_bmsc=cookie;
                attachcookies.append(cookie);
            }
            if(cookie.startsWith("bm_mi")){
                attachcookies.insert(0,cookie);
            }
        }
//        System.out.println(attachcookies.toString());
        Mono<List<String>> monoCookies = webClient.get()
                .uri("/market-data/equity-derivatives-watch")
                .header(HttpHeaders.COOKIE, attachcookies.toString())
                .retrieve()
                .toBodilessEntity()
                .map(entity -> entity.getHeaders().get(HttpHeaders.SET_COOKIE));
        List<String> addFirstCookie =  new ArrayList<>(monoCookies.block());
        addFirstCookie.add(ak_bmsc);
        return addFirstCookie;
    }

}
