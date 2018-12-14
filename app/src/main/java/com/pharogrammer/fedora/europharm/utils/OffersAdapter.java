package com.pharogrammer.fedora.europharm.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pharogrammer.fedora.europharm.R;
import com.pharogrammer.fedora.europharm.http.data.OfferDrug;

import java.util.List;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersHolder> {


    List<OfferDrug> offerDrugs;

    public OffersAdapter(List<OfferDrug> offerDrugs) {
        this.offerDrugs = offerDrugs;
    }

    @NonNull
    @Override
    public OffersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_row,parent,false);
        return new OffersHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersHolder holder, int position) {

        OfferDrug offerDrug = offerDrugs.get(position);

        holder.offerDrugNameText.setText(offerDrug.getDrugName());
        holder.offerFromText.setText(String.valueOf(offerDrug.getDrugFrom()));
        holder.offerToText.setText(String.valueOf(offerDrug.getDrugTo()));
        holder.offerDiscountText.setText(String.valueOf(offerDrug.getDrugDiscount()));
    }

    @Override
    public int getItemCount() {
        return offerDrugs.size();
    }

    public static class OffersHolder extends RecyclerView.ViewHolder {

        TextView offerDrugNameText, offerFromText, offerToText, offerDiscountText;
        public OffersHolder(View itemView) {
            super(itemView);
            offerDrugNameText = itemView.findViewById(R.id.tv_offer_drug_name);
            offerFromText = itemView.findViewById(R.id.tv_offer_from);
            offerToText = itemView.findViewById(R.id.tv_offer_to);
            offerDiscountText = itemView.findViewById(R.id.tv_offer_discount);
        }
    }
}
