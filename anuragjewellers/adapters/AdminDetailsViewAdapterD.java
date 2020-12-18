package com.example.anuragjewellers.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anuragjewellers.model.SalesData;
import com.example.anuragjewellery.R;

import java.util.ArrayList;

public class AdminDetailsViewAdapterD extends RecyclerView.Adapter<AdminDetailsViewAdapterD.ViewHolderD> {

    Context context;
    ArrayList<SalesData> salesDataDr;

    String displayDummyDate;



    public AdminDetailsViewAdapterD(Context context,String date,    ArrayList<SalesData> salesDataDr){
        this.context = context;
        this.displayDummyDate =date;
        this.salesDataDr = salesDataDr;
    }

    @NonNull
    @Override
    public ViewHolderD onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vepari_sent_list_items,parent, false);

        return new ViewHolderD(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderD holder, final int position) {

        holder.sentDate.setText(displayDummyDate);
        holder.itemDescription.setText(salesDataDr.get(position).getTitle());

        holder.itemWeight.setText("Weight : " + salesDataDr.get(position).getWeight());
        holder.itemTouch.setText("Touch : " + salesDataDr.get(position).getTouch());
        holder.itemFineWeight.setText("Fine : "+ salesDataDr.get(position).getFine());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {

        return salesDataDr.size();
    }

    class ViewHolderD extends RecyclerView.ViewHolder{

        TextView sentDate,itemDescription,itemWeight,itemTouch,itemFineWeight;

        public ViewHolderD(@NonNull View itemView) {
            super(itemView);
            sentDate = itemView.findViewById(R.id.sentDate);
            itemDescription = itemView.findViewById(R.id.itemDescription);

            itemWeight = itemView.findViewById(R.id.itemWeight);
            itemTouch = itemView.findViewById(R.id.itemTouch);
            itemFineWeight = itemView.findViewById(R.id.itemFineWeight);
        }
    }

}
