package com.pharogrammer.fedora.europharm.http.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * OfferDrug data model for offer drug it's parent is BaseDrug
 */
public class OfferDrug extends BaseDrug {

    @SerializedName("brand_from")
    @Expose
    private int drugFrom;

    @SerializedName("brand_to")
    @Expose
    private int drugTo;

    public int getDrugFrom() {
        return drugFrom;
    }

    public void setDrugFrom(int drugFrom) {
        this.drugFrom = drugFrom;
    }

    public int getDrugTo() {
        return drugTo;
    }

    public void setDrugTo(int drugTo) {
        this.drugTo = drugTo;
    }
}
