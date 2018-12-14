package com.pharogrammer.fedora.europharm.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.BaseDrug;

import java.util.List;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.DrugHolder> {

    List<BaseDrug> drugs;

    public DrugsAdapter(List<BaseDrug> drugs) {
        this.drugs = drugs;
    }

    @NonNull
    @Override
    public DrugHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drug_row,parent,false);

        return new DrugHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugHolder holder, int position) {

        BaseDrug drug = drugs.get(position);

        holder.tvDrugName.setText(drug.getDrugName());
        holder.tvDrugPrice.setText(String.valueOf(drug.getDrugPrice()));
        holder.tvDrugDiscount.setText(String.valueOf(drug.getDrugDiscount()));

    }

    @Override
    public int getItemCount() {
        return drugs.size();
    }

    public static class DrugHolder extends RecyclerView.ViewHolder{

        TextView tvDrugName , tvDrugPrice , tvDrugDiscount;
        public DrugHolder(View itemView) {
            super(itemView);

            tvDrugName = itemView.findViewById(R.id.tv_drug_name);
            tvDrugPrice = itemView.findViewById(R.id.tv_price);
            tvDrugDiscount = itemView.findViewById(R.id.tv_discount);
        }
    }
}
