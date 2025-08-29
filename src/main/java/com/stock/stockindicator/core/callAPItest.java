package com.stock.stockindicator.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class callAPItest {
    @GetMapping(path = "/product")
    public String callAPItest(){
        return "Hello World";
    }
}
