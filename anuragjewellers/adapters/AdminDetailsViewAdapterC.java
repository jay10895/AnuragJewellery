package com.example.anuragjewellers.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anuragjewellers.model.SalesData;
import com.example.anuragjewellery.R;


import java.util.ArrayList;

public class AdminDetailsViewAdapterC extends RecyclerView.Adapter<AdminDetailsViewAdapterC.ViewHolderC>  {

    Context context;
    ArrayList<SalesData> salesDataCr;
    String displayDummyDate;



    public AdminDetailsViewAdapterC(Context context,String date, ArrayList<SalesData> salesDataCr){
        this.context = context;
        this.displayDummyDate =date;
        this.salesDataCr = salesDataCr;

    }

    @NonNull
    @Override
    public ViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.vepari_receive_list_items,parent, false);

        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderC holder, final int position) {

        holder.receiveDate.setText(displayDummyDate);
        holder.itemDescription.setText(salesDataCr.get(position).getTitle());

        holder.itemWeight.setText("Weight : " + salesDataCr.get(position).getWeight());
        holder.itemTouch.setText("Touch : " + salesDataCr.get(position).getTouch());
        holder.itemFineWeight.setText("Fine : " + salesDataCr.get(position).getFine());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {

        return salesDataCr.size();
    }

    class ViewHolderC extends RecyclerView.ViewHolder{

        TextView receiveDate,itemDescription,itemWeight,itemTouch,itemFineWeight;

        public ViewHolderC(@NonNull View itemView) {
            super(itemView);
            receiveDate= itemView.findViewById(R.id.receiveDate);
           // receiveDate = itemView.findViewById(R.id.receiveDate);
            itemDescription = itemView.findViewById(R.id.itemDescription);

            itemWeight = itemView.findViewById(R.id.itemWeight);
            itemTouch = itemView.findViewById(R.id.itemTouch);
            itemFineWeight = itemView.findViewById(R.id.itemFineWeight);
        }
    }


}