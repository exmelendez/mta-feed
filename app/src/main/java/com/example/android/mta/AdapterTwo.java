package com.example.android.mta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterTwo extends RecyclerView.Adapter<AdapterTwo.ViewHolder> {

    private List<LineStatus> mLineStatus;
    private Context mContext;

    AdapterTwo(Context context, List<LineStatus> items) {
        this.mContext = context;
        this.mLineStatus = items;
    }

    @Override
    public AdapterTwo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_line_status, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterTwo.ViewHolder holder, int position) {
        LineStatus item = mLineStatus.get(position);

            holder.lineName.setText(item.getLine());
            holder.lineStatus.setText(item.getStatus());
            holder.lineDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return mLineStatus.size();
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