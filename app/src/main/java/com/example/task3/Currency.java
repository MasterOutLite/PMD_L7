package com.example.task3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {
    @SerializedName("currencyCodeA")
    @Expose
    private Integer currencyCodeA;
    @SerializedName("currencyCodeB")
    @Expose
    private Integer currencyCodeB;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("rateBuy")
    @Expose
    private Double rateBuy;
    @SerializedName("rateCross")
    @Expose
    private Double rateCross;
    @SerializedName("rateSell")
    @Expose
    private Double rateSell;

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(Double rateBuy) {
        this.rateBuy = rateBuy;
    }

    public Double getRateCross() {
        return rateCross;
    }

    public void setRateCross(Double rateCross) {
        this.rateCross = rateCross;
    }

    public Double getRateSell() {
        return rateSell;
    }

    public void setRateSell(Double rateSell) {
        this.rateSell = rateSell;
    }
}
