package com.example.android.mta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;

import com.example.android.mta.data.DataProvider;
import com.example.android.mta.model.TrainLine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<TrainLine> trainLineList = DataProvider.trainLineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Collections.sort(trainLineList, new Comparator<TrainLine>() {
            @Override
            public int compare(TrainLine o1, TrainLine o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Adapter adapter = new Adapter(this, trainLineList);

        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}