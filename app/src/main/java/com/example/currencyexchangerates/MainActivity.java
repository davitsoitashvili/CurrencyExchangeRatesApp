package com.example.currencyexchangerates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button vtbBtn, tbcBtn, procreditBtn, georgianBtn;
    FragmentTransaction transaction;
    FragmentManager fragmentManager = getSupportFragmentManager();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        setIDs();
        buttons();

    }

    private void setIDs() {
        vtbBtn = findViewById(R.id.vtbbankbtn);
        tbcBtn = findViewById(R.id.tbcbankbtn);
        procreditBtn = findViewById(R.id.procreditbankbtn);
        georgianBtn = findViewById(R.id.bankofGeorgianbtn);
    }

    private void buttons() {
        clickBtn(vtbBtn);
        clickBtn(tbcBtn);
        clickBtn(procreditBtn);
        clickBtn(georgianBtn);
    }

    private void fragmentInstance(int id) {
        Fragment fragment = BanksFragment.newInstance(id);
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    private void clickBtn(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button == vtbBtn) {
                    fragmentInstance(0);

                } else if (button == tbcBtn) {
                    fragmentInstance(1);
                } else if (button == procreditBtn) {
                    fragmentInstance(2);
                } else if (button == georgianBtn) {
                    fragmentInstance(3);
                } else {
                    Toast.makeText(MainActivity.this, "Click correct buttons",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}





