package com.example.android.mta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mta.model.TrainLine;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<TrainLine> mTrains;
    private Context mContext;

    Adapter(Context context, List<TrainLine> items) {
        this.mContext = context;
        this.mTrains = items;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_line_status, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        TrainLine item = mTrains.get(position);

            holder.lineName.setText(item.getName());
            holder.lineStatus.setText(item.getStatus());
            holder.lineDate.setText(item.getFormattedDateTime("dd/MM/yy hh:mm a"));
    }

    @Override
    public int getItemCount() {
        return mTrains.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView lineName;
        TextView lineStatus;
        TextView lineDate;
        ViewHolder(View itemView) {
            super(itemView);

            lineName = itemView.findViewById(R.id.lineText);
            lineStatus = itemView.findViewById(R.id.statusText);
            lineDate = itemView.findViewById(R.id.dateText);
        }
    }
}