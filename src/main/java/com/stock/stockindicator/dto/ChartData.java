package com.stock.stockindicator.dto;

import java.util.List;

public class ChartData {
    private String identifier;
    private String name;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Object>> getGrapthData() {
        return grapthData;
    }

    public void setGrapthData(List<List<Object>> grapthData) {
        this.grapthData = grapthData;
    }

    private List<List<Object>> grapthData;

}
