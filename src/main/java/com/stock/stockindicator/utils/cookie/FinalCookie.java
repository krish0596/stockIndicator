package com.stock.stockindicator.utils.cookie;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;
import com.stock.stockindicator.utils.cookieDef.FirstCookie;
import com.stock.stockindicator.utils.BaseCookie;

import java.util.List;

@Component
public class FinalCookie {
    FirstCookie firstCookie;

    public FinalCookie(FirstCookie firstCookie) {
        this.firstCookie = firstCookie;
    }

    public String returnFinalCookie() {
        BaseCookie baseCookie = new BaseCookie();
        List<String> first = firstCookie.returnCookie();
        for (String cookie : first) {
            cookie=cookie.substring(0,cookie.indexOf(";"));

            if (cookie.startsWith("ak_bmsc")) {
                baseCookie.setAk_bmsc(cookie);
            }
            if (cookie.startsWith("bm_mi")) {
                baseCookie.setBm_mi(cookie);
            }
        }
        return baseCookie.toString();
    }
}
