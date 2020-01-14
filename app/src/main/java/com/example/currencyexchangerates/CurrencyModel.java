package com.example.currencyexchangerates;

import com.google.gson.annotations.SerializedName;

public class CurrencyModel {
    @SerializedName("bank_name")
    private String bankName;
    @SerializedName("sell_USD")
    private String sellUSD;
    @SerializedName("buy_USD")
    private String buyUSD;
    @SerializedName("sell_EUR")
    private String sellEUR;
    @SerializedName("buy_EUR")
    private String buyEUR;

    public String getBankName() {
        return bankName;
    }

    public String getSellUSD() {
        return sellUSD;
    }

    public String getBuyUSD() {
        return buyUSD;
    }

    public String getSellEUR() {
        return sellEUR;
    }

    public String getBuyEUR() {
        return buyEUR;
    }
}
