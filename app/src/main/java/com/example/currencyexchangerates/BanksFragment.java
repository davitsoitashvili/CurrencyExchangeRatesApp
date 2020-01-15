package com.example.currencyexchangerates;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BanksFragment extends Fragment {
    private TextView SellUSD, BuyUSD, SellEUR, BuyEUR, ErrorMessage;
    private ImageView image;
    private int id;
    private String imageUrl;
    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_banks, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (this.getArguments() != null) {

            id = this.getArguments().getInt("ID");
            imageUrl = this.getArguments().getString("image");
        }

        setIDs();
        setItems();
        sendImageRequest();

    }

    public static BanksFragment newInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("ID",id);
        BanksFragment fragment = new BanksFragment();
        fragment.setArguments(bundle);
        return fragment;

    }

    private void setIDs() {
        View rootView = getView();
        SellUSD = rootView.findViewById(R.id.SellUSD);
        BuyUSD = rootView.findViewById(R.id.BuyUSD);
        SellEUR = rootView.findViewById(R.id.SellEUR);
        BuyEUR = rootView.findViewById(R.id.BuyEUR);
        ErrorMessage = rootView.findViewById(R.id.errorMessage);
        image = rootView.findViewById(R.id.bankImage);

    }

    private void setItems() {
        rootView = getView();
        Call<List<CurrencyModel>> call = RetrofitClient.getApiHolder().getCurrency();
        call.enqueue(new Callback<List<CurrencyModel>>() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<CurrencyModel>> call, Response<List<CurrencyModel>> response) {
                if (!response.isSuccessful()) {
                    ErrorMessage.setText(response.code());
                } else {
                    CurrencyModel currency = response.body().get(id);
                    SellUSD.setText("Sell USD: " + currency.getSellUSD());
                    BuyUSD.setText("Buy USD: " + currency.getBuyUSD());
                    SellEUR.setText("Sell EUR: " + currency.getSellEUR());
                    BuyEUR.setText("Buy EUR: " + currency.getBuyEUR());


                }
            }

            @Override
            public void onFailure(Call<List<CurrencyModel>> call, Throwable t) {
//                Toast.makeText(rootView.getContext(), "There is some error, try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void sendImageRequest() {

        Call<List<BankModel>> call = RetrofitClient.getApiHolder().getBankNames();

        call.enqueue(new Callback<List<BankModel>>() {
            @Override
            public void onResponse(Call<List<BankModel>> call, Response<List<BankModel>> response) {
                List<BankModel> bankModelList = response.body();

                for (int i = 0; i < bankModelList.size(); i ++) {
                    BankModel model = bankModelList.get(id);
                    Glide.with(rootView.getContext()).load(model.getImage()).into(image);


                }

            }

            @Override
            public void onFailure(Call<List<BankModel>> call, Throwable t) {
//                Toast.makeText(MainActivity.this,"There is some error, try again!",Toast.LENGTH_LONG).show();
            }

        });

    }

}
