package com.stock.stockindicator.utils;

public class BaseCookie {
    private String nsit;
    private String nseappid;
    private String bm_mi;
    private String ak_bmsc;

    public String getNsit() {
        return nsit;
    }

    public void setNsit(String nsit) {
        this.nsit = nsit;
    }

    public String getNseappid() {
        return nseappid;
    }

    public void setNseappid(String nseappid) {
        this.nseappid = nseappid;
    }

    public String getBm_mi() {
        return bm_mi;
    }

    public void setBm_mi(String bm_mi) {
        this.bm_mi = bm_mi;
    }

    public String getAk_bmsc() {
        return ak_bmsc;
    }

    public void setAk_bmsc(String ak_bmsc) {
        this.ak_bmsc = ak_bmsc;
    }

    @Override
    public String toString() {
        return  nsit + ";" + nseappid + ";" + bm_mi + ";" + ak_bmsc + ";";
    }
}
