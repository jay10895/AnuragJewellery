package com.example.anuragjewellers.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anuragjewellers.admin.AdminViewDetailsVepariActivity;
import com.example.anuragjewellers.network.GetDataService;
import com.example.anuragjewellers.network.RetrofitClientInstance;
import com.example.anuragjewellery.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminSalesmanVepariListAdapter extends RecyclerView.Adapter<AdminSalesmanVepariListAdapter.VepariListViewHolder> {

    Context context;
    //   ArrayList<SalesManData> salesmanDetailsList;
    //
    //   ArrayList<SalesManData> filtered_salesmanDetailsList;
    String[] vepari_names,vepari_ids;
    int count=1;

    public AdminSalesmanVepariListAdapter(Context context,String[] vepari_names,String[] vepari_ids){
        this.context = context;
        this.vepari_names = vepari_names;
        this.vepari_ids = vepari_ids;

        // this.filtered_salesmanDetailsList = salesmanDetailsList;
    }

    @NonNull
    @Override
    public AdminSalesmanVepariListAdapter.VepariListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_salesman_vepari_list,parent, false);

        return new VepariListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final @NonNull VepariListViewHolder holder, final int position) {

        holder.srno.setText(String.valueOf(count));

        count++;
        // holder.salesmanName.setText(salesmanDetailsList.get(position).getName());
        holder.vepariname.setText(vepari_names[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(context.getResources().getColor(android.R.color.white));

                // context.startActivity(new Intent(context, AdminViewDetailsVepariActivity.class));
                Intent intentSalesDataList = new Intent(context, AdminViewDetailsVepariActivity.class);
                intentSalesDataList.putExtra("vepariid",vepari_ids[position]);
                context.startActivity(intentSalesDataList);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                view.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
                holder.deleteBtn.setVisibility(View.VISIBLE);

                return true;
            }
        });


    }


    public void deleteVep(String dataid) {


        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ResponseBody> call = service.deletedataentry(dataid);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.isSuccessful()) {
                        ResponseBody responseBody = response.body();
                        String s = responseBody.string();
/*
                        JSONObject obj = new JSONObject(s);
                        JSONObject objData = obj.getJSONObject("data");*/


                        Toast.makeText(context,s,Toast.LENGTH_LONG).show();

                    }


                } /*catch (JSONException e) {
                    Log.i("Exception", e.getMessage());
                    e.printStackTrace();
                }*/ catch (IOException e) {
                    Log.i("Exception", e.getMessage());
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    @Override
    public int getItemCount() {
        //return salesmanDetailsList.size();
        return vepari_names.length;
    }

    class VepariListViewHolder extends RecyclerView.ViewHolder{
        TextView srno,vepariname,salesCredit,salesDebit,salesmanPayment;
        Button deleteBtn;

        public VepariListViewHolder(@NonNull View itemView) {
            super(itemView);
            srno = itemView.findViewById(R.id.salesman_vepari_srno);
            vepariname = itemView.findViewById(R.id.salesman_vepari_owner);
            deleteBtn = itemView.findViewById(R.id.salesman_vepari_delete_btn);

          /*  salesCredit = itemView.findViewById(R.id.salesman_weight);
            salesDebit = itemView.findViewById(R.id.salesman_touch);
            salesmanPayment = itemView.findViewById(R.id.salesman_payment);*/
        }
    }
}
