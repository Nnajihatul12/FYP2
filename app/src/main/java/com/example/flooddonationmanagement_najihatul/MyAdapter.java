package com.example.flooddonationmanagement_najihatul;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<FloodVictimModel> data;

    public MyAdapter() {
        data = new ArrayList<>();
    }

    public void setData(List<FloodVictimModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.floodvictim_item_ly, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FloodVictimModel item = data.get(position);
        holder.textViewName.setText(item.getFullName());
        holder.textViewNGO.setText(item.getNgo());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,textViewNGO;

        MyViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name_tv);
            textViewNGO = itemView.findViewById(R.id.ngo_tv);

        }
    }
}