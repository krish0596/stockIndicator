package com.stock.stockindicator.controller.tests;

import com.stock.stockindicator.service.NseService;
import com.stock.stockindicator.utils.cookie.GenerateNewCookie;
import com.stock.stockindicator.utils.cookieDef.FirstCookie;
import com.stock.stockindicator.utils.cookieDef.SecondCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestFirstCookie {

    private final NseService nseService;
    private final FirstCookie firstCookie;
    private final GenerateNewCookie generateNewCookie;
    private final SecondCookie secondCookie;

    public TestFirstCookie(NseService nseService , FirstCookie firstCookie, GenerateNewCookie generateNewCookie, SecondCookie secondCookie) {
        this.nseService = nseService;
        this.firstCookie = firstCookie;
        this.generateNewCookie = generateNewCookie;
        this.secondCookie = secondCookie;
    }

    @GetMapping("/testchart/{symbol}")
    public String getChart(@PathVariable String symbol) {
        return nseService.getChartData(symbol);
    }
    @GetMapping("/testcookieslist")
    public String getCookiesList() {
        List<String> cooki = firstCookie.returnCookie();
        StringBuilder builder = new StringBuilder();
        for(String cooki1 : cooki){
            builder.append(cooki1 + "\n");
        }
        return builder.toString();
    }
    @GetMapping("/testfinalcookie")
    public String getFinalCookie() {
        return generateNewCookie.returnNewCookie();
    }
}
