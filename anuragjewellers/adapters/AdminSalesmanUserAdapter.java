package com.example.anuragjewellers.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anuragjewellers.admin.AdminSalesmanVepariListActivity;
import com.example.anuragjewellers.model.SalesManData;
import com.example.anuragjewellery.R;

import java.util.ArrayList;

public class AdminSalesmanUserAdapter extends RecyclerView.Adapter<AdminSalesmanUserAdapter.SalesmanViewHolder> implements Filterable {
    Context context;
    ArrayList<SalesManData> salesmanDetailsList;
    ArrayList<SalesManData> filtered_salesmanDetailsList;

    int count=1;

    public AdminSalesmanUserAdapter(Context context,ArrayList<SalesManData> salesmanDetailsList){
        this.context = context;
        this.salesmanDetailsList = salesmanDetailsList;
        this.filtered_salesmanDetailsList = salesmanDetailsList;
    }

    @NonNull
    @Override
    public SalesmanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_salesman_list,parent, false);

        return new SalesmanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalesmanViewHolder holder, final int position) {
        //   salesmanDetailsList.get(position).setID(count);
        // holder.srno.setText(String.valueOf(salesmanDetailsList.get(position).getID()));
        //  holder.srno.setText(String.valueOf(filtered_salesmanDetailsList.get(position).getID()));
        holder.srno.setText(String.valueOf(count));

        count++;
        // holder.salesmanName.setText(salesmanDetailsList.get(position).getName());
        holder.salesmanName.setText(filtered_salesmanDetailsList.get(position).getName());

        //holder.salesCredit.setText(salesmanDetailsList.get(position).getWeight());
        holder.salesCredit.setText(filtered_salesmanDetailsList.get(position).getCredit());
        holder.salesDebit.setText(filtered_salesmanDetailsList.get(position).getDebit());
        //holder.salesmanPayment.setText(salesmanDetailsList.get(position).getPayment());
        holder.salesmanPayment.setText(filtered_salesmanDetailsList.get(position).getPayment());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  context.startActivity(new Intent(context, AdminSalesmanVepariListActivity.class));
                //  Log.i("salesman id",filtered_salesmanDetailsList.get(position).getID());

                Intent intentVepariList = new Intent(context, AdminSalesmanVepariListActivity.class);
                intentVepariList.putExtra("salesmanid",String.valueOf(filtered_salesmanDetailsList.get(position).getID()));
                intentVepariList.putExtra("salesmanCredit",String.valueOf(filtered_salesmanDetailsList.get(position).getCredit()));
                intentVepariList.putExtra("salesmanDebit",String.valueOf(filtered_salesmanDetailsList.get(position).getDebit()));
                context.startActivity(intentVepariList);
            }
        });

    }

    @Override
    public int getItemCount() {

        //return salesmanDetailsList.size();
        return filtered_salesmanDetailsList.size();
    }

    class SalesmanViewHolder extends RecyclerView.ViewHolder{

        TextView srno,salesmanName,salesCredit,salesDebit,salesmanPayment;

        public SalesmanViewHolder(@NonNull View itemView) {
            super(itemView);
            srno = itemView.findViewById(R.id.salesman_sr_no);
            salesmanName = itemView.findViewById(R.id.salesman_owner);

            salesCredit = itemView.findViewById(R.id.salesman_weight);
            salesDebit = itemView.findViewById(R.id.salesman_touch);
            salesmanPayment = itemView.findViewById(R.id.salesman_payment);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {

                    filtered_salesmanDetailsList = salesmanDetailsList;

                } else {
                    // filtered_salesmanDetailsList.clear();

                    ArrayList<SalesManData> filteredList = new ArrayList<SalesManData>();
                    for (SalesManData row : salesmanDetailsList) {


                        //change this to filter according to your case
                        if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);

                        }
                    }

                    filtered_salesmanDetailsList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered_salesmanDetailsList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filtered_salesmanDetailsList = (ArrayList) filterResults.values;
                count=1;
                notifyDataSetChanged();

            }
        };

    }

}
