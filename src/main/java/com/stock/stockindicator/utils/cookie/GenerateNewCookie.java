package com.stock.stockindicator.utils.cookie;

import com.stock.stockindicator.utils.cookieDef.SecondCookie;
import org.springframework.stereotype.Component;
import com.stock.stockindicator.utils.BaseCookie;

import java.util.List;

@Component
public class GenerateNewCookie {
    SecondCookie secondCookie;

    public GenerateNewCookie(SecondCookie secondCookie) {
        this.secondCookie = secondCookie;
    }

    public String returnFinalCookie() {
        BaseCookie baseCookie = new BaseCookie();
        List<String> first = secondCookie.returnCookie();

        for (String cookie : first) {
            cookie=cookie.substring(0,cookie.indexOf(";"));
            if (cookie.startsWith("nsit")){
                baseCookie.setNsit(cookie);
            }
            if (cookie.startsWith("ak_bmsc")) {
                baseCookie.setAk_bmsc(cookie);
            }
            if (cookie.startsWith("bm_mi")) {
                baseCookie.setBm_mi(cookie);
            }
            if (cookie.startsWith("nseappid")) {
                baseCookie.setNseappid(cookie);
            }
        }
        return baseCookie.toString();
    }
}
