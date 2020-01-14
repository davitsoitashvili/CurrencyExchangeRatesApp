package com.example.currencyexchangerates;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static ApiHolder apiHolder = null;
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://currencyratesapi.herokuapp.com/";


    public static ApiHolder getApiHolder() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        apiHolder = retrofit.create(ApiHolder.class);
        return apiHolder;
    }
}