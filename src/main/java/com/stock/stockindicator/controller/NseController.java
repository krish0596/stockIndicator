package com.stock.stockindicator.controller;

import com.stock.stockindicator.service.NseService;
import com.stock.stockindicator.utils.cookie.GenerateNewCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NseController {

    private final NseService nseService;
    private final GenerateNewCookie generateNewCookie;

    public NseController(NseService nseService, GenerateNewCookie generateNewCookie) {
        this.nseService = nseService;
        this.generateNewCookie = generateNewCookie;
    }

    @GetMapping("/chart/{symbol}")
    public String getChart(@PathVariable String symbol) {
        return nseService.getChartData(symbol);
    }

    @GetMapping("/finalcookie")
    public String getFinalCookie() {
        return generateNewCookie.returnNewCookie();
    }

}
