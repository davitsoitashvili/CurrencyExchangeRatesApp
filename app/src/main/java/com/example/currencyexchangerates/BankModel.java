package com.example.currencyexchangerates;

import com.google.gson.annotations.SerializedName;

public class BankModel {
    @SerializedName("bank_name")
    private String bankName;
    @SerializedName("image_url")
    private String image;

    public String getBankName() {
        return bankName;
    }

    public String getImage() {
        return image;
    }
}
