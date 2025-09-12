package com.stock.stockindicator.indicators;

import com.stock.stockindicator.dto.StockData;

import java.util.List;

public interface Indicator {
    List<Double> calculate(List<StockData> data, int period);
}
