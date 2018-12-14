package com.pharogrammer.fedora.europharm.http.data;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * DeficientDrug is the data model for Deficient drugs
 * it's the parent of Wholesale drugs
 */
public class DeficientDrug extends BaseDrug {

    @SerializedName("max_quantity")
    @Expose
    protected int maxQuantity;

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
