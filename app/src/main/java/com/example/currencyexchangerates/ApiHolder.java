package com.example.currencyexchangerates;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiHolder {
    @GET("/?format=json")
    Call<List<CurrencyModel>> getCurrency();

    @GET("banknames/")
    Call<List<BankModel>> getBankNames();
}
