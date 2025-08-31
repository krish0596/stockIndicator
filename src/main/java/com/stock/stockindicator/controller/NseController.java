package com.stock.stockindicator.controller;

import com.stock.stockindicator.Service.NseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NseController {

    private final NseService nseService;

    public NseController(NseService nseService) {
        this.nseService = nseService;
    }

    @GetMapping("/chart")
    public String getChart() {
        return nseService.getChartData();
    }
}
