package com.stock.stockindicator.controller;

import com.stock.stockindicator.service.NseService;
import com.stock.stockindicator.utils.cookie.FinalCookie;
import com.stock.stockindicator.utils.cookieDef.FirstCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NseController {

    private final NseService nseService;
    private final FirstCookie firstCookie;
    private final FinalCookie finalCookie;

    public NseController(NseService nseService , FirstCookie firstCookie, FinalCookie finalCookie) {
        this.nseService = nseService;
        this.firstCookie = firstCookie;
        this.finalCookie = finalCookie;
    }

    @GetMapping("/chart")
    public String getChart() {
        return nseService.getChartData();
    }
    @GetMapping("/cookieslist")
    public String getCookiesList() {
        List<String> cooki = firstCookie.returnCookie();
        StringBuilder builder = new StringBuilder();
        for(String cooki1 : cooki){
            builder.append(cooki1 + "\n");
        }
        return builder.toString();
    }
    @GetMapping("/finalcookie")
    public String getFinalCookie() {
        return finalCookie.returnFinalCookie();
    }
}
