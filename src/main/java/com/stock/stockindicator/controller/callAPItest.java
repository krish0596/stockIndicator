package com.stock.stockindicator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class callAPItest {
    @GetMapping(path = "/testapi")
    public String callAPItest(){
        return "Hello World";
    }
}
