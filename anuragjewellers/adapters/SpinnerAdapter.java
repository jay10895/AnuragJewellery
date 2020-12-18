package com.example.anuragjewellers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anuragjewellers.model.For_AddVepari;
import com.example.anuragjewellery.R;

import java.util.ArrayList;

public class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.SpinnerViewHolder> {

    Context context;
    ArrayList<For_AddVepari> for_addVeparis;

    public SpinnerAdapter(Context context, ArrayList<For_AddVepari> for_addVeparis){
        this.context = context;
        this.for_addVeparis = for_addVeparis;
    }

    @NonNull
    @Override
    public SpinnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.spinner_name,parent, false);
        return new SpinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpinnerViewHolder holder, int position) {
        holder.textview.setText(for_addVeparis.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return for_addVeparis.size();
    }

    class SpinnerViewHolder extends RecyclerView.ViewHolder{
        TextView textview;
        public SpinnerViewHolder(@NonNull View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.textview);
        }
    }
}
