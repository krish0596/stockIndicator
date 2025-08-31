package com.stock.stockindicator.controller;

import com.stock.stockindicator.service.NseService;
import com.stock.stockindicator.utils.cookie.GenerateNewCookie;
import com.stock.stockindicator.utils.cookieDef.FirstCookie;
import com.stock.stockindicator.utils.cookieDef.SecondCookie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NseController {

    private final NseService nseService;
    private final GenerateNewCookie generateNewCookie;

    public NseController(NseService nseService, GenerateNewCookie generateNewCookie) {
        this.nseService = nseService;
        this.generateNewCookie = generateNewCookie;
    }

    @GetMapping("/chart")
    public String getChart() {
        return nseService.getChartData();
    }

    @GetMapping("/finalcookie")
    public String getFinalCookie() {
        return generateNewCookie.returnFinalCookie();
    }

}
