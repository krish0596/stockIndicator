package com.stock.stockindicator.controller;

import com.stock.stockindicator.service.NseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NseController {

    private final NseService nseService;

    public NseController(NseService nseService) {
        this.nseService = nseService;
    }

    @GetMapping("/chart")
    public String getChart() {
        return "enter the stock ticker in the field";
    }

    @GetMapping("/chart/{symbol}")
    public String getChart(@PathVariable String symbol) {
        return nseService.getChartData(symbol);
    }
}
