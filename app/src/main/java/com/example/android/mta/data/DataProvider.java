package com.example.android.mta.data;

import com.example.android.mta.model.TrainLine;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<TrainLine> trainLineList;

    static {
        trainLineList = new ArrayList<>();

        addItem(new TrainLine("123", "PLANNED WORK", "TEXT", 1525816200000L));
        addItem(new TrainLine("JZ", "GOOD SERVICE", "TEXT", 1525816200000L));
        addItem(new TrainLine("G", "DELAYED", "TEXT", 1525816200000L));
        addItem(new TrainLine("L", "PLANNED WORK", "TEXT", 1525816200000L));
        addItem(new TrainLine("456", "PLANNED WORK", "TEXT", 1525816200000L));
        addItem(new TrainLine("7", "GOOD SERVICE", "TEXT", 1525816200000L));
        addItem(new TrainLine("ACE", "PLANNED WORK", "TEXT", 1525816200000L));
        addItem(new TrainLine("BDFM", "DELAYED", "TEXT", 1525816200000L));

    }

    private static void addItem(TrainLine trainLine) {
        trainLineList.add(trainLine);
    }

}