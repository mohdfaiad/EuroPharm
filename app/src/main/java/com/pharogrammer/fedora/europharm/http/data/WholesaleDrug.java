package com.pharogrammer.fedora.europharm.http.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * WholesaleDrug is data model of whole sale drugs
 * it's parent is DeficientDrug class that extends from BaseDrug
 *
 */
public class WholesaleDrug extends DeficientDrug {


    @SerializedName("min_quantity")
    @Expose
    private int minQuantity;

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }


}