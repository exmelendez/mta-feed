package com.example.android.mta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<LineStatus> lineStatuses;

        try {
            RecyclerView recyclerView = findViewById(R.id.rvItems);

            XMLPullParserHandler parser = new XMLPullParserHandler();
            lineStatuses = parser.parse(getAssets().open("train_service.xml"));

            AdapterTwo adapter = new AdapterTwo(this, lineStatuses);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (IOException e) {
            e.printStackTrace();
        }

        getLineStatus();

    }

    private void getLineStatus() {

        System.out.println("Welcome to Retrofit - XML Converter");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000")
                .addConverterFactory(TikXmlConverterFactory.create())
                .build();

        MtaStatusService mtaService = retrofit.create(MtaStatusService.class);

        Call<LineStatus> call = mtaService.getMtaStatus();

        call.enqueue(new Callback<LineStatus>() {
            @Override
            public void onResponse(Call<LineStatus> call, Response<LineStatus> response) {

            }

            @Override
            public void onFailure(Call<LineStatus> call, Throwable t) {
                t.printStackTrace();
            }
        });

        try {
            Response<LineStatus> response = mtaService.getMtaStatus().execute();
            LineStatus lineStatus = response.body();
            System.out.println("Request done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}